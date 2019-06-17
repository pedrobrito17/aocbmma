package br.com.aocbmma.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.aocbmma.helper.FormatadorData;
import br.com.aocbmma.helper.MensageiroEmail;
import br.com.aocbmma.model.Chale;
import br.com.aocbmma.model.ReservaCampoFutebol;
import br.com.aocbmma.model.ReservaChale;
import br.com.aocbmma.model.ReservaEspacoCajueiro;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.PagamentoMensalidadeService;
import br.com.aocbmma.service.ReservaCampoFutebolService;
import br.com.aocbmma.service.ReservaChaleService;
import br.com.aocbmma.service.ReservaEspacoCajueiroService;
import br.com.aocbmma.service.SocioService;
import br.com.aocbmma.service.SocioTransferenciaService;
import br.com.aocbmma.service.SolicitacaoCarteiraIdentificacaoService;



@Controller
public class ReservaController {

    @Autowired
    private ReservaCampoFutebolService reservaCampoService;

    @Autowired
    private ReservaEspacoCajueiroService reservaCajueiroService;

    @Autowired
    private ReservaChaleService reservaChaleService;

    @Autowired
    private PagamentoMensalidadeService pagamentoMensalidadeService;

    @Autowired
    private SocioTransferenciaService socioTransferenciaService;

    @Autowired
    private SolicitacaoCarteiraIdentificacaoService solicitacaoCarteiraIdentificacaoService;

    @Autowired
    private SocioService socioService;

    private ModelAndView mv = null;

    private MensageiroEmail mensageiroEmail = null;

    private Socio socioLogado = null;

    private String msgSuccess = "Solicitação da reserva concluída. Garanta sua reserva realizando o pagamento da taxa em até 48H, caso contrário "
    + "a reserva estará novamente disponível no sistema.";

    private String msgErro = "Não foi possível concluir a reserva. Você está inadimplente.";

    @PostMapping(value = "/sisaocbmma/salvar-reserva-campo-futebol")
    public ModelAndView salvarReservaCampo(ReservaCampoFutebol reserva) {
        if(socioLogadoEstaInadimplente()){
            return aoIndex("msgErro", msgErro);
        }
        reservaCampoService.salvarReservaCampoFutebol(reserva);
        mensageiroEmail = new MensageiroEmail();
        mensageiroEmail.reservaRealizadaEnviarEmail();
        return aoIndex("msgSuccess", msgSuccess);
    }

    @PostMapping(value = "/sisaocbmma/salvar-reserva-espaco-cajueiro")
    public ModelAndView salvarReservaEspacoCajueiro(ReservaEspacoCajueiro reserva) {
        if(socioLogadoEstaInadimplente()){
            return aoIndex("msgErro", msgErro);
        }
        reservaCajueiroService.salvarReserva(reserva);
        mensageiroEmail = new MensageiroEmail();
        mensageiroEmail.reservaRealizadaEnviarEmail();
        return aoIndex("msgSuccess", msgSuccess);
    }

    @GetMapping(value = "/sisaocbmma/horas-iniciais/{data}")
    @ResponseBody
    public List<String> getHorasIniciais(@PathVariable("data") String data) {
        Date dataFormat = FormatadorData.getDataFormatadaNoPadraoUtil(data);
        List<String> horas_iniciais = reservaCampoService.getHorasIniciais(dataFormat);
        return horas_iniciais;
    }

    @GetMapping(value = "/sisaocbmma/horas-terminais/{data}")
    @ResponseBody
    public List<String> getHorasTerminais(@PathVariable("data") String data) {
        Date dataFormat = FormatadorData.getDataFormatadaNoPadraoUtil(data);
        List<String> horas_terminais = reservaCampoService.getHorasTerminais(dataFormat);
        return horas_terminais;
    }

    @GetMapping(value = "/admin/confirmar-reserva/{item}/{id}")
    public ModelAndView getMethodName(@PathVariable("item") String item, @PathVariable("id") int id) {
        switch (item) {
        case "campo":
            reservaCampoService.confirmarReserva(id);
            break;
        case "cajueiro":
            reservaCajueiroService.confirmarReserva(id);
            break;
        case "chale":
            reservaChaleService.confirmarReserva(id);
            break;
        }
        mv = new ModelAndView("redirect:/");
        return mv;
    }

    @GetMapping(value = "/sisaocbmma/pesquisar-chale/{entrada}/{saida}")
    public String pesquisarDisponibilidadeChales(@PathVariable("entrada") String entrada,
            @PathVariable("saida") String saida, Model model) {
        Date data_entrada = FormatadorData.getDataFormatadaNoPadraoUtil(entrada);
        Date data_saida = FormatadorData.getDataFormatadaNoPadraoUtil(saida);
        List<Chale> chalesDisponiveisParaReservar = reservaChaleService.verificarDisponibilidadeChale(data_entrada,
                data_saida);
        model.addAttribute("chalesDisponiveis", chalesDisponiveisParaReservar);
        model.addAttribute("reserva", new ReservaChale());
        return "padrao/reserva :: chales-disponiveis";
    }

    @PostMapping(value = "/sisaocbmma/salvar-reserva-chale")
    public ModelAndView salvarReservaChale(ReservaChale reservaChale) {
        if(socioLogadoEstaInadimplente()){
            return aoIndex("msgErro", msgErro);
        }
        reservaChaleService.salvarReserva(reservaChale);
        mensageiroEmail = new MensageiroEmail();
        mensageiroEmail.reservaRealizadaEnviarEmail();
        return aoIndex("msgSuccess", msgSuccess);
    }

    @GetMapping(value="/admin/deletar-reserva/{item}/{id}")
    public ModelAndView deletarReserva(@PathVariable("item") String item, @PathVariable("id") int id_reserva, RedirectAttributes redirectAttributes) {
        switch(item){
            case "campo":
                reservaCampoService.deletarReserva(id_reserva);
                break;
            case "cajueiro":
                reservaCajueiroService.deletarReserva(id_reserva);
                break;
            case "chale":
                reservaChaleService.deletarReserva(id_reserva);
                break;
        }
        redirectAttributes.addFlashAttribute("msgSuccess", "Reserva deletada com sucesso.");        
        return new ModelAndView("redirect:/admin/reservas-clube");
    }
    
    @GetMapping(value="/admin/atualizar-status-reserva/{item}/{id}")
    public ModelAndView atualizarStatusReserva(@PathVariable("item") String item, @PathVariable("id") int id_reserva, RedirectAttributes redirectAttributes) {
        switch(item){
            case "campo":
                reservaCampoService.confirmarReserva(id_reserva);
                break;
            case "cajueiro":
                reservaCajueiroService.confirmarReserva(id_reserva);
                break;
            case "chale":
                reservaChaleService.confirmarReserva(id_reserva);
                break;
        }
        redirectAttributes.addFlashAttribute("msgSuccess", "Status de pagamento da reserva atualizado com sucesso.");        
        return new ModelAndView("redirect:/admin/reservas-clube");
    }
    
    

    public ModelAndView aoIndex(String msgTipo, String msg) {
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
        mv.addObject(msgTipo, msg);
        return mv;
    }

    public boolean socioLogadoEstaInadimplente(){
        socioLogado = socioService.getSocioByEmail();
        String statusDoSocio = socioTransferenciaService.getStatusDeAdimplenciaDo(socioLogado);
        if(statusDoSocio.equals("inadimplente")){
            return true;
        }
        else{
            return false;
        }
    }

}