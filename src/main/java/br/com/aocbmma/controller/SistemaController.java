package br.com.aocbmma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.aocbmma.model.ReservaCampoFutebol;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.CategoriaConvenioService;
import br.com.aocbmma.service.ConvenioService;
import br.com.aocbmma.service.SocioService;


@Controller
@RequestMapping("/sisaocbmma")
public class SistemaController{

    @Autowired
    private SocioService socioService;

    @Autowired
    private ConvenioService convenioService;

    @Autowired
    private CategoriaConvenioService categoriaService;

    private Socio socio = null;

    private ModelAndView mv = null;

    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView pageLogin() {
        
        socio = socioService.getSocioByEmail();

        mv = new ModelAndView("paginas-sistema/sisaocbmma/index");
        mv.addObject("socio", socio);
        return mv;
    }

    @RequestMapping(value="/meus-dados", method=RequestMethod.GET)
    public ModelAndView pageMeusDados() {
        mv = new ModelAndView("paginas-sistema/sisaocbmma/meus-dados");
        socio = socioService.getSocioByEmail();
        mv.addObject("socio", socio);
        return mv;
    }

    @RequestMapping(value="/meus-dependentes", method=RequestMethod.GET)
    public ModelAndView pageMeusDependentes() {
        mv = new ModelAndView("paginas-sistema/sisaocbmma/meus-dependentes");
        socio = socioService.getSocioByEmail();
        mv.addObject("socio", socio);
        return mv;
    }

    @RequestMapping(value="/alterar-senha", method=RequestMethod.GET)
    public ModelAndView pageAlterarSenha() {
        mv = new ModelAndView("paginas-sistema/sisaocbmma/alterar-senha");
        socio = socioService.getSocioByEmail();
        mv.addObject("socio", socio);
        return mv;
    }

    @PostMapping(value="/atualizar-socio")
    public ModelAndView atualizarSocio(Socio socio) {
        socioService.atualizarSocio(socio);
        mv = new ModelAndView("paginas-sistema/sisaocbmma/index");
        mv.addObject("msgSuccess", "Os seus dados foram alterados com sucesso.");
        return mv;
    }

    @PostMapping(value="/alterar-senha")
    public ModelAndView alterarSenha(Socio socio) {
        socioService.atualizarSenhaSocio(socio);
        mv = new ModelAndView("paginas-sistema/sisaocbmma/index");
        mv.addObject("msgSuccess", "Senha alterada com sucesso.");
        return mv;
    }

    @PostMapping(value="/atualizar-meus-dependentes")
    public ModelAndView atualizarMeusDependentes(Socio socio) {
        socioService.atualizarMeusDependentes(socio);
        mv = new ModelAndView("paginas-sistema/sisaocbmma/index");
        mv.addObject("msgSuccess", "Dependentes atualizados com sucesso.");
        return mv;
    }

    @DeleteMapping(value="/deletar-dependente/{id}")
    public void deletarDependente(@PathVariable("id") int id) {
        System.out.println(id);
        // socioService.deletarDependente(id);
    }

    @RequestMapping(value="/agendar-evento", method=RequestMethod.GET)
    public ModelAndView pageAgendar() {
        mv = new ModelAndView("paginas-sistema/sisaocbmma/agendar-evento");
        socio = socioService.getSocioByEmail();
        mv.addObject("socio", socio);
        mv.addObject("reservaCampo", new ReservaCampoFutebol());

        return mv;
    }
    
    @RequestMapping(value = "/convenios", method = RequestMethod.GET)
    public ModelAndView pageConvenios() {
        mv = new ModelAndView("paginas-sistema/sisaocbmma/convenios");
        mv.addObject("convenios", convenioService.getConvenios());
        mv.addObject("categorias", categoriaService.getListCategoriaConvenios());
        return mv;
    }

    
    
    
}