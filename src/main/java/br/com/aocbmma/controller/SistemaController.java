package br.com.aocbmma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.SocioService;



@Controller
@RequestMapping("/sisaocbmma")
public class SistemaController{

    @Autowired
    private SocioService socioService;

    private Socio socio;

    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView pageLogin() {
        
        socio = socioService.getSocioByEmail();

        ModelAndView mv = new ModelAndView("paginas-sistema/sisaocbmma/index");
        mv.addObject("socio", socio);
        return mv;
    }

    @RequestMapping(value="/meus-dados", method=RequestMethod.GET)
    public ModelAndView pageMeusDados() {
        ModelAndView mv = new ModelAndView("paginas-sistema/sisaocbmma/meus-dados");
        socio = socioService.getSocioByEmail();
        mv.addObject("socio", socio);
        return mv;
    }

    @RequestMapping(value="/meus-dependentes", method=RequestMethod.GET)
    public ModelAndView pageMeusDependentes() {
        ModelAndView mv = new ModelAndView("paginas-sistema/sisaocbmma/meus-dependentes");
        socio = socioService.getSocioByEmail();
        mv.addObject("socio", socio);
        return mv;
    }

    @RequestMapping(value="/alterar-senha", method=RequestMethod.GET)
    public ModelAndView pageAlterarSenha() {
        ModelAndView mv = new ModelAndView("paginas-sistema/sisaocbmma/alterar-senha");
        socio = socioService.getSocioByEmail();
        mv.addObject("socio", socio);
        return mv;
    }

    @PostMapping(value="/atualizar-socio")
    public String atualizarSocio(Socio socio) {
        socioService.atualizarSocio(socio);
        return "paginas-sistema/sisaocbmma/index";
    }
    
    
}