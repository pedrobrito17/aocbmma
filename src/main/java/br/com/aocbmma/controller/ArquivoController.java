package br.com.aocbmma.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.aocbmma.helper.FileUpload;
import br.com.aocbmma.model.Arquivo;
import br.com.aocbmma.service.ArquivoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping(value = "/admin")
public class ArquivoController {

    @Autowired
    ServletContext servlet;

    @Autowired
    private ArquivoService arquivoService;

    private ModelAndView mv = null;

    @PostMapping(value = "/salvar-arquivo")
    @ResponseBody
    public ModelAndView salvarArquivo(@RequestParam("arquivo") MultipartFile arquivo, RedirectAttributes attributes)
            throws IOException {

        Arquivo file = new Arquivo();

        String fileName = arquivo.getOriginalFilename();
        String pathRoot = servlet.getRealPath("/");
        String diretorioCompleto = FileUpload.uploadServerFile(FileUpload.DIRECTORY_FILES_NOTICIA, pathRoot,
                fileName, arquivo);

        file.setNome_arquivo(fileName);
        file.setPath(diretorioCompleto + fileName);

        if (arquivoService.salvarArquivo(file)) {
            attributes.addFlashAttribute("mensagem", "Arquivo adicionado com sucesso!");
            return new ModelAndView("redirect:/admin/add-arquivo");
        } else {
            attributes.addFlashAttribute("erro",
            "Erro inesperado. O arquivo não foi adicionado. Tente novamente.");
            return new ModelAndView("redirect:/admin/add-arquivo");
        }
    }

    @RequestMapping(value = "/add-arquivo", method = RequestMethod.GET)
    public ModelAndView addArquivo() {
        mv = new ModelAndView("paginas-sistema/admin/noticias/add-arquivo");
        mv.addObject("arquivos", arquivoService.getArquivos() );
        return mv;
    }

    @GetMapping(value="/excluir-arquivo/{id}")
    public ModelAndView excluirArquivo(@PathVariable("id") Integer id) {
        arquivoService.deletarArquivo(id);
        return new ModelAndView("redirect:/admin/add-arquivo");
    }
    



}