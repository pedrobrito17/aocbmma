package br.com.aocbmma.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.aocbmma.helper.FileUpload;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.SocioService;

@Controller
public class SocioController {

    @Autowired
    private SocioService socioService;

    private ModelAndView mv = null;

    @Autowired
    ServletContext servlet;

    @PostMapping(value = "/cadastrar-novo-socio")
    public ModelAndView cadastrarSocio(@Valid Socio socio, BindingResult result, RedirectAttributes attributes) {
        String msgRetornoErro = socioService.salvarSocio(socio);
        mv = new ModelAndView("paginas-site/retorno");
        mv.addObject("msg", msgRetornoErro.isEmpty());
        mv.addObject("msg_erro", msgRetornoErro);
        return mv;
    }

    @GetMapping(value = "/admin/aceitar-socio/{id}")
    public ModelAndView aceitarSocio(@PathVariable("id") int id) {
        socioService.atualizarSituacaoSocio(id);
        mv = new ModelAndView("redirect:/admin");
        return mv;
    }

    @PostMapping(value = "/sisaocbmma/salvar-foto-perfil/{id}")
    public ModelAndView salvarConvenio(@RequestParam("foto") MultipartFile file, @PathVariable("id") int socio_id) {

        String nameFileOrig = file.getOriginalFilename();
        int tam = nameFileOrig.length();

        Socio socio = socioService.findSocio(socio_id);
        String fileName = socio.getId() + nameFileOrig.substring(tam-4, tam);
        String pathRoot = servlet.getRealPath("/");
        String pathFile = FileUpload.DIRECTORY_FOTO_PERFIL + fileName;

        try {
            FileUpload.uploadServerImgConvenio(FileUpload.DIRECTORY_FOTO_PERFIL, pathRoot, fileName, file);
            socio.setPath_foto_perfil(pathFile);
            socioService.salvarSocio(socio);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mv = new ModelAndView("redirect:/sisaocbmma");
        return mv;
    }

}