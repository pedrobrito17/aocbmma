package br.com.aocbmma.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.aocbmma.model.EspacoCajueiro;
import br.com.aocbmma.model.ReservaEspacoCajueiro;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.repository.EspacoCajueiroRepository;
import br.com.aocbmma.repository.ReservaEspacoCajueiroRepository;

@Service
public class ReservaEspacoCajueiroService{

    @Autowired
    private ReservaEspacoCajueiroRepository reservaCajueiroRepository;

    @Autowired
    private EspacoCajueiroRepository cajueiroRepository;

    @Autowired
    private SocioService socioService;

    @Transactional
    public void salvarReserva(ReservaEspacoCajueiro reserva){
        Socio socio = socioService.getSocioByEmail();
        reserva.setSocio(socio);
        reserva.setValor_reserva(calcularValorReserva(reserva));
        reservaCajueiroRepository.save(reserva);
    }

    public float calcularValorReserva(ReservaEspacoCajueiro reserva){
        EspacoCajueiro espacoCajueiro = cajueiroRepository.findById(1).get();
        String periodo = reserva.getPeriodo();

        switch (periodo){
            case "diurno":
                return espacoCajueiro.getPrecoAtual_diurno();
            case "noturno":
                return espacoCajueiro.getPrecoAtual_noturno();
            case "diária":
                return espacoCajueiro.getPrecoAtual_diaria();
            default:
                return 0;
        }
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

    public List<ReservaEspacoCajueiro> getMinhasReserva(){
        Socio socio = socioService.getSocioByEmail();
        return reservaCajueiroRepository.findBySocio(socio.getId());
    }

    public List<ReservaEspacoCajueiro> getReservasDoClube(){
        return reservaCajueiroRepository.findAllOrd();
    }

    @Transactional
    public void cancelarReservarComPagamentoVencido(){
        List<ReservaEspacoCajueiro> reservasASeremCanceladas = reservaCajueiroRepository.findReservasPagamentoVencido();
        if(reservasASeremCanceladas!=null){
            for (ReservaEspacoCajueiro reserva : reservasASeremCanceladas) {
                reserva.setPagamento("vencido");
                reservaCajueiroRepository.save(reserva);
            }
        }
    }

	public void deletarReserva(int id_reserva) {
        reservaCajueiroRepository.deleteById(id_reserva);
	}

	public boolean socioPossuiReservaNesteMes(ReservaEspacoCajueiro reserva) {
        Date dataReserva = reserva.getData_reserva();
        int idSocioLogado =  socioService.getSocioByEmail().getId();

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dataReserva);
        int mesDaReserva = calendar.get(Calendar.MONTH)+1;

        ReservaEspacoCajueiro temReserva = reservaCajueiroRepository.socioPossuiReservaCajueiroNoMesSolicitado(mesDaReserva, idSocioLogado);
        if(temReserva == null){
            return false;
        }
        return true;
	}

}