package br.com.aocbmma.controller;

import java.io.IOException;

import javax.annotation.Resource;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.aocbmma.model.ReservaCampoFutebol;
import br.com.aocbmma.model.ReservaEspacoCajueiro;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.AtaAssembleiaService;
import br.com.aocbmma.service.CategoriaConvenioService;
import br.com.aocbmma.service.ConvenioService;
import br.com.aocbmma.service.DatasBloqueadasService;
import br.com.aocbmma.service.MovimentacaoFinanceiraService;
import br.com.aocbmma.service.ReservaCampoFutebolService;
import br.com.aocbmma.service.ReservaChaleService;
import br.com.aocbmma.service.ReservaEspacoCajueiroService;
import br.com.aocbmma.service.SocioService;
import br.com.aocbmma.service.SocioTransferenciaService;
import br.com.aocbmma.service.SolicitacaoCarteiraIdentificacaoService;

@Controller
@RequestMapping("/sisaocbmma")
public class SistemaController {

    @Autowired
    private SocioService socioService;

    @Autowired
    private MovimentacaoFinanceiraService financeiraService;

    @Autowired
    private AtaAssembleiaService ataAssembleiaService;

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

    @Autowired
    private SocioTransferenciaService socioTransferenciaService;

    @Autowired
    private DatasBloqueadasService datasBloqueadasService;

    @Autowired
    private SolicitacaoCarteiraIdentificacaoService solicitacaoCarteiraIdentificacaoService;

    // obtém o objeto do sócio por meio do scopo da sessão criado em SocioService
    @Resource(name = "getSessionScopedSocio")
    private Socio socioSession;

    private ModelAndView mv = null;

    @RequestMapping(value = "/meus-dados", method = RequestMethod.GET)
    public ModelAndView pageMeusDados() {
        Socio socioLogado = socioService.getSocioByEmail();
        mv = new ModelAndView("paginas-sistema/socio/meus-dados");
        mv.addObject("socio", socioLogado);
        return mv;
    }

    @RequestMapping(value = "/meus-dependentes", method = RequestMethod.GET)
    public ModelAndView pageMeusDependentes() {
        Socio socioLogado = socioService.getSocioByEmail();
        mv = new ModelAndView("paginas-sistema/socio/meus-dependentes");
        mv.addObject("socio", socioLogado);
        return mv;
    }

    @RequestMapping(value = "/alterar-senha", method = RequestMethod.GET)
    public ModelAndView pageAlterarSenha() {
        mv = new ModelAndView("paginas-sistema/socio/alterar-senha");
        mv.addObject("socio", socioSession);
        return mv;
    }

    @RequestMapping(value = "/financeiro", method = RequestMethod.GET)
    public ModelAndView pageFinanceiro() {
        mv = new ModelAndView("paginas-sistema/socio/financeiro");
        mv.addObject("socio", socioSession);
        mv.addObject("financeiros", financeiraService.getTodasMovimentacoesFinanceiras());
        return mv;
    }

    @RequestMapping(value = "/atas-assembleia", method = RequestMethod.GET)
    public ModelAndView pageAtasAssembleia() {
        mv = new ModelAndView("paginas-sistema/socio/atas-assembleia");
        mv.addObject("socio", socioSession);
        mv.addObject("atas", ataAssembleiaService.getTodasAtasAssembleia());
        return mv;
    }

    @PostMapping(value = "/atualizar-socio")
    public ModelAndView atualizarSocio(Socio socio, RedirectAttributes redirectAttributes) {
        socioService.atualizarSocio(socio);
        mv = new ModelAndView("redirect:/");
        redirectAttributes.addFlashAttribute("msgSuccess", "Os seus dados foram alterados com sucesso.");
        return mv;
    }

    @PostMapping(value = "/alterar-senha")
    public ModelAndView alterarSenha(Socio socio, RedirectAttributes redirectAttributes) {
        socioService.atualizarSenhaSocio(socio);
        mv = new ModelAndView("redirect:/");
        redirectAttributes.addFlashAttribute("msgSuccess", "Senha alterada com sucesso.");
        return mv;
    }

    @PostMapping(value = "/atualizar-meus-dependentes")
    public ModelAndView atualizarMeusDependentes(Socio socio, RedirectAttributes redirectAttributes) {
        socioService.atualizarMeusDependentes(socio);
        mv = new ModelAndView("redirect:/");
        redirectAttributes.addFlashAttribute("msgSuccess", "Dependentes atualizados com sucesso.");
        return mv;
    }

    @DeleteMapping(value = "/deletar-dependente/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletarDependente(@PathVariable("id") int id) {
        socioService.deletarDependente(id);
    }

    @RequestMapping(value = "/reservar-clube", method = RequestMethod.GET)
    public ModelAndView pageAgendar() {
        mv = new ModelAndView("paginas-sistema/socio/reservas/reservar-clube");
        mv.addObject("socio", socioSession);
        mv.addObject("reservaCampo", new ReservaCampoFutebol());
        mv.addObject("reservaCajueiro", new ReservaEspacoCajueiro());
        mv.addObject("datasReservaCajueiro", reservaCajueiroService.getDatasReservasRealizadas());
        mv.addObject("datasBloqueadas", datasBloqueadasService.getTodasDatasBloqueadas());
        return mv;
    }

    @RequestMapping(value = "/convenios", method = RequestMethod.GET)
    public ModelAndView pageConvenios() {
        mv = new ModelAndView("paginas-sistema/socio/convenios");
        mv.addObject("socio", socioSession);
        mv.addObject("convenios", convenioService.getConvenios());
        mv.addObject("categorias", categoriaService.getListCategoriaConvenios());
        return mv;
    }

    @GetMapping(value = "/minhas-reservas")
    public ModelAndView pageMeusEventos() {
        mv = new ModelAndView("paginas-sistema/socio/reservas/minhas-reservas");
        mv.addObject("eventCampo", reservaCampoService.getMinhasReserva());
        mv.addObject("eventCajueiro", reservaCajueiroService.getMinhasReserva());
        mv.addObject("eventChale", reservaChaleService.getMinhasReservas());
        mv.addObject("socio", socioSession);
        return mv;
    }

    @GetMapping(value = "/reservas-clube")
    public ModelAndView pageReservasClube() {
        mv = new ModelAndView("paginas-sistema/socio/reservas/reservas-clube");
        mv.addObject("eventCampo", reservaCampoService.getReservasDoClube());
        mv.addObject("eventCajueiro", reservaCajueiroService.getReservasDoClube());
        mv.addObject("eventChale", reservaChaleService.getReservasDoClube());
        mv.addObject("socio", socioSession);
        return mv;
    }

    @RequestMapping(value = "/carteira-identificacao", method = RequestMethod.GET)
    public ModelAndView pageSolicitarCarteira() {
        mv = new ModelAndView("paginas-sistema/socio/carteira-identificacao");
        mv.addObject("socio", socioSession);
        mv.addObject("solicitacoes",
                solicitacaoCarteiraIdentificacaoService.getMinhasSolicitacoesDeCarteiraDeIdentidade(socioSession));
        return mv;
    }

    @PostMapping(value = "/solicitar-carteira")
    public ModelAndView postSolicitarCarteira(@RequestParam("foto") MultipartFile foto,
            RedirectAttributes redirectAttributes) {
        Socio socioLogado = socioService.getSocioByEmail();
        String statusDoSocio = socioTransferenciaService.getStatusDeAdimplenciaDo(socioLogado);
        if (statusDoSocio.equals("inadimplente")) {
            mv = new ModelAndView("redirect:/");
            redirectAttributes.addFlashAttribute("msgErro",
                    "Não foi possível concluir a solicitação. Você está inadimplente.");
            return mv;
        } else {

            try {
                solicitacaoCarteiraIdentificacaoService.salvarSolicitacao(socioLogado, foto);
                mv = new ModelAndView("redirect:/");
                redirectAttributes.addFlashAttribute("msgSuccess","Solicitação da carteira de identificação concluída. Dentro de alguns dias entraremos em contato para realizar a entrega.");
                return mv;
            } catch (IOException e) {
                mv = new ModelAndView("redirect:/");
                redirectAttributes.addFlashAttribute("msgErro","Desculpe! Não foi possível realizar a sua solicitação.");
                return mv;
            }
            
        }
    }
}