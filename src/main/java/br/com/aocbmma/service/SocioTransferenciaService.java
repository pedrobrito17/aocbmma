package br.com.aocbmma.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aocbmma.model.Socio;
import br.com.aocbmma.model.SocioTransferencia;
import br.com.aocbmma.repository.SocioTransferenciaRepository;

@Service
public class SocioTransferenciaService{

	@Autowired
	private SocioTransferenciaRepository socioTransferenciaRepository;

	private SocioTransferencia socioTransferencia;

	public SocioTransferencia salvarSocio(Socio socio, Date dataAdesaoMensalidade) {
		
		if( socioTransferenciaExiste(socio) ){
			if( dataDeAdesaoDoSocioEMaiorQueAMensalidadePaga(dataAdesaoMensalidade) ){
				socioTransferencia.setData_adesao(dataAdesaoMensalidade);
			}
			return socioTransferenciaRepository.save(socioTransferencia);
		}
		else{
			socioTransferencia = new SocioTransferencia();
			socioTransferencia.setSocio(socio);
			socioTransferencia.setData_adesao(dataAdesaoMensalidade);
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
    
}