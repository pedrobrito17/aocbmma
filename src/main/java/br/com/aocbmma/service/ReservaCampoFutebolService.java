package br.com.aocbmma.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aocbmma.model.ReservaCampoFutebol;
import br.com.aocbmma.repository.ReservaCampoFutebolRepository;

@Service
public class ReservaCampoFutebolService{

    @Autowired
    private ReservaCampoFutebolRepository reservaCampoFutebolRepository;

    ArrayList<String> listaSrting = new ArrayList<String>();

    public void salvarReservaCampoFutebol(ReservaCampoFutebol reserva){
        reservaCampoFutebolRepository.save(reserva);
    }

    public List<String> getHorasIniciais(Date data){
        List<Integer> listaInteger = reservaCampoFutebolRepository.selectHoraInicio(data);

        listaSrting.clear();
        int tam = listaInteger.size();
        
        for (int i=0 ; i < tam ; i++) {
            listaSrting.add(String.valueOf( listaInteger.get(i) ));
        }
        return listaSrting;
    }

    public List<String> getHorasTerminais(Date data){
        List<Integer> listaInteger = reservaCampoFutebolRepository.selectHoraTermino(data);

        listaSrting.clear();
        int tam = listaInteger.size();
        
        for (int i=0 ; i < tam ; i++) {
            listaSrting.add(String.valueOf( listaInteger.get(i) ));
        }
        return listaSrting;
    }
}