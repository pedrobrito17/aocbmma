package br.com.aocbmma.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aocbmma.helper.FormatadorData;
import br.com.aocbmma.model.PagamentoMensalidade;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.model.SocioTransferencia;
import br.com.aocbmma.repository.PagamentoMensalidadeRepository;

@Service
public class PagamentoMensalidadeService {

    @Autowired
    private PagamentoMensalidadeRepository repository;

    @Autowired
    private SocioTransferenciaService socioTransferService;

    @Transactional
    public void salvarPagamentos(SocioTransferencia socioTransferencia, Date data_pagamento, List<Date> datas_mensalidades) {
        
        PagamentoMensalidade pagamento_mensalidade = null;

        for (Date mes_pago : datas_mensalidades) {

            if(naoHaRegistroDaMensalidade(socioTransferencia.getCod(), mes_pago)){
                pagamento_mensalidade = new PagamentoMensalidade();
                pagamento_mensalidade.setSocio(socioTransferencia);
                pagamento_mensalidade.setData_pagamento(data_pagamento);
                pagamento_mensalidade.setData_mensalidade(mes_pago);
                repository.save(pagamento_mensalidade);
            }
            else{
                PagamentoMensalidade pagamento = repository.findBySocioAndDataMensalidade(socioTransferencia.getCod(), mes_pago);
                pagamento.setData_pagamento(data_pagamento);
                repository.save(pagamento);
            }

        }
    }

    public boolean naoHaRegistroDaMensalidade(int socio_id, Date data_mensalidade){
        PagamentoMensalidade pagamento = repository.findBySocioAndDataMensalidade(socio_id, data_mensalidade);
        if(pagamento == null){
            return true;
        }
        else{
            return false;
        }
    }

    public void verificacaoDePagamentoNaoInseridoNoControleDePagamento(SocioTransferencia socioTransfer, List<Date> datas_mensalidades){
               
        int mes_inicial = getNumeroDoMesDestaData(datas_mensalidades.get(0));
        int cont = 0;

        for (Date data : datas_mensalidades) {

            int mes_seguinte = getNumeroDoMesDestaData(data);
            
            if(mes_inicial == mes_seguinte){
                cont++;
                continue;
            }
            else if( (mes_inicial+cont) == mes_seguinte ){
                cont++;
                continue;
            }
            else{ //inadimplente (não pagou o mês seguinte)
                int mes_nao_pago = mes_inicial + cont + 1;
                List<Date> listaDataMensalidadeNaoPaga = getListDataDaMensalidadeNaoPaga(mes_nao_pago, data);
                registrarMensalidadeNaoPaga(socioTransfer, listaDataMensalidadeNaoPaga);
            }
        }
    }
    
    public int getNumeroDoMesDestaData(Date data){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        return calendar.get(Calendar.MONTH);
    }
    
    public int getAnoDestaData(Date data){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        return calendar.get(Calendar.YEAR);
    }
    
    public List<Date> getListDataDaMensalidadeNaoPaga(int mesNaoPago, Date dataBase){
        int ano = getAnoDestaData(dataBase);
        Date data_da_mensalidade_nao_paga = FormatadorData.getDataFormatadaNoPadraoSQL(ano+"-"+mesNaoPago+"-01");
        
        List<Date> lista_data_da_mensalidade_nao_paga = new ArrayList<Date>();
        lista_data_da_mensalidade_nao_paga.add(data_da_mensalidade_nao_paga);
        return lista_data_da_mensalidade_nao_paga;
    }
    
    public void registrarMensalidadeNaoPaga(SocioTransferencia socioTransfer, List<Date> dataMensalidadeNaoPaga){
        salvarPagamentos(socioTransfer, null, dataMensalidadeNaoPaga);
    }

    public void registrarStatusDoSocioTransferencia(SocioTransferencia socioTransfer){
        if(socioEstaInadimplente(socioTransfer)){
            socioTransferService.registrarInadimplenciaDoSocio(socioTransfer);
        }
        else{
            socioTransferService.registrarAdimplenciaDoSocio(socioTransfer);
        }
    }

    public boolean socioEstaInadimplente(SocioTransferencia socioTransfer){
        List<PagamentoMensalidade> pag = repository.getInadimplenciaDoSocio(socioTransfer.getCod());
        boolean existeMensalidadeNaoPaga = !pag.isEmpty();
        if(existeMensalidadeNaoPaga){
            return true;
        }
        else{
            return false;
        }
    }

	public List<PagamentoMensalidade> getDadosAdimplenciaDoSocioTransferencia(int cod) {
        List<PagamentoMensalidade> dadosInadimplencia = repository.getInadimplenciaDoSocio(cod);
        
        if(!dadosInadimplencia.isEmpty()){
            return dadosInadimplencia;
        }
        else{
            List<PagamentoMensalidade> dadosAdimplencia = repository.getAdimplenciaDoSocio(cod);
            return dadosAdimplencia;
        }
	}

	public List<PagamentoMensalidade> getDadosAdimplenciaDo(Socio socioLogado) {
        try{
            SocioTransferencia socioTransfer = socioTransferService.getSocio(socioLogado);
            return repository.findBySocioOrderByDataPagamentoDesc( socioTransfer.getCod() );
        }catch(NullPointerException e){
            return null;
        }
	}

	public Date getDataDaUltimaMensalidadeRegistrada(int mes_ultima_mensalidade) {
        PagamentoMensalidade pag = repository.getPagamentoMensalidadeDoUltimoMes(mes_ultima_mensalidade);
        Date data = pag.getData_mensalidade();
		return data;
	}

    @Transactional
    public void inserirMensalidadesComPagamentosAtrasados(List<SocioTransferencia> sociosMensalidadesAtrasadas, 
            Date data_ultima_mensalidade, int mes_ultima_mensalidade) {
        for (SocioTransferencia socio : sociosMensalidadesAtrasadas) {

            PagamentoMensalidade pagMensalidadeEmAtraso = new PagamentoMensalidade();
            pagMensalidadeEmAtraso.setSocio(socio);
            pagMensalidadeEmAtraso.setData_mensalidade(data_ultima_mensalidade);
            pagMensalidadeEmAtraso.setData_pagamento(null);
            repository.save(pagMensalidadeEmAtraso);

        }
	}

	public List<PagamentoMensalidade> getMensalidadesComPagamentoNull() {
		return repository.getMensalidadesSemPagamento();
	}

}