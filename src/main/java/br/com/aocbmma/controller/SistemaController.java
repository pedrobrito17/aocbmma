package br.com.aocbmma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.aocbmma.model.ReservaCampoFutebol;
import br.com.aocbmma.model.ReservaEspacoCajueiro;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.CategoriaConvenioService;
import br.com.aocbmma.service.ConvenioService;
import br.com.aocbmma.service.MovimentacaoFinanceiraService;
import br.com.aocbmma.service.ReservaCampoFutebolService;
import br.com.aocbmma.service.ReservaChaleService;
import br.com.aocbmma.service.ReservaEspacoCajueiroService;
import br.com.aocbmma.service.SocioService;



@Controller
@RequestMapping("/sisaocbmma")
public class SistemaController{

    @Autowired
    private SocioService socioService;

    @Autowired
    private MovimentacaoFinanceiraService financeiraService;

    @Autowired
    private ConvenioService convenioService;

    @Autowired
    private CategoriaConvenioService categoriaService;

    @Autowired
    private ReservaEspacoCajueiroService reservaCajueiroService;

    @Autowired
    private ReservaCampoFutebolService reservaCampoService;

    @Autowired
    private ReservaChaleService reservaChaleService;

    private Socio socioLogado = null;

    private ModelAndView mv = null;

    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView pageIndex() {
        reservaCampoService.cancelarReservarComPagamentoVencido();
        reservaCajueiroService.cancelarReservarComPagamentoVencido();
        reservaChaleService.cancelarReservarComPagamentoVencido();

        socioLogado = socioService.getSocioByEmail();

        mv = new ModelAndView("paginas-sistema/sisaocbmma/index");
        mv.addObject("aniversariantes", socioService.getAniversariantesDoMes());
        mv.addObject("socio", socioLogado);
        return mv;
    }

    @RequestMapping(value="/meus-dados", method=RequestMethod.GET)
    public ModelAndView pageMeusDados() {
        mv = new ModelAndView("paginas-sistema/sisaocbmma/meus-dados");
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);
        return mv;
    }

    @RequestMapping(value="/meus-dependentes", method=RequestMethod.GET)
    public ModelAndView pageMeusDependentes() {
        mv = new ModelAndView("paginas-sistema/sisaocbmma/meus-dependentes");
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);
        return mv;
    }

    @RequestMapping(value="/alterar-senha", method=RequestMethod.GET)
    public ModelAndView pageAlterarSenha() {
        mv = new ModelAndView("paginas-sistema/sisaocbmma/alterar-senha");
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);
        return mv;
    }

    @RequestMapping(value="/financeiro", method=RequestMethod.GET)
    public ModelAndView requestMethodName() {
        mv = new ModelAndView("paginas-sistema/sisaocbmma/financeiro");
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);
        mv.addObject("financeiros", financeiraService.getTodasMovimentacoesFinanceiras());
        return mv;
    }
    
    @PostMapping(value="/atualizar-socio")
    public ModelAndView atualizarSocio(Socio socio) {
        socioService.atualizarSocio(socio);
        return aoIndex("Os seus dados foram alteardos com sucesso.");
    }

    @PostMapping(value="/alterar-senha")
    public ModelAndView alterarSenha(Socio socio) {
        socioService.atualizarSenhaSocio(socio);
        mv = new ModelAndView("paginas-sistema/sisaocbmma/index");
        return aoIndex("Senha alterada com sucesso.");
    }

    @PostMapping(value="/atualizar-meus-dependentes")
    public ModelAndView atualizarMeusDependentes(Socio socio) {
        socioService.atualizarMeusDependentes(socio);
        return aoIndex("Dependentes atualizados com sucesso.");
    }

    @DeleteMapping(value="/deletar-dependente/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletarDependente(@PathVariable("id") int id) {
        socioService.deletarDependente(id);
    }

    @RequestMapping(value="/reservar-clube", method=RequestMethod.GET)
    public ModelAndView pageAgendar() {
        mv = new ModelAndView("paginas-sistema/sisaocbmma/reservas/reservar-clube");
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);
        mv.addObject("reservaCampo", new ReservaCampoFutebol());
        mv.addObject("reservaCajueiro", new ReservaEspacoCajueiro());
        mv.addObject("datasReservaCajueiro", reservaCajueiroService.getDatasReservasRealizadas());
        return mv;
    }
    
    @RequestMapping(value = "/convenios", method = RequestMethod.GET)
    public ModelAndView pageConvenios() {
        mv = new ModelAndView("paginas-sistema/sisaocbmma/convenios");
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);
        mv.addObject("convenios", convenioService.getConvenios());
        mv.addObject("categorias", categoriaService.getListCategoriaConvenios());
        return mv;
    }

    @GetMapping(value="/minhas-reservas")
    public ModelAndView pageMeusEventos() {
        mv = new ModelAndView("paginas-sistema/sisaocbmma/reservas/minhas-reservas");
        mv.addObject("eventCampo", reservaCampoService.getMinhasReserva());
        mv.addObject("eventCajueiro", reservaCajueiroService.getMinhasReserva());
        mv.addObject("eventChale", reservaChaleService.getMinhasReservas());
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);

        return mv;
    }

    @GetMapping(value="/reservas-clube")
    public ModelAndView pageReservasClube() {
        mv = new ModelAndView("paginas-sistema/sisaocbmma/reservas/reservas-clube");
        mv.addObject("eventCampo", reservaCampoService.getReservasDoClube());
        mv.addObject("eventCajueiro", reservaCajueiroService.getReservasDoClube());
        mv.addObject("eventChale", reservaChaleService.getReservasDoClube());
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);

        return mv;
    }
    
    public ModelAndView aoIndex(String mensagem){
        socioLogado = socioService.getSocioByEmail();

        mv = new ModelAndView("paginas-sistema/sisaocbmma/index");
        mv.addObject("aniversariantes", socioService.getAniversariantesDoMes());
        mv.addObject("socio", socioLogado);
        mv.addObject("msgSuccess", mensagem);
        return mv;
    }
    
}