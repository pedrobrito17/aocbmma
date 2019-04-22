package br.com.aocbmma.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.aocbmma.config.FilesConvenio;
import br.com.aocbmma.helper.MensageiroEmail;
import br.com.aocbmma.helper.Mensagem;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.NoticiaService;

@Controller
public class SiteController {

    @Autowired
    private NoticiaService noticiaService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    ServletContext servlet; //utilizado para copiar a pasta para o servidor

    private ModelAndView mv = null;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView pageIndex() {
        mv = new ModelAndView("paginas-site/index");
        mv.addObject("principal", noticiaService.getNoticiaPrincipal());
        mv.addObject("ultimasNoticias", noticiaService.getUltimasDuasNoticias());

        // copiando a pasta das imagens dos convenios para o servidor
        // String pathDestination = servlet.getRealPath("/");
        // new FilesConvenio().copiarImagensConvenioParaServidor(pathDestination);

        return mv;
    }

    @RequestMapping(value = "/estatuto", method = RequestMethod.GET)
    public String pageEstatuto() {
        return "paginas-site/institucional/estatuto";
    }

    @RequestMapping(value = "/legislacao", method = RequestMethod.GET)
    public String pageLegislacao() {
        return "paginas-site/institucional/legislacao";
    }

    @RequestMapping(value = "/regimento", method = RequestMethod.GET)
    public String pageRegimento() {
        return "paginas-site/institucional/regimento";
    }

    @RequestMapping(value = "/historico", method = RequestMethod.GET)
    public String pageHistorico() {
        return "paginas-site/institucional/historico";
    }

    @RequestMapping(value = "/diretorias", method = RequestMethod.GET)
    public String pagePresidente() {
        return "paginas-site/institucional/diretorias";
    }

    @RequestMapping(value = "/contato", method = RequestMethod.GET)
    public ModelAndView pageContato(Mensagem mensagem, Model model) {
        mv = new ModelAndView("paginas-site/contato");
        return mv;
    }

    @RequestMapping(value = "/atendimentojuridico", method = RequestMethod.GET)
    public String pageAtendimento() {
        return "paginas-site/juridico/atendimento";
    }

    @RequestMapping(value = "/atuacao", method = RequestMethod.GET)
    public String pageAtuacao() {
        return "paginas-site/juridico/atuacao";
    }

    @RequestMapping(value = "/associese", method = RequestMethod.GET)
    public ModelAndView pageAssociese(Socio socio) {
        mv = new ModelAndView("paginas-site/servicos/associese"); 
        return mv;
    }

    @RequestMapping(value = "/planodesaude", method = RequestMethod.GET)
    public String pagePlanoDeSaude() {
        return "paginas-site/servicos/planodesaude";
    }

    @RequestMapping(value = "/carteiraassociado", method = RequestMethod.GET)
    public String pageCarteiraDoAssociado() {
        return "paginas-site/servicos/carteira-associado";
    }

    @RequestMapping(value = "/pesquisar", method = RequestMethod.GET)
    public ModelAndView buscarNoticia(@RequestParam("busca") String busca) {
        mv = new ModelAndView("paginas-site/noticias");
        mv.addObject("noticias", noticiaService.buscarNoticias(busca));
        mv.addObject("qtd", noticiaService.buscarNoticias(busca).size());
        mv.addObject("pesquisa", true);
        return mv;
    }

    @RequestMapping(value = "/noticias", method = RequestMethod.GET)
    public ModelAndView pageNoticias() {
        mv = new ModelAndView("paginas-site/noticias");
        mv.addObject("noticias", noticiaService.getNoticias());
        return mv;
    }

    @RequestMapping(value = "/noticia/{id}", method = RequestMethod.GET)
    public ModelAndView exibeNoticia(@PathVariable("id") Integer id) {
        mv = new ModelAndView("paginas-site/noticia");
        mv.addObject("noticia", noticiaService.buscarNoticia(id));
        return mv;
    }

    @RequestMapping(value = "/convenios", method = RequestMethod.GET)
    public ModelAndView pageConvenios() {
        mv = new ModelAndView("paginas-site/servicos/convenios");
        return mv;
    }

    @RequestMapping(value = "/manuais", method = RequestMethod.GET)
    public ModelAndView pageManuais() {
        mv = new ModelAndView("paginas-site/institucional/manuais");
        return mv;
    }

    @RequestMapping(value = "/juridico/artigos", method = RequestMethod.GET)
    public ModelAndView pageJuridicoArtigos() {
        mv = new ModelAndView("paginas-site/juridico/artigos");
        return mv;
    }

    @RequestMapping(value = "/enviar-email", method = RequestMethod.POST)
    public String postEnviarEmail(Mensagem mensagem, Model model) {
        MensageiroEmail mensageiro = new MensageiroEmail();

        if(mensageiro.enviarEmailDoSiteParaPresidente(mailSender, mensagem)){
            model.addAttribute("enviado", "E-mail enviado com sucesso. Aguarde o retorno da AOCBMMA.");
            return "paginas-site/contato";
        }else{
            model.addAttribute("erro", "Desculpe! Erro ao enviar o e-mail. Tente novamente.");
            return "paginas-site/contato";
        }
    }

    @RequestMapping(value = "/site/retorno", method = RequestMethod.GET)
    public String pageRetorno() {
        return "paginas-site/retorno";
    }

}