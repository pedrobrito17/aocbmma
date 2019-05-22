package br.com.aocbmma.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.SocioService;

@Controller
public class SocioController {

    @Autowired
    private SocioService socioService;

    private ModelAndView mv = null;

    @RequestMapping(value = "/associese", method = RequestMethod.GET)
    public ModelAndView pageAssociese(Socio socio) {
        mv = new ModelAndView("paginas-sistema/cadastro-socio"); 
        return mv;
    }

    @PostMapping(value = "/cadastrar-novo-socio")
    public ModelAndView cadastrarSocio(@Valid Socio socio, BindingResult result, RedirectAttributes attributes) {
        String msgRetornoErro = socioService.salvarSocio(socio);
        mv = new ModelAndView("paginas-sistema/retorno");
        mv.addObject("msg", msgRetornoErro.isEmpty());
        mv.addObject("msg_erro", msgRetornoErro);
        return mv;
    }

    @GetMapping(value = "/admin/aceitar-socio/{id}")
    public ModelAndView aceitarSocio(@PathVariable("id") int id) {
        socioService.atualizarSituacaoSocio(id);
        mv = new ModelAndView("redirect:/");
        return mv;
    }

    @PostMapping(value = "/sisaocbmma/salvar-foto-perfil/{id}")
    public ModelAndView salvarFotoPerfil(@RequestParam("foto") MultipartFile file, @PathVariable("id") int socio_id) {
       socioService.salvarFotoDoPerfil(socio_id, file);
        mv = new ModelAndView("redirect:/");
        return mv;
    }

}