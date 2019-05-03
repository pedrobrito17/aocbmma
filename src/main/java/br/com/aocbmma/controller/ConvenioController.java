package br.com.aocbmma.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.aocbmma.helper.FileUpload;
import br.com.aocbmma.model.CategoriaConvenio;
import br.com.aocbmma.model.Convenio;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.CategoriaConvenioService;
import br.com.aocbmma.service.ConvenioService;
import br.com.aocbmma.service.SocioService;

@Controller
@RequestMapping(value = "/admin")
public class ConvenioController {

    @Autowired
    private ConvenioService convenioService;

    @Autowired
    private CategoriaConvenioService categoriaConvenioService;

    @Autowired
    ServletContext servlet;

    private ModelAndView mv = null;

    @Autowired
    private SocioService socioService;

    private Socio socioLogado = null;

    @RequestMapping(value = "/add-convenio", method = RequestMethod.GET)
    public ModelAndView pageAddConvenio(Convenio convenio) {
        socioLogado = socioService.getSocioByEmail();
        
        mv = new ModelAndView("paginas-sistema/admin/convenios/add-convenio");
        mv.addObject("categorias", categoriaConvenioService.getListCategoriaConvenios());
        mv.addObject("socio", socioLogado);
        return mv;
    }
    
    @RequestMapping(value = "/listar-convenios", method = RequestMethod.GET)
    public ModelAndView pageListarConvenios() {
        socioLogado = socioService.getSocioByEmail();
        
        mv = new ModelAndView("paginas-sistema/admin/convenios/lista-convenios");
        mv.addObject("convenios", convenioService.getConvenios());
        mv.addObject("socio", socioLogado);
        return mv;
    }
    
    @RequestMapping(value = "/editar-convenio/{id}", method = RequestMethod.GET)
    public ModelAndView pageEditarConvenio(@PathVariable Integer id) {
        socioLogado = socioService.getSocioByEmail();
        
        mv = new ModelAndView("paginas-sistema/admin/convenios/editar-convenio");
        mv.addObject("convenio", convenioService.buscarConvenio(id));
        mv.addObject("categorias", categoriaConvenioService.getListCategoriaConvenios());
        mv.addObject("socio", socioLogado);
        return mv;
    }

    @PostMapping(value = "/salvar-convenio")
    @ResponseBody
    public ModelAndView salvarConvenio(HttpServletRequest request, @RequestParam("logo") MultipartFile logo,
            RedirectAttributes attributes) throws IOException {

        String nameFileOrig = logo.getOriginalFilename();
        int tam = nameFileOrig.length();

        String fileName = request.getParameter("nome_empresa")+nameFileOrig.substring(tam-4, tam);
        String pathRoot = servlet.getRealPath("/");
        String pathFile = FileUpload.DIRECTORY_CONVENIOS + fileName;

        FileUpload.uploadServerFile(FileUpload.DIRECTORY_CONVENIOS ,pathRoot, fileName, logo);

        Integer categoria = Integer.parseInt(request.getParameter("categoria"));
        CategoriaConvenio categoriaConvenio = categoriaConvenioService.getCategoriaConvenio(categoria);
        Convenio convenio = new Convenio(null, request.getParameter("nome_empresa"), request.getParameter("beneficio"),
                pathFile, categoriaConvenio);

        if (convenioService.salvarConvenio(convenio)) {
            attributes.addFlashAttribute("mensagem", "Convênio salvo com sucesso!");
            return new ModelAndView("redirect:/admin/listar-convenios");
        } else {
            attributes.addFlashAttribute("erro", "Erro inesperado. O convênio não foi salvo. Tente novamente.");
            return new ModelAndView("redirect:/admin/listar-convenios");
        }
    }

    @PostMapping(value = "/atualizar-convenio")
    @ResponseBody
    public ModelAndView atualizarConvenio(HttpServletRequest request, @RequestParam("logo") MultipartFile logo,
            RedirectAttributes attributes) throws IOException {

        Integer categoria = Integer.parseInt(request.getParameter("categoria"));
        CategoriaConvenio categoriaConvenio = categoriaConvenioService.getCategoriaConvenio(categoria);
        Convenio convenio = new Convenio(Integer.parseInt(request.getParameter("id")),
                request.getParameter("nome_empresa"), request.getParameter("beneficio"), "", categoriaConvenio);

        if (logo.isEmpty()) {
            convenio.setPath_logo(request.getParameter("path_logo"));
        } else {
            String nameFileOrig = logo.getOriginalFilename();
            int tam = nameFileOrig.length();
        
            String fileName = request.getParameter("nome_empresa")+nameFileOrig.substring(tam-4, tam);
            String pathRoot = servlet.getRealPath("/");
            String pathFile = FileUpload.DIRECTORY_CONVENIOS + fileName;

            convenio.setPath_logo(pathFile);

            FileUpload.deleteFile(pathRoot, request.getParameter("path_logo"));
            FileUpload.uploadServerFile(FileUpload.DIRECTORY_CONVENIOS ,pathRoot, fileName, logo);
        }

        if (convenioService.salvarConvenio(convenio)) {
            attributes.addFlashAttribute("mensagem", "Convênio atualizado com sucesso!");
            return new ModelAndView("redirect:/admin/listar-convenios");
        } else {
            attributes.addFlashAttribute("erro", "Erro inesperado. O convênio não foi atualizado. Tente novamente.");
            return new ModelAndView("redirect:/admin/listar-convenios");
        }

    }

    @GetMapping(value = "/excluir-convenio/{id}")
    public ModelAndView excluirConvenio(@PathVariable Integer id) {
        convenioService.deletarConvenio(id);
        mv = new ModelAndView("redirect:/admin/listar-convenios");
        return mv;
    }

}
