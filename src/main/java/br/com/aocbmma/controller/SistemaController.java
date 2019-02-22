package br.com.aocbmma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/sisaocbmma")
public class SistemaController{

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String pageLogin() {
        return "paginas-sistema/login";
    }

    
    
}