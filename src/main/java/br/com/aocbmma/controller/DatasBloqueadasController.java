package br.com.aocbmma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.aocbmma.model.DatasBloqueadas;
import br.com.aocbmma.service.DatasBloqueadasService;



@Controller
@RequestMapping(value = "/admin")
public class DatasBloqueadasController {

    @Autowired
    private DatasBloqueadasService datasBloqueadasService;

    @PostMapping(value="/salvar-data-bloqueada")
    public ModelAndView postSalvarFeriado(DatasBloqueadas dataBloqueada) {
        datasBloqueadasService.salvarDataBloqueada(dataBloqueada);
        ModelAndView mv = new ModelAndView("redirect:/admin/datas-bloqueadas");
        return mv;
    }

    @GetMapping(value="/deletar-data-bloqueada/{id}")
    public ModelAndView postDeletarDataBloqueada(@PathVariable("id") int id) {
        datasBloqueadasService.deletarDataBloqueada(id);
        ModelAndView mv = new ModelAndView("redirect:/admin/datas-bloqueadas");
        return mv;
    }
    
    



}