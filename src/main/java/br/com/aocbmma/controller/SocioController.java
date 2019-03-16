package br.com.aocbmma.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.SocioService;


@Controller
public class SocioController{

    @Autowired
    private SocioService socioService;

    @PostMapping(value="/cadastrar-novo-socio")
    public ModelAndView cadastrarSocio(@Valid Socio socio, BindingResult result, RedirectAttributes attributes) {
        
        System.out.println(socio.getDependentes().size());
        socioService.salvarSocio(socio);
        return new ModelAndView("redirect:/associese");
    }
    

}