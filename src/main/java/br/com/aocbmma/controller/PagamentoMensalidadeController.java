package br.com.aocbmma.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.aocbmma.helper.FormatadorData;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.model.SocioTransferencia;
import br.com.aocbmma.service.PagamentoMensalidadeService;
import br.com.aocbmma.service.SocioService;
import br.com.aocbmma.service.SocioTransferenciaService;

@Controller
public class PagamentoMensalidadeController{

    @Autowired
    private PagamentoMensalidadeService pagamentoMensalidadeService;

    @Autowired SocioTransferenciaService socioTransferenciaService;

    @Autowired
    private SocioService socioService;

    private ModelAndView mv = null;

    private Socio socioLogado = null;

    @GetMapping(value="/admin/controle-pagamento")
    public ModelAndView pageControlePagamento() {
        socioLogado = socioService.getSocioByEmail();
        
        mv = new ModelAndView("paginas-sistema/admin/financeiro/controle-pagamento");
        mv.addObject("socio", socioLogado);
        mv.addObject("todosSocios", socioService.findAllNomesSocios());
        return mv;
    }    

    @GetMapping(value="/admin/lista-adimplencia")
    public ModelAndView pageListaAdimplencia() {
        socioLogado = socioService.getSocioByEmail();
        
        mv = new ModelAndView("paginas-sistema/admin/financeiro/lista-adimplencia");
        mv.addObject("socio", socioLogado);
        mv.addObject("sociosAdimplencia", socioTransferenciaService.getSociosInadimplentesEAdimplentes());
        return mv;
    }    

    @PostMapping(value="/admin/registrar-pagamento")
    public ModelAndView postRegistrarPagamento(@RequestParam String nomeSocio, 
        @RequestParam("mes_pago") List<String> meses_pagos, @RequestParam int ano, @RequestParam String data_pagamento) {

        Socio socio = socioService.findSocioByNome(nomeSocio);
        
        Date dataDoPagamento = FormatadorData.getDataFormatadaNoPadraoSQL(data_pagamento);
        List<Date> datas_mensalidades = getListaDeDatasMensalidade(meses_pagos, ano);
        Date dataAdesao = datas_mensalidades.get(0);
        SocioTransferencia socioTransferencia = socioTransferenciaService.salvarSocio(socio, dataAdesao);

        pagamentoMensalidadeService.salvarPagamentos(socioTransferencia, dataDoPagamento, datas_mensalidades);
        
        mv = pageControlePagamento();
        mv.addObject("msg", "Pagamento registrado.");
        return mv;
    }
    
    public List<Date> getListaDeDatasMensalidade(List<String> meses_pagos, int ano){
        
        List<Date> datas_mensalidades = new ArrayList<>();
        
        for (String mes_pago : meses_pagos) {
            Date data = FormatadorData.getDataFormatadaNoPadraoSQL(ano+"-"+mes_pago+"-01");
            datas_mensalidades.add(data);
        }

        return datas_mensalidades;
    }


}