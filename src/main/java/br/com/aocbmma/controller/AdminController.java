package br.com.aocbmma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.aocbmma.service.ReservaCampoFutebolService;
import br.com.aocbmma.service.ReservaChaleService;
import br.com.aocbmma.service.ReservaEspacoCajueiroService;
import br.com.aocbmma.service.SocioService;



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

    private ModelAndView mv = null;

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String pageLogin() {
        return "paginas-sistema/login";
    }
    
    @RequestMapping(value="/admin", method=RequestMethod.GET)
    public ModelAndView pageSistema() {
        reservaCampoService.cancelarReservarComPagamentoVencido();
        reservaCajueiroService.cancelarReservarComPagamentoVencido();
        reservaChaleService.cancelarReservarComPagamentoVencido();

        mv = new ModelAndView("paginas-sistema/admin/index");
        mv.addObject("aniversariantes", socioService.getAniversariantesDoMes());
        mv.addObject("sociosSolicitados", socioService.getSociosSolicitados());
        mv.addObject("eventCampo", reservaCampoService.getReservaCampoSolicitada());
        mv.addObject("eventCajueiro", reservaCajueiroService.getReservaEspacoCajueiroSolicita());
        mv.addObject("eventChale", reservaChaleService.getReservasChaleSolicitas());
        return mv;
    }

    @RequestMapping(value="/admin/socios/{categoria}", method=RequestMethod.GET)
    public ModelAndView pageRelacaoAssociados(@PathVariable("categoria") String categoria) {
        mv = new ModelAndView("paginas-sistema/admin/associados/relacao-socios");
        mv.addObject("socios", socioService.getSociosDesta(categoria));
        mv.addObject("categoria", categoria);
        return mv;
    }

    @GetMapping(value="/admin/reservas-clube")
    public ModelAndView pageReservasClube() {
        mv = new ModelAndView("paginas-sistema/admin/reservas-clube");
        mv.addObject("eventCampo", reservaCampoService.getReservasDoClube());
        mv.addObject("eventCajueiro", reservaCajueiroService.getReservasDoClube());
        mv.addObject("eventChale", reservaChaleService.getReservasDoClube());
        return mv;
    }    

    @GetMapping(value="/admin/dados-socio/{id}")
    public ModelAndView pageDadosSocio(@PathVariable("id") int id) {
        mv = new ModelAndView("paginas-sistema/admin/associados/dados-socio");
        mv.addObject("socio", socioService.findSocio(id));
        return mv;
    }
    
    
}