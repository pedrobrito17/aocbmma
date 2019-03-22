package br.com.aocbmma.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.SocioService;

@Controller
public class SocioController {

    @Autowired
    private SocioService socioService;

    @PostMapping(value = "/cadastrar-novo-socio")
    public ModelAndView cadastrarSocio(@Valid Socio socio, BindingResult result, RedirectAttributes attributes) {

        String msgRetornoErro = socioService.salvarSocio(socio);

        ModelAndView mv = new ModelAndView("paginas-site/retorno");
        mv.addObject("msg", msgRetornoErro.isEmpty());
        mv.addObject("msg_erro", msgRetornoErro);
        return mv;

    }

    @GetMapping(value = "/admin/aceitar-socio/{id}")
    public ModelAndView aceitarSocio(@PathVariable("id") int id) {
        socioService.atualizarSituacaoSocio(id);
        ModelAndView mv = new ModelAndView("redirect:/admin");
        return mv;
    }

}