package br.com.aocbmma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.aocbmma.service.SocioService;


@Controller
public class AdminController{

    @Autowired
    private SocioService socioService;

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String pageLogin() {
        return "paginas-sistema/login";
    }
    
    @RequestMapping(value="/admin", method=RequestMethod.GET)
    public ModelAndView pageSistema() {
        ModelAndView mv = new ModelAndView("paginas-sistema/admin/index");
        mv.addObject("aniversariantes", socioService.getAniversariantesDoMes());
        mv.addObject("sociosSolicitados", socioService.getSociosSolicitados());
        return mv;
    }

    @RequestMapping(value="/admin/relacao-associados", method=RequestMethod.GET)
    public ModelAndView pageRelacaoAssociados() {
        ModelAndView mv = new ModelAndView("paginas-sistema/admin/associados/relacao-associados");
        mv.addObject("associados", socioService.getTodosOsSocios());
        return mv;
    }

    
    
}