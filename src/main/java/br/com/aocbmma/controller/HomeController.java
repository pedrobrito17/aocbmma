package br.com.aocbmma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.ReservaCampoFutebolService;
import br.com.aocbmma.service.ReservaChaleService;
import br.com.aocbmma.service.ReservaEspacoCajueiroService;
import br.com.aocbmma.service.SocioService;

@Controller
public class HomeController{

    @Autowired
    private SocioService socioService;

    @Autowired
    private ReservaEspacoCajueiroService reservaCajueiroService;

    @Autowired
    private ReservaCampoFutebolService reservaCampoService;

    @Autowired
    private ReservaChaleService reservaChaleService;

    private Socio socioLogado = null;

    private ModelAndView mv = null;
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView pageIndex() {
        reservaCampoService.cancelarReservarComPagamentoVencido();
        reservaCajueiroService.cancelarReservarComPagamentoVencido();
        reservaChaleService.cancelarReservarComPagamentoVencido();

        socioLogado = socioService.getSocioByEmail();
        
        mv = new ModelAndView("paginas-sistema/index");
        mv.addObject("aniversariantes", socioService.getAniversariantesDoMes());
        mv.addObject("socio", socioLogado);
        mv.addObject("aniversariantes", socioService.getAniversariantesDoMes());
        mv.addObject("sociosSolicitados", socioService.getSociosSolicitados());
        mv.addObject("eventCampo", reservaCampoService.getReservaCampoSolicitada());
        mv.addObject("eventCajueiro", reservaCajueiroService.getReservaEspacoCajueiroSolicita());
        mv.addObject("eventChale", reservaChaleService.getReservasChaleSolicitas());
        return mv;
    }
}