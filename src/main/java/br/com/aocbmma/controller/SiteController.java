package br.com.aocbmma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.aocbmma.service.CategoriaConvenioService;
import br.com.aocbmma.service.ConvenioService;
import br.com.aocbmma.service.NoticiaService;


@Controller
public class SiteController{

    @Autowired
    private NoticiaService noticiaService;

    @Autowired
    private ConvenioService convenioService;

    @Autowired
    private CategoriaConvenioService categoriaService;
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView pageIndex() {
        ModelAndView mv = new ModelAndView("paginas-site/index");
        mv.addObject("principal", noticiaService.getNoticiaPrincipal());
        mv.addObject("ultimasNoticias", noticiaService.getUltimasTresNoticias());
        return mv;
    }

    @RequestMapping(value="/estatuto", method=RequestMethod.GET)
    public String pageEstatuto() {
        return "paginas-site/institucional/estatuto";
    }

    @RequestMapping(value="/regimento", method=RequestMethod.GET)
    public String pageRegimento() {
        return "paginas-site/institucional/regimento";
    }

    @RequestMapping(value="/historico", method=RequestMethod.GET)
    public String pageHistorico() {
        return "paginas-site/institucional/historico";
    }

    @RequestMapping(value="/diretorias", method=RequestMethod.GET)
    public String pagePresidente() {
        return "paginas-site/institucional/diretorias";
    }

    @RequestMapping(value="/contato", method=RequestMethod.GET)
    public String pageContato() {
        return "paginas-site/contato";
    }

    @RequestMapping(value="/atendimentojuridico", method=RequestMethod.GET)
    public String pageAtendimento() {
        return "paginas-site/juridico/atendimento";
    }

    @RequestMapping(value="/atuacao", method=RequestMethod.GET)
    public String pageAtuacao() {
        return "paginas-site/juridico/atuacao";
    }

    @RequestMapping(value="/convenios", method=RequestMethod.GET)
    public ModelAndView pageConvenios() {
        ModelAndView mv = new ModelAndView("paginas-site/servicos/convenios");
        mv.addObject("convenios", convenioService.getConvenios());
        mv.addObject("categorias", categoriaService.getListCategoriaConvenios());
        return mv;
    }

    @RequestMapping(value="/noticias", method=RequestMethod.GET)
    public ModelAndView pageNoticias() {
        ModelAndView mv = new ModelAndView("paginas-site/noticias");
        mv.addObject("noticias", noticiaService.getNoticias());
        return mv;
    }

    @RequestMapping(value="/noticia/{id}", method=RequestMethod.GET)
    public ModelAndView exibeNoticia(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("paginas-site/noticia");
        mv.addObject("noticia", noticiaService.buscarNoticia(id));
        return mv;
    }
    
    
}