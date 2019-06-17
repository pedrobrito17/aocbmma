package br.com.aocbmma.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.aocbmma.helper.FileUpload;
import br.com.aocbmma.helper.FormatadorData;
import br.com.aocbmma.model.AtaAssembleia;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.AtaAssembleiaService;

@Controller
public class AtasController{

    @Autowired
    private AtaAssembleiaService ataAssembleiaService;

    @Autowired
    ServletContext servlet;
    
    //obtém o objeto do sócio por meio do scopo da sessão criado em SocioService
    @Resource(name = "getSessionScopedSocio") 
    private Socio socioSession;

    private ModelAndView mv = null;

    private String[] meses = {"jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez"};

    @RequestMapping(value="/admin/add-ata-assembleia", method=RequestMethod.GET)
    public ModelAndView pageAddAta() {
        mv = new ModelAndView("paginas-sistema/admin/atas/add-ata");
        mv.addObject("socio", socioSession);
        return mv;
    }

    @PostMapping(value="/admin/salvar-ata-assembleia")
    public ModelAndView postAataAssembleia(HttpServletRequest request, @RequestParam("file") MultipartFile file,
        RedirectAttributes attributes) {

            AtaAssembleia ataAssembleia = getObjectAtaAssembleia(request, file);
            
            if (ataAssembleiaService.salvarAtaAssembleia(ataAssembleia)) {
                attributes.addFlashAttribute("mensagem", "Ata de assembleia geral adicionada com sucesso!");
                return new ModelAndView("redirect:/admin/listar-atas-assembleia");
            } else {
                attributes.addFlashAttribute("erro", "Erro inesperado. A ata de assembleia geral não foi adicionada. Tente novamente.");
                return new ModelAndView("redirect:/admin/listar-atas-assembleia");
        }
    }

    @RequestMapping(value="/admin/listar-atas-assembleia", method=RequestMethod.GET)
    public ModelAndView pageTodasAtasAssembleia() {
        mv = new ModelAndView("paginas-sistema/admin/atas/listar-atas-assembleia");
        mv.addObject("atas", ataAssembleiaService.getTodasAtasAssembleia());
        mv.addObject("socio", socioSession);
        return mv;
    }

    @GetMapping(value="/admin/excluir-ata-assembleia/{id}")
    public ModelAndView excluirAtaAssembleia(@PathVariable Integer id) {
        ataAssembleiaService.deletarAtaAssembleia(id);
        mv = new ModelAndView("redirect:/admin/listar-atas-assembleia");
        return mv;
    }
    
    public AtaAssembleia getObjectAtaAssembleia(HttpServletRequest request, MultipartFile file){
        AtaAssembleia ataAssembleia = new AtaAssembleia();
    
        String st_data_assembleia = request.getParameter("data_assembleia");
        Date data_assembleia = FormatadorData.getDataFormatadaNoPadraoSQL(st_data_assembleia);
        ataAssembleia.setData_assembleia(data_assembleia);
    
        String fileName = getFileName(data_assembleia);
        String ano = getDiretorioAno(data_assembleia);
        String pathRoot = servlet.getRealPath("/");
        String diretorioCompleto = "";
        try {
            diretorioCompleto = FileUpload.uploadServerFileFinanceiroOuAtaAssembleia(FileUpload.DIRECTORY_ATAS_ASSEMBLEIA, pathRoot,
                    fileName, file, ano);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        ataAssembleia.setPath_ata(diretorioCompleto + File.separator + fileName);

        return ataAssembleia;
    }

    public String getFileName(Date data_assembleia){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data_assembleia);

        int num = calendar.get(Calendar.MONTH);
        String mes = meses[num];
        int ano = calendar.get(Calendar.YEAR);
        
        return "Ata Assembleia"+" - "+mes+" "+ano+".pdf";
    }
    
    public String getDiretorioAno(Date data){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
    
        int ano = calendar.get(Calendar.YEAR);
        return String.valueOf(ano);
    }
}