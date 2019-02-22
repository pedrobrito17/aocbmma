package br.com.aocbmma.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import br.com.aocbmma.helper.FormatadorData;
import br.com.aocbmma.model.Noticia;
import br.com.aocbmma.service.NoticiaService;

@Controller
@RequestMapping(value = "/sisaocbmma")
public class NoticiaController {

    @Autowired
    private NoticiaService noticiaService;

    @RequestMapping(value = "/add-noticia", method = RequestMethod.GET)
    public String pageAddNoticia() {
        return "paginas-sistema/noticias/add-noticia";
    }

    @PostMapping(value = "/salvar-noticia")
    @ResponseBody
    public ModelAndView postSalvarNoticia(HttpServletRequest request, @RequestParam("imagem") MultipartFile imagem,
        RedirectAttributes attributes) throws IOException, ParseException{

        Noticia noticia = new Noticia();
        noticia.setTitulo(request.getParameter("titulo"));
        noticia.setNoticia(request.getParameter("noticia"));
        noticia.setImagem(imagem.getBytes());
        
        String data = request.getParameter("data-postagem");
        noticia.setData_postagem(FormatadorData.getDataFormatadaNoPadraoSQL(data));         

        if(noticiaService.salvarNoticia(noticia)){
            attributes.addFlashAttribute("mensagem", "Notícia salva com sucesso!");
            return new ModelAndView("redirect:/sisaocbmma/listar-noticias");
        }else{
            attributes.addFlashAttribute("erro", "Erro inesperado. Sua notícia não foi salva. Tente novamente.");
            return new ModelAndView("redirect:/sisaocbmma/listar-noticias");
        }
    }

    @PostMapping(value = "/atualizar-noticia")
    @ResponseBody
    public ModelAndView postAtualizarNoticia(HttpServletRequest request, @RequestParam("imagem") MultipartFile imagem,
        RedirectAttributes attributes) throws IOException, ParseException{
        
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        Noticia noticia = new Noticia();
        noticia.setId(id);
        noticia.setTitulo(request.getParameter("titulo"));
        noticia.setNoticia(request.getParameter("noticia"));
        
        String data = request.getParameter("data-postagem");
        noticia.setData_postagem(FormatadorData.getDataFormatadaNoPadraoSQL(data));  
        
        if(!imagem.isEmpty()){
            noticia.setImagem(imagem.getBytes());
        }
        else{
            noticia.setImagem( noticiaService.buscarNoticia(id).getImagem() );
        }

        if(noticiaService.salvarNoticia(noticia)){
            attributes.addFlashAttribute("mensagem", "Notícia atualizada com sucesso!");
            return new ModelAndView("redirect:/sisaocbmma/listar-noticias");
        }else{
            attributes.addFlashAttribute("erro", "Erro inesperado. Sua notícia não foi atualizada. Tente novamente.");
            return new ModelAndView("redirect:/sisaocbmma/listar-noticias");
        }
    }

    @RequestMapping(value = "/listar-noticias", method = RequestMethod.GET)
    public ModelAndView pageListarNoticias() {

        ModelAndView mv = new ModelAndView("paginas-sistema/noticias/lista-noticias");
        mv.addObject("noticias", noticiaService.getNoticias());
        return mv;
    }

    @GetMapping(value="/excluir-noticia/{id}")
    public ModelAndView excluirNoticia(@PathVariable Integer id) {
        noticiaService.deletarNoticia(id);
        ModelAndView mv = new ModelAndView("redirect:/sisaocbmma/listar-noticias");
        return mv;
    }

    @RequestMapping(value = "/editar-noticia/{id}", method = RequestMethod.GET)
    public ModelAndView editarNoticia(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView("paginas-sistema/noticias/editar-noticia");
        mv.addObject("noticia", noticiaService.buscarNoticia(id));
        return mv;
    }
    


}

