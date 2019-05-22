package br.com.aocbmma.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

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
import br.com.aocbmma.model.MovimentacaoFinanceira;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.MovimentacaoFinanceiraService;
import br.com.aocbmma.service.SocioService;


@Controller
public class FinanceiroController{

    @Autowired
    private MovimentacaoFinanceiraService financeiraService;

    @Autowired
    ServletContext servlet;

    @Autowired
    private SocioService socioService;

    private Socio socioLogado = null;

    private ModelAndView mv = null;

    private String[] meses = {"jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez"};

    @RequestMapping(value="/admin/add-financeiro", method=RequestMethod.GET)
    public ModelAndView pageAddFinanceiro() {
        socioLogado = socioService.getSocioByEmail();
        
        mv = new ModelAndView("paginas-sistema/admin/financeiro/add-financeiro");
        mv.addObject("socio", socioLogado);
        return mv;
    }
    
    @RequestMapping(value="/admin/listar-financeiro", method=RequestMethod.GET)
    public ModelAndView pageTodosFinanceiro() {
        socioLogado = socioService.getSocioByEmail();

        mv = new ModelAndView("paginas-sistema/admin/financeiro/lista-financeiro");
        mv.addObject("financeiros", financeiraService.getTodasMovimentacoesFinanceiras());
        mv.addObject("socio", socioLogado);
        return mv;
    }

    @PostMapping(value="/admin/salvar-financeiro")
    public ModelAndView postFinanceiro(HttpServletRequest request, @RequestParam("file") MultipartFile file,
        RedirectAttributes attributes) throws IOException {

        MovimentacaoFinanceira financeira = new MovimentacaoFinanceira();
        
        String st_inicial = request.getParameter("inicial");
        Date data_inicial = FormatadorData.getDataFormatadaNoPadraoSQL(st_inicial);
        financeira.setPeriodo_inicial(data_inicial);

        String st_final = request.getParameter("final");
        Date data_final = FormatadorData.getDataFormatadaNoPadraoSQL(st_final);
        financeira.setPeriodo_final(data_final);

        String fileName = getFileName(data_inicial, data_final);
        String ano = getDiretorioAno(data_inicial);
        String pathRoot = servlet.getRealPath("/");
        String diretorioCompleto = FileUpload.uploadServerFileFinanceiroOuAtaAssembleia(FileUpload.DIRECTORY_FINANCEIRO ,pathRoot, fileName, file, ano);

        financeira.setPath_arquivo(diretorioCompleto + File.separator + fileName);;

        if (financeiraService.salvarMovimentacaoFinanceira(financeira)) {
            attributes.addFlashAttribute("mensagem", "Movimentação financeira adicionada com sucesso!");
            return new ModelAndView("redirect:/admin/listar-financeiro");
        } else {
            attributes.addFlashAttribute("erro", "Erro inesperado. A movimentação financeira não foi adicionada. Tente novamente.");
            return new ModelAndView("redirect:/admin/listar-financeiro");
        }
    }

    @GetMapping(value="/admin/excluir-financeiro/{id}")
    public ModelAndView excluirDocFinanceiro(@PathVariable Integer id) {
        financeiraService.deletarFinanceiro(id);
        mv = new ModelAndView("redirect:/admin/listar-financeiro");
        return mv;
    }

    
    public String getFileName(Date data_inicial, Date data_final){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data_inicial);

        int num = calendar.get(Calendar.MONTH);
        String mes_inicial = meses[num];
        int ano = calendar.get(Calendar.YEAR);
        
        calendar.setTime(data_final);
        num = calendar.get(Calendar.MONTH);
        String mes_final = meses[num];
        
        return "Financeiro "+mes_inicial+" - "+mes_final+" "+ano+".pdf";
    }
    
    public String getDiretorioAno(Date data){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
    
        int ano = calendar.get(Calendar.YEAR);
        return String.valueOf(ano);
    }

}