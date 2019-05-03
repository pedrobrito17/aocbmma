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

import br.com.aocbmma.helper.FormatadorData;
import br.com.aocbmma.helper.MensageiroEmail;
import br.com.aocbmma.model.Chale;
import br.com.aocbmma.model.ReservaCampoFutebol;
import br.com.aocbmma.model.ReservaChale;
import br.com.aocbmma.model.ReservaEspacoCajueiro;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.ReservaCampoFutebolService;
import br.com.aocbmma.service.ReservaChaleService;
import br.com.aocbmma.service.ReservaEspacoCajueiroService;
import br.com.aocbmma.service.SocioService;

@Controller
public class ReservaController {

    @Autowired
    private ReservaCampoFutebolService reservaCampoService;

    @Autowired
    private ReservaEspacoCajueiroService reservaCajueiroService;

    @Autowired
    private ReservaChaleService reservaChaleService;

    @Autowired
    private SocioService socioService;

    private ModelAndView mv = null;

    private MensageiroEmail mensageiroEmail = null;

    private Socio socio = null;

    @PostMapping(value = "/sisaocbmma/salvar-reserva-campo-futebol")
    public ModelAndView salvarReservaCampo(ReservaCampoFutebol reserva) {
        reservaCampoService.salvarReservaCampoFutebol(reserva);
        mensageiroEmail = new MensageiroEmail();
        mensageiroEmail.reservaRealizadaEnviarEmail();
        return aoIndex();
    }

    @PostMapping(value = "/sisaocbmma/salvar-reserva-espaco-cajueiro")
    public ModelAndView salvarReservaEspacoCajueiro(ReservaEspacoCajueiro reserva) {
        reservaCajueiroService.salvarReserva(reserva);
        mensageiroEmail = new MensageiroEmail();
        mensageiroEmail.reservaRealizadaEnviarEmail();
        return aoIndex();
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
        mv = new ModelAndView("redirect:/admin");
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
        reservaChaleService.salvarReserva(reservaChale);
        mensageiroEmail = new MensageiroEmail();
        mensageiroEmail.reservaRealizadaEnviarEmail();
        return aoIndex();
    }

    public ModelAndView aoIndex() {
        socio = socioService.getSocioByEmail();

        mv = new ModelAndView("paginas-sistema/index");
        mv.addObject("aniversariantes", socioService.getAniversariantesDoMes());
        mv.addObject("socio", socio);
        mv.addObject("msgSuccess",
                "Solicitação de reserva concluída. Garanta sua reserva realizando o pagamento da taxa em até 48H, caso contrário "
                        + "a reserva estará novamente disponível no sistema.");
        return mv;
    }

}