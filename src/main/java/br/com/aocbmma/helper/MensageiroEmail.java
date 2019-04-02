package br.com.aocbmma.helper;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MensageiroEmail {

    private SimpleMailMessage simpleMailMessage = null;

    private String emailDoPresidente = "aragao@cbm.ma.gov.br";

    public void reservaRealizadaEnviarEmail(JavaMailSender mailSender){

        simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("administracao@aocbmma.com.br");
        simpleMailMessage.setTo(emailDoPresidente);
        simpleMailMessage.setSubject("Reserva do clube");
        simpleMailMessage.setText("Nova reserva do clube.\nAcesse o sistema para verificar.");

        try {
            mailSender.send(simpleMailMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean enviarEmailDoSiteParaPresidente(JavaMailSender mailSender, Mensagem mensagem){
        simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(mensagem.getRemetente());
        simpleMailMessage.setTo(emailDoPresidente);
        simpleMailMessage.setSubject(mensagem.getAssunto());
        simpleMailMessage.setText(mensagem.getRemetente() + "\n" + mensagem.getEmail() + "\n" + mensagem.getMensagem());

        try {
            mailSender.send(simpleMailMessage);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}