package br.com.aocbmma.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.aocbmma.helper.FormatadorData;
import br.com.aocbmma.model.ReservaCampoFutebol;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.service.ReservaCampoFutebolService;
import br.com.aocbmma.service.SocioService;


@Controller
@RequestMapping("/sisaocbmma")
public class ReservaController{

    @Autowired
    private ReservaCampoFutebolService reservaCampoService;

    @Autowired
    private SocioService socioService;

    private ModelAndView mv = null;

    @PostMapping(value="/salvar-reserva-campo-futebol")
    public ModelAndView salvarReservaCampo(ReservaCampoFutebol reserva){
        Socio socio = socioService.getSocioByEmail();
        reserva.setSocio(socio);
        reservaCampoService.salvarReservaCampoFutebol(reserva);
        mv = new ModelAndView("paginas-sistema/sisaocbmma/index");
        return mv;
    }

    @GetMapping(value="/horas-iniciais/{data}")
    @ResponseBody
    public List<String> getHorasIniciais(@PathVariable("data") String data) {

        Date dataFormat = FormatadorData.getDataFormatadaNoPadraoUtil(data);

        List<String> horas_iniciais = reservaCampoService.getHorasIniciais(dataFormat);
        return horas_iniciais;
    }

    @GetMapping(value="/horas-terminais/{data}")
    @ResponseBody
    public List<String> getHorasTerminais(@PathVariable("data") String data) {

        Date dataFormat = FormatadorData.getDataFormatadaNoPadraoUtil(data);

        List<String> horas_terminais = reservaCampoService.getHorasTerminais(dataFormat);
        return horas_terminais;
    }

    
    

}