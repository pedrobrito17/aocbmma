package br.com.aocbmma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.aocbmma.service.ReservaCampoFutebolService;
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

    private ModelAndView mv = null;

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String pageLogin() {
        return "paginas-sistema/login";
    }
    
    @RequestMapping(value="/admin", method=RequestMethod.GET)
    public ModelAndView pageSistema() {
        mv = new ModelAndView("paginas-sistema/admin/index");
        mv.addObject("aniversariantes", socioService.getAniversariantesDoMes());
        mv.addObject("sociosSolicitados", socioService.getSociosSolicitados());
        mv.addObject("eventCampo", reservaCampoService.getReservaCampoSolicitada());
        mv.addObject("eventCajueiro", reservaCajueiroService.getReservaEspacoCajueiroSolicita());
        return mv;
    }

    @RequestMapping(value="/admin/relacao-associados", method=RequestMethod.GET)
    public ModelAndView pageRelacaoAssociados() {
        mv = new ModelAndView("paginas-sistema/admin/associados/relacao-associados");
        mv.addObject("associados", socioService.getTodosOsSocios());
        return mv;
    }

    
    
}