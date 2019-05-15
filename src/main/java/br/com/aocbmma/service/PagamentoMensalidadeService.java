package br.com.aocbmma.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aocbmma.model.PagamentoMensalidade;
import br.com.aocbmma.model.SocioTransferencia;
import br.com.aocbmma.repository.PagamentoMensalidadeRepository;

@Service
public class PagamentoMensalidadeService {

    @Autowired
    private PagamentoMensalidadeRepository repository;

    @Transactional
    public void salvarPagamentos(SocioTransferencia socioTransferencia, Date data_pagamento, List<Date> datas_mensalidades) {
        
        PagamentoMensalidade pagamento_mensalidade = null;

        for (Date mes_pago : datas_mensalidades) {

            if(NaohouvePagamentoDestaMensalidade(socioTransferencia.getCod(), mes_pago)){
                pagamento_mensalidade = new PagamentoMensalidade();
                pagamento_mensalidade.setSocio(socioTransferencia);
                pagamento_mensalidade.setData_pagamento(data_pagamento);
                pagamento_mensalidade.setData_mensalidade(mes_pago);
                repository.save(pagamento_mensalidade);
            }

        }
    }

    public boolean NaohouvePagamentoDestaMensalidade(int socio_id, Date data_mensalidade){
        PagamentoMensalidade pagamento = repository.findBySocioAndDataPagamento(socio_id, data_mensalidade);
        if(pagamento == null){
            return true;
        }
        else{
            return false;
        }
    }

}