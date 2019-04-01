package br.com.aocbmma.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aocbmma.model.Chale;
import br.com.aocbmma.model.ReservaChale;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.repository.ChaleRepository;
import br.com.aocbmma.repository.ReservaChaleRepository;

@Service
public class ReservaChaleService{
    
    @Autowired
    private ReservaChaleRepository reservaRepository;

    @Autowired
    private ChaleRepository chaleRepository;

    @Autowired
    private SocioService socioService;

    @Transactional
    public List<Chale> verificarDisponibilidadeChale(Date data_entrada, Date data_saida){
        List<ReservaChale> reservaConfirmada = reservaRepository.buscarReservaQueCoincidaComAPesquisada(data_entrada, data_saida);
        List<Chale> todosChalesAtivos = chaleRepository.findByDisponivel(true);

        for (ReservaChale reservas : reservaConfirmada) {
            todosChalesAtivos.remove(reservas.getChale());
        }

        return todosChalesAtivos;
    }

    @Transactional
    public void salvarReserva(ReservaChale reserva){
        Socio socio = socioService.getSocioByEmail();
        reserva.setSocio(socio);
        reserva.setValor_reserva( calculaValorDaReserva(reserva) );
        reservaRepository.save(reserva);
    }

    public float calculaValorDaReserva(ReservaChale reserva){
        int qtdDias = calcularQntdDiasReserva(reserva);
        float valor = reserva.getChale().getprecoAtual();
        return (qtdDias * valor);
    }

    public int calcularQntdDiasReserva(ReservaChale reserva){
        Calendar dt_ini = Calendar.getInstance();
        Calendar dt_fim = Calendar.getInstance();

        dt_ini.setTime(reserva.getData_entrada());
        dt_fim.setTime(reserva.getData_saida());

        return ( dt_fim.get(Calendar.DAY_OF_YEAR) - dt_ini.get(Calendar.DAY_OF_YEAR) );
    }

    public List<ReservaChale> getReservasChaleSolicitas(){
        return reservaRepository.findByPagamento("pendente");
    }

    @Transactional
    public void confirmarReserva(Integer id){
        ReservaChale reserva = reservaRepository.findById(id).get();
        reserva.setPagamento("realizado");
        reservaRepository.save(reserva);
    }

    public List<ReservaChale> getMinhasReservas(){
        Socio socio = socioService.getSocioByEmail();
        return reservaRepository.findBySocio(socio.getId());
    }

    public List<ReservaChale> getReservasDoClube(){
        return reservaRepository.findAllDiferenteDePagamentoVencido();
    }
}