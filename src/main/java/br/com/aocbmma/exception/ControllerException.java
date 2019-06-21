package br.com.aocbmma.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import br.com.aocbmma.helper.MensageiroEmail;

@ControllerAdvice
public class ControllerException{

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView tratamentoDoErro500(HttpServletRequest req, Exception e){
        
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);

        MensageiroEmail mensageiro = new MensageiroEmail();
        mensageiro.enviarExceptionAoDesenvolvedor(sw.toString(), req.getRequestURI());

        e.printStackTrace();

        ModelAndView mv = new ModelAndView("error/500");
        return mv;
    }

}