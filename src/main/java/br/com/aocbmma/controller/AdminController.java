package br.com.aocbmma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.ReservaCampoFutebolService;
import br.com.aocbmma.service.ReservaChaleService;
import br.com.aocbmma.service.ReservaEspacoCajueiroService;
import br.com.aocbmma.service.SocioService;
import br.com.aocbmma.service.SolicitacaoCarteiraIdentificacaoService;



@Controller
public class AdminController{

    @Autowired
    private SocioService socioService;

    @Autowired
    private ReservaCampoFutebolService reservaCampoService;

    @Autowired
    private ReservaEspacoCajueiroService reservaCajueiroService;

    @Autowired
    private ReservaChaleService reservaChaleService;

    @Autowired
    private SolicitacaoCarteiraIdentificacaoService solicitacaoCarteiraIdentificacaoService;

    private ModelAndView mv = null;

    private Socio socioLogado = null;

    @RequestMapping(value="/admin/socios/{categoria}", method=RequestMethod.GET)
    public ModelAndView pageRelacaoAssociados(@PathVariable("categoria") String categoria) {

        socioLogado = socioService.getSocioByEmail();
        
        mv = new ModelAndView("paginas-sistema/admin/associados/relacao-socios");
        mv.addObject("socios", socioService.getSociosDesta(categoria));
        mv.addObject("categoria", categoria);
        mv.addObject("socio", socioLogado);
        return mv;
    }
    
    @GetMapping(value="/admin/reservas-clube")
    public ModelAndView pageReservasClube() {
        socioLogado = socioService.getSocioByEmail();
        
        mv = new ModelAndView("paginas-sistema/admin/reservas-clube");
        mv.addObject("eventCampo", reservaCampoService.getReservasDoClube());
        mv.addObject("eventCajueiro", reservaCajueiroService.getReservasDoClube());
        mv.addObject("eventChale", reservaChaleService.getReservasDoClube());
        mv.addObject("socio", socioLogado);
        return mv;
    }    
    
    @GetMapping(value="/admin/dados-socio/{id}")
    public ModelAndView pageDadosSocio(@PathVariable("id") int id) {
        socioLogado = socioService.getSocioByEmail();
        
        mv = new ModelAndView("paginas-sistema/admin/associados/dados-socio");
        mv.addObject("socioFind", socioService.findSocio(id));
        mv.addObject("socio", socioLogado);
        return mv;
    }

    @RequestMapping(value="/admin/carteira-pronta/{cod}",  method=RequestMethod.GET)
    public ModelAndView postAtualizarStatusDaSolicitacaoCarteira(@PathVariable("cod") String cod) {
        int id = Integer.parseInt(cod);
        solicitacaoCarteiraIdentificacaoService.atualizarStatusParaPronta(id);
        mv = new ModelAndView("redirect:/");
        return mv;
    }
    

}