package br.com.aocbmma.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.aocbmma.helper.FileSociosExcel;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.SocioService;



@Controller
public class SocioController {

    @Autowired
    ServletContext servlet;

    @Autowired
    private SocioService socioService;

    @Autowired
    private FileSociosExcel fileSociosExcel;

    private ModelAndView mv = null;

    @RequestMapping(value = "/associese", method = RequestMethod.GET)
    public ModelAndView pageAssociese(Socio socio) throws Exception {
        mv = new ModelAndView("paginas-sistema/cadastro-socio"); 
        return mv;
    }

    @PostMapping(value = "/cadastrar-novo-socio")
    public ModelAndView cadastrarSocio(Socio socio) {
        String msgRetornoErro = socioService.salvarSocio(socio);
        mv = new ModelAndView("paginas-sistema/retorno");
        mv.addObject("msg", msgRetornoErro.isEmpty());
        mv.addObject("msg_erro", msgRetornoErro);
        return mv;
    }
    
    @GetMapping(value="/admin/alterar-status-socio/{status}/{id}")
    public ModelAndView alterarStatusParaInativo(@PathVariable("status") String status, @PathVariable("id") int socio_id, 
    RedirectAttributes redirectAttributes) {
        socioService.atualizarSituacaoSocioPara(status, socio_id);
        redirectAttributes.addFlashAttribute("msgSuccess", "A situação do sócio foi alterada com sucesso");
        mv = new ModelAndView("redirect:/");
        return mv;
    }

    @GetMapping(value = "/admin/aceitar-socio/{id}")
    public ModelAndView alterarStatusParaAtivo(@PathVariable("id") int id) {
        socioService.atualizarSituacaoSocioPara("ativo", id);
        mv = new ModelAndView("redirect:/");
        return mv;
    }

    @PostMapping(value = "/sisaocbmma/salvar-foto-perfil/{id}")
    public ModelAndView salvarFotoPerfil(HttpServletRequest request, @RequestParam("foto") MultipartFile file, @PathVariable("id") int socio_id) {
        socioService.salvarFotoDoPerfil(socio_id, file);
        mv = new ModelAndView("redirect:/");
        return mv;
    }

    @RequestMapping(value="/admin/planilha-socios", method=RequestMethod.GET)
    public HttpEntity<byte[]> getPlanilhaSocios() {
        String path_root = servlet.getRealPath("/");
        byte[] planilhaBytes = fileSociosExcel.criarArquivoExcel(path_root);
        String name_file = FileSociosExcel.FILE;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment; filename=\"" + name_file + "\"");

        HttpEntity<byte[]> httpEntity = new HttpEntity<byte[]>( planilhaBytes, httpHeaders );
        return httpEntity;
    }
    
}