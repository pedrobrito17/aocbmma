package br.com.aocbmma.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aocbmma.model.CampoFutebol;
import br.com.aocbmma.model.ReservaCampoFutebol;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.repository.CampoFutebolRepository;
import br.com.aocbmma.repository.ReservaCampoFutebolRepository;

@Service
public class ReservaCampoFutebolService{

    @Autowired
    private ReservaCampoFutebolRepository reservaCampoFutebolRepository;

    @Autowired
    private CampoFutebolRepository campoRepository;

    @Autowired
    private SocioService socioService;

    ArrayList<String> listaSrting = new ArrayList<String>();

    public void salvarReservaCampoFutebol(ReservaCampoFutebol reserva){
        Socio socio = socioService.getSocioByEmail();
        reserva.setSocio(socio);
        reserva.setValor_reserva(calcularValorReserva(reserva));
        reservaCampoFutebolRepository.save(reserva);
    }

    public float calcularValorReserva(ReservaCampoFutebol reserva){
        Calendar h_ini = Calendar.getInstance();
        Calendar h_fim = Calendar.getInstance();
        
        h_ini.setTime(reserva.getHora_inicio());
        h_fim.setTime(reserva.getHora_termino());
        int num_ini = h_ini.get(Calendar.HOUR_OF_DAY);
        int num_fim = h_fim.get(Calendar.HOUR_OF_DAY);

        int diurno = 0;
        int noturno = 0;
        for(int i = num_ini ; i < num_fim ; i++){
            if( (i>=8 && i<18) && ((i+1)>=8 && (i+1)<=18) ){
                diurno++;
            }
            else if( (i>=18 && i<=22) && ((i+1)>18 && (i+1)<=22) ){
                noturno++;
            }
        }

        CampoFutebol campoFutebol = campoRepository.findById(1).get();
        return (diurno*campoFutebol.getPrecoAtual_diurno()) + (noturno*campoFutebol.getPrecoAtual_noturno());
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

    public List<ReservaCampoFutebol> getReservaCampoSolicitada(){
        return reservaCampoFutebolRepository.selectReservaCampoSolicitada();
    }

    @Transactional
    public void confirmarReserva(int id){
        ReservaCampoFutebol reserva = reservaCampoFutebolRepository.findById(id).get();
        reserva.setPagamento("realizado");
        reservaCampoFutebolRepository.save(reserva);
    }

    public List<ReservaCampoFutebol> getMinhasReserva(){
        Socio socio = socioService.getSocioByEmail();
        return reservaCampoFutebolRepository.findBySocio(socio.getId());
    }

    public List<ReservaCampoFutebol> getReservasDoClube(){
        return reservaCampoFutebolRepository.findAllOrd();
    }

    @Transactional
    public void cancelarReservarComPagamentoVencido(){
        List<ReservaCampoFutebol> reservasASeremCanceladas = reservaCampoFutebolRepository.findReservasPagamentoVencido();
        if(reservasASeremCanceladas!=null){
            for (ReservaCampoFutebol reserva : reservasASeremCanceladas) {
                reserva.setPagamento("vencido");
                reservaCampoFutebolRepository.save(reserva);
            }
        }
    }

	public void deletarReserva(int id_reserva) {
        reservaCampoFutebolRepository.deleteById(id_reserva);
	}
}