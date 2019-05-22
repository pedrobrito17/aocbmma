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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import br.com.aocbmma.model.ReservaCampoFutebol;
import br.com.aocbmma.model.ReservaEspacoCajueiro;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.AtaAssembleiaService;
import br.com.aocbmma.service.CategoriaConvenioService;
import br.com.aocbmma.service.ConvenioService;
import br.com.aocbmma.service.MovimentacaoFinanceiraService;
import br.com.aocbmma.service.PagamentoMensalidadeService;
import br.com.aocbmma.service.ReservaCampoFutebolService;
import br.com.aocbmma.service.ReservaChaleService;
import br.com.aocbmma.service.ReservaEspacoCajueiroService;
import br.com.aocbmma.service.SocioService;
import br.com.aocbmma.service.SocioTransferenciaService;
import br.com.aocbmma.service.SolicitacaoCarteiraIdentificacaoService;


@Controller
@RequestMapping("/sisaocbmma")
public class SistemaController{

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
    private PagamentoMensalidadeService pagamentoMensalidadeService;

    @Autowired
    private SolicitacaoCarteiraIdentificacaoService solicitacaoCarteiraIdentificacaoService;

    private Socio socioLogado = null;

    private ModelAndView mv = null;

    @RequestMapping(value="/meus-dados", method=RequestMethod.GET)
    public ModelAndView pageMeusDados() {
        mv = new ModelAndView("paginas-sistema/socio/meus-dados");
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);
        return mv;
    }

    @RequestMapping(value="/meus-dependentes", method=RequestMethod.GET)
    public ModelAndView pageMeusDependentes() {
        mv = new ModelAndView("paginas-sistema/socio/meus-dependentes");
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);
        return mv;
    }

    @RequestMapping(value="/alterar-senha", method=RequestMethod.GET)
    public ModelAndView pageAlterarSenha() {
        mv = new ModelAndView("paginas-sistema/socio/alterar-senha");
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);
        return mv;
    }

    @RequestMapping(value="/financeiro", method=RequestMethod.GET)
    public ModelAndView pageFinanceiro() {
        mv = new ModelAndView("paginas-sistema/socio/financeiro");
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);
        mv.addObject("financeiros", financeiraService.getTodasMovimentacoesFinanceiras());
        return mv;
    }

    @RequestMapping(value="/atas-assembleia", method=RequestMethod.GET)
    public ModelAndView pageAtasAssembleia() {
        mv = new ModelAndView("paginas-sistema/socio/atas-assembleia");
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);
        mv.addObject("atas", ataAssembleiaService.getTodasAtasAssembleia());
        return mv;
    }
    
    @PostMapping(value="/atualizar-socio")
    public ModelAndView atualizarSocio(Socio socio) {
        socioService.atualizarSocio(socio);
        return aoIndex("msgSuccess" , "Os seus dados foram alterados com sucesso.");
    }

    @PostMapping(value="/alterar-senha")
    public ModelAndView alterarSenha(Socio socio) {
        socioService.atualizarSenhaSocio(socio);
        mv = new ModelAndView("paginas-sistema/index");
        return aoIndex("msgSuccess" , "Senha alterada com sucesso.");
    }

    @PostMapping(value="/atualizar-meus-dependentes")
    public ModelAndView atualizarMeusDependentes(Socio socio) {
        socioService.atualizarMeusDependentes(socio);
        return aoIndex("msgSuccess" , "Dependentes atualizados com sucesso.");
    }

    @DeleteMapping(value="/deletar-dependente/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletarDependente(@PathVariable("id") int id) {
        socioService.deletarDependente(id);
    }

    @RequestMapping(value="/reservar-clube", method=RequestMethod.GET)
    public ModelAndView pageAgendar() {
        mv = new ModelAndView("paginas-sistema/socio/reservas/reservar-clube");
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);
        mv.addObject("reservaCampo", new ReservaCampoFutebol());
        mv.addObject("reservaCajueiro", new ReservaEspacoCajueiro());
        mv.addObject("datasReservaCajueiro", reservaCajueiroService.getDatasReservasRealizadas());
        return mv;
    }
    
    @RequestMapping(value = "/convenios", method = RequestMethod.GET)
    public ModelAndView pageConvenios() {
        mv = new ModelAndView("paginas-sistema/socio/convenios");
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);
        mv.addObject("convenios", convenioService.getConvenios());
        mv.addObject("categorias", categoriaService.getListCategoriaConvenios());
        return mv;
    }

    @GetMapping(value="/minhas-reservas")
    public ModelAndView pageMeusEventos() {
        mv = new ModelAndView("paginas-sistema/socio/reservas/minhas-reservas");
        mv.addObject("eventCampo", reservaCampoService.getMinhasReserva());
        mv.addObject("eventCajueiro", reservaCajueiroService.getMinhasReserva());
        mv.addObject("eventChale", reservaChaleService.getMinhasReservas());
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);

        return mv;
    }

    @GetMapping(value="/reservas-clube")
    public ModelAndView pageReservasClube() {
        mv = new ModelAndView("paginas-sistema/socio/reservas/reservas-clube");
        mv.addObject("eventCampo", reservaCampoService.getReservasDoClube());
        mv.addObject("eventCajueiro", reservaCajueiroService.getReservasDoClube());
        mv.addObject("eventChale", reservaChaleService.getReservasDoClube());
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);

        return mv;
    }

    @RequestMapping(value="/carteira-identificacao", method=RequestMethod.GET)
    public ModelAndView pageSolicitarCarteira(){
        mv = new ModelAndView("paginas-sistema/socio/carteira-identificacao");
        socioLogado = socioService.getSocioByEmail();
        mv.addObject("socio", socioLogado);
        mv.addObject("solicitacoes", solicitacaoCarteiraIdentificacaoService.getMinhasSolicitacoesDeCarteiraDeIdentidade(socioLogado));
        return mv;
    }
    
    @PostMapping(value="/solicitar-carteira")
    public ModelAndView postSolicitarCarteira(@RequestParam("foto") MultipartFile foto) {
        socioLogado = socioService.getSocioByEmail();
        String statusDoSocio = socioTransferenciaService.getStatusDeAdimplenciaDo(socioLogado);
        if(statusDoSocio.equals("inadimplente")){
            mv = aoIndex("msgErro", "Não foi possível concluir a solicitação. Você está inadimplente.");
            return mv;
        }
        else{
            solicitacaoCarteiraIdentificacaoService.salvarSolicitacao(socioLogado, foto);
            mv = aoIndex("msgSuccess","Solicitação da carteira de identificação concluída. Dentro de alguns dias entraremos em contato para realizar a entrega.");
            return mv;
        }
    }
    
    public ModelAndView aoIndex(String tipoMensagem, String mensagem){
        socioLogado = socioService.getSocioByEmail();

        mv = new ModelAndView("paginas-sistema/index");
        mv.addObject("aniversariantes", socioService.getAniversariantesDoMes());
        mv.addObject("socio", socioLogado);
        mv.addObject("sociosSolicitados", socioService.getSociosSolicitados());
        mv.addObject("eventCampo", reservaCampoService.getReservaCampoSolicitada());
        mv.addObject("eventCajueiro", reservaCajueiroService.getReservaEspacoCajueiroSolicita());
        mv.addObject("eventChale", reservaChaleService.getReservasChaleSolicitas());
        mv.addObject("statusAdimp", socioTransferenciaService.getStatusDeAdimplenciaDo(socioLogado));
        mv.addObject("adimplencia", pagamentoMensalidadeService.getDadosAdimplenciaDo(socioLogado));
        mv.addObject("carteirasSolicitadas", solicitacaoCarteiraIdentificacaoService.getSolicitacoesDeCarteiraDeIdentidade());
        mv.addObject(tipoMensagem, mensagem);
        return mv;
    }
    
}