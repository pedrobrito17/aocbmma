package br.com.aocbmma.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.aocbmma.helper.MensageiroEmail;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.PagamentoMensalidadeService;
import br.com.aocbmma.service.ReservaCampoFutebolService;
import br.com.aocbmma.service.ReservaChaleService;
import br.com.aocbmma.service.ReservaEspacoCajueiroService;
import br.com.aocbmma.service.SocioService;
import br.com.aocbmma.service.SocioTransferenciaService;
import br.com.aocbmma.service.SolicitacaoCarteiraIdentificacaoService;
import br.com.aocbmma.service.UploadFilesDocService;


@Controller
public class HomeController{

    @Autowired
    private SocioService socioService;

    @Autowired
    private ReservaEspacoCajueiroService reservaCajueiroService;

    @Autowired
    private ReservaCampoFutebolService reservaCampoService;

    @Autowired
    private ReservaChaleService reservaChaleService;

    @Autowired
    private PagamentoMensalidadeService pagamentoMensalidadeService;

    @Autowired
    private SocioTransferenciaService socioTransferenciaService;

    @Autowired
    private SolicitacaoCarteiraIdentificacaoService solicitacaoCarteiraIdentificacaoService;

    @Autowired
    private UploadFilesDocService uploadFilesDocService;

    private Socio socioLogado = null;

    private ModelAndView mv = null;

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String pageLogin() {
        return "paginas-sistema/login";
    }

    @RequestMapping(value="/esqueceu-senha", method=RequestMethod.GET)
    public String pageEsqueceuSenha() {
        return "paginas-sistema/esqueceu-senha";
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public ModelAndView pageIndex() {
        
        socioLogado = socioService.getSocioByEmail();
        mv = new ModelAndView("paginas-sistema/index");
        mv.addObject("aniversariantes", socioService.getAniversariantesDoMes());
        mv.addObject("socio", socioLogado);
        mv.addObject("statusAdimp", socioTransferenciaService.getStatusDeAdimplenciaDo(socioLogado));
        mv.addObject("adimplencia", pagamentoMensalidadeService.getDadosAdimplenciaDo(socioLogado));
        mv.addObject("uploadfiles", uploadFilesDocService.getAllUploadFilesDocBySocioLogado(socioLogado));
        
        Collection<? extends GrantedAuthority> roles = socioService.getRolesBySocio();
        Iterator<? extends GrantedAuthority> iterator = roles.iterator();
        while(iterator.hasNext()){
            GrantedAuthority granted = iterator.next();
            String role = granted.getAuthority();
            if(role.equals("ADMIN")){
                reservaCampoService.cancelarReservarComPagamentoVencido();
                reservaCajueiroService.cancelarReservarComPagamentoVencido();
                reservaChaleService.cancelarReservarComPagamentoVencido();
                
                mv.addObject("sociosSolicitados", socioService.getSociosSolicitados());
                mv.addObject("eventCampo", reservaCampoService.getReservaCampoSolicitada());
                mv.addObject("eventCajueiro", reservaCajueiroService.getReservaEspacoCajueiroSolicita());
                mv.addObject("eventChale", reservaChaleService.getReservasChaleSolicitas());
                mv.addObject("carteirasSolicitadas", solicitacaoCarteiraIdentificacaoService.getSolicitacoesDeCarteiraDeIdentidade());
            }
        }
        return mv;
    }

    @PostMapping(value="/recuperar-senha")
    public ModelAndView postRecuperarSenha(@RequestParam String email) {
        Socio socio = socioService.findSocioByEmail(email);

        if(socio != null){
            MensageiroEmail mensageiroEmail = new MensageiroEmail();
            mensageiroEmail.emailParaAlterarSenha(socio);

            ModelAndView mv = new ModelAndView("paginas-sistema/esqueceu-senha");
            mv.addObject("msg", "Um e-mail foi enviado para sua caixa de entrada.");
            return mv;
        }
        
        ModelAndView mv = new ModelAndView("paginas-sistema/esqueceu-senha");
        mv.addObject("msgerro", "Seu e-mail está incorreto.");
        return mv;
    }

    @RequestMapping(value="/nova-senha/{id}", method=RequestMethod.GET)
    public ModelAndView requestMethodName(@PathVariable("id") int id) {
        Socio socio = socioService.findSocio(id);

        ModelAndView mv = new ModelAndView("paginas-sistema/alterar-senha");
        mv.addObject("socio", socio);
        return mv;
    }

    @PostMapping(value="/alterar-senha")
    public ModelAndView postAlterarSenha(@RequestParam int id, @RequestParam String senha) {
        Socio socio = new Socio();
        socio.setId(id);
        socio.setSenha(senha);
        socioService.atualizarSenhaSocio(socio);

        ModelAndView mv = new ModelAndView("paginas-sistema/login");
        mv.addObject("msg", "Senha alterada com sucesso.");
        return mv;
    }
    
    
    
}