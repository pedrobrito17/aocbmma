package br.com.aocbmma.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.aocbmma.helper.FormatadorData;
import br.com.aocbmma.model.PagamentoMensalidade;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.model.SocioTransferencia;
import br.com.aocbmma.model.aux.DadosAdimplencia;
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

    //obtém o objeto do sócio por meio do scopo da sessão criado em SocioService
    @Resource(name = "getSessionScopedSocio") 
    private Socio socioSession;

    @GetMapping(value="/admin/controle-pagamento")
    public ModelAndView pageControlePagamento() {
        mv = new ModelAndView("paginas-sistema/admin/financeiro/controle-pagamento");
        mv.addObject("socio", socioSession);
        mv.addObject("todosSocios", socioService.findAllNomesSocios());
        return mv;
    }    

    @GetMapping(value="/admin/lista-adimplencia")
    public ModelAndView pageListaAdimplencia() {
        mv = new ModelAndView("paginas-sistema/admin/financeiro/lista-adimplencia");
        mv.addObject("socio", socioSession);
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
        pagamentoMensalidadeService.verificacaoDePagamentoNaoInseridoNoControleDePagamento(socioTransferencia, datas_mensalidades);
        pagamentoMensalidadeService.salvarPagamentos(socioTransferencia, dataDoPagamento, datas_mensalidades);
        pagamentoMensalidadeService.registrarStatusDoSocioTransferencia(socioTransferencia);
        
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

    @GetMapping(value="/admin/buscar-dados-adimplencia/{cod}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getDadosAdimplenciaDoSocioTransferenciaEmJson(@PathVariable("cod") int cod) {

        List<PagamentoMensalidade> pags = pagamentoMensalidadeService.getDadosAdimplenciaDoSocioTransferencia(cod);
        DadosAdimplencia dadosAdimplencia = new DadosAdimplencia().criarObjetoDadosAdimplencia(pags);
        
        String dadosJson = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            dadosJson = objectMapper.writeValueAsString(dadosAdimplencia);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
        return dadosJson;
    }

    @PostMapping(value="/admin/atualizar-inadimplencia")
    public ModelAndView postAtualizarInadimplencia() {
        socioTransferenciaService.inserirInadimplenciaReferenteAoMesAnterior();
        ModelAndView mv = pageListaAdimplencia();
        mv.addObject("msgSuccess","Os sócios com a mensalidade do mês passado em atraso foram atualizados para o status de inadimplente.");
        return mv;
    }
    


    
}