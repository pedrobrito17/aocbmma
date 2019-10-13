package br.com.aocbmma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aocbmma.model.DatasBloqueadas;
import br.com.aocbmma.repository.DatasBloqueadasRepository;

@Service
public class DatasBloqueadasService{

    @Autowired
    private DatasBloqueadasRepository datasBloqueadasRepository;

	public void salvarDataBloqueada(DatasBloqueadas datasBloqueadas) {
        datasBloqueadasRepository.save(datasBloqueadas);
    }
    
    public List<DatasBloqueadas> getTodasDatasBloqueadas(){
        return datasBloqueadasRepository.findAllByOrderByDataDesc();
    }

	public void deletarDataBloqueada(int id) {
        datasBloqueadasRepository.deleteById(id);
	}

}