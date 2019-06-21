package br.com.aocbmma.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aocbmma.model.PagamentoMensalidade;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.model.SocioTransferencia;
import br.com.aocbmma.repository.SocioTransferenciaRepository;

@Service
public class SocioTransferenciaService{

	@Autowired
	private SocioTransferenciaRepository socioTransferenciaRepository;

	@Autowired
	private PagamentoMensalidadeService pagamentoMensalidadeService;

	private SocioTransferencia socioTransferencia;

	public SocioTransferencia salvarSocio(Socio socio, Date menorDataMensalidade) {
		
		if( socioTransferenciaExiste(socio) ){
			if( dataDeAdesaoDoSocioEMaiorQueAMensalidadePaga(menorDataMensalidade) ){
				socioTransferencia.setData_adesao(menorDataMensalidade);
				return socioTransferenciaRepository.save(socioTransferencia);
			}
			return socioTransferencia;
		}
		else{
			socioTransferencia = new SocioTransferencia();
			socioTransferencia.setSocio(socio);
			socioTransferencia.setData_adesao(menorDataMensalidade);
			socioTransferencia.setStatus("adimplente");
			return socioTransferenciaRepository.save(socioTransferencia);
		}
	}

	public boolean dataDeAdesaoDoSocioEMaiorQueAMensalidadePaga(Date dataAdesaoMensalidade){
		
		if(socioTransferencia.getData_adesao().compareTo(dataAdesaoMensalidade) > 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean socioTransferenciaExiste(Socio socio){
		
		socioTransferencia = socioTransferenciaRepository.findBySocio(socio);
		if(socioTransferencia != null){
			return true;
		}
		else{
			return false;
		}
	}

	public List<SocioTransferencia> getSociosInadimplentesEAdimplentes() {
		return socioTransferenciaRepository.findAll();
	}

	public void registrarInadimplenciaDoSocio(SocioTransferencia socio) {
		socio.setStatus("inadimplente");
		socioTransferenciaRepository.save(socio);
	}

	public void registrarAdimplenciaDoSocio(SocioTransferencia socio) {
		socio.setStatus("adimplente");
		socioTransferenciaRepository.save(socio);
	}

	@Transactional
	public void inserirInadimplenciaReferenteAoMesAnterior() {
		int mes_ultima_mensalidade = getNumeroDoMesDaUltimaMensalidade();
		Date data_ultima_mensalidade = pagamentoMensalidadeService.getDataDaUltimaMensalidadeRegistrada(mes_ultima_mensalidade);
		Date data_cobranca_mensalidade = getDataDaCobrancaMensaliade(data_ultima_mensalidade);

		if(dataAtualForMaiorOuIgualADataDaCobrancaDaMensalidade(data_cobranca_mensalidade)){
			List<SocioTransferencia> sociosMensalidadesAtrasadas = getSociosComMensalidadesAtrasadas(mes_ultima_mensalidade);
			if(!sociosMensalidadesAtrasadas.isEmpty()){
				pagamentoMensalidadeService.inserirMensalidadesComPagamentosAtrasados(sociosMensalidadesAtrasadas, data_ultima_mensalidade, mes_ultima_mensalidade);
				atualizarStatusDosSociosComMensalidadesAtrasadas();
			}
		}
	}

	private void atualizarStatusDosSociosComMensalidadesAtrasadas() {
		List<PagamentoMensalidade> mensalidadesSemPagamento = pagamentoMensalidadeService.getMensalidadesComPagamentoNull();
		for (PagamentoMensalidade pag : mensalidadesSemPagamento) {
			SocioTransferencia socio = pag.getSocio();
			socio.setStatus("inadimplente");
			socioTransferenciaRepository.save(socio);
		}
	}

	public boolean dataAtualForMaiorOuIgualADataDaCobrancaDaMensalidade(Date data_cobranca) {
		Date data_atual = Calendar.getInstance().getTime();
		int comparacao = data_atual.compareTo( data_cobranca );
		if( comparacao >= 0 ){
			return true;
		}else{
			return false;
		}
	}
	
	public Date getDataDaCobrancaMensaliade( Date data_ultima_mensalidade ){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data_ultima_mensalidade);
		calendar.add(Calendar.DATE, 30);
		Date data_cobranca_mensalidade = calendar.getTime(); 
		return data_cobranca_mensalidade;
	}

	public int getNumeroDoMesDaUltimaMensalidade(){
		Calendar calendar = Calendar.getInstance();
		int num_month_current = calendar.get(Calendar.MONTH) + 1;
		if(num_month_current == 1){
			return 12; //dezembro
		}
		else{
			return num_month_current - 1; 
		}
	}

	public SocioTransferencia getSocio(Socio socioLogado) {
		return socioTransferenciaRepository.findBySocio(socioLogado);
	}

	public String getStatusDeAdimplenciaDo(Socio socioLogado) {
		try{
			return socioTransferenciaRepository.findBySocio(socioLogado).getStatus();
		}catch(NullPointerException e){
			return "";
		}
	}

	public List<SocioTransferencia> getSociosComMensalidadesAtrasadas(int mes_ultima_mensalidade) {
		return socioTransferenciaRepository.getSociosComMensalidadesAtrasadas(mes_ultima_mensalidade);
	}
    
}