package br.com.aocbmma.service;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.aocbmma.model.ReservaEspacoCajueiro;
import br.com.aocbmma.repository.ReservaEspacoCajueiroRepository;

@Service
public class ReservaEspacoCajueiroService{

    @Autowired
    private ReservaEspacoCajueiroRepository reservaCajueiroRepository;

    public void salvarReserva(ReservaEspacoCajueiro reserva){
        reservaCajueiroRepository.save(reserva);
    }

    public List<ReservaEspacoCajueiro> getReservaEspacoCajueiroSolicita(){
        return reservaCajueiroRepository.selectReservasPendentes();
    }

    @Transactional
    public void confirmarReserva(int id){
        ReservaEspacoCajueiro reserva = reservaCajueiroRepository.findById(id).get();
        reserva.setPagamento("realizado");
        reservaCajueiroRepository.save(reserva);
    }

    public List<String> getDatasReservasRealizadas(){
        return reservaCajueiroRepository.findDatasReservasRealizadas();
    }

}