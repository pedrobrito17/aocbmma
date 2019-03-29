package br.com.aocbmma.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aocbmma.model.Chale;
import br.com.aocbmma.model.ReservaChale;
import br.com.aocbmma.repository.ChaleRepository;
import br.com.aocbmma.repository.ReservaChaleRepository;

@Service
public class ReservaChaleService{
    
    @Autowired
    private ReservaChaleRepository reservaRepository;

    @Autowired
    private ChaleRepository chaleRepository;

    @Transactional
    public List<Chale> verificarDisponibilidadeChale(Date data_entrada, Date data_saida){
        List<ReservaChale> reservaConfirmada = reservaRepository.buscarReservaQueCoincidaComAPesquisada(data_entrada, data_saida);
        List<Chale> todosChalesAtivos = chaleRepository.findByDisponivel(true);

        for (ReservaChale reservas : reservaConfirmada) {
            todosChalesAtivos.remove(reservas.getChale());
        }

        return todosChalesAtivos;
    }

    public void salvarReserva(ReservaChale reserva){
        reservaRepository.save(reserva);
    }
}