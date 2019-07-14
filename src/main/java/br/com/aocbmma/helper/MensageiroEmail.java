package br.com.aocbmma.helper;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import br.com.aocbmma.model.Socio;

public class MensageiroEmail {

    private SimpleMailMessage simpleMailMessage = null;

    private String emailDoPresidente = "aocbmma@gmail.com";
    // private String emailDoPresidente = "pedrobrito17@gmail.com";

    public void reservaRealizadaEnviarEmail() {

        Message message = new MimeMessage(getSession());
        try {
            message.setFrom(new InternetAddress("contato@aocbmma.com.br"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDoPresidente));
            message.setSubject("Reserva do clube");
            message.setContent("<h1>Nova reserva do clube.</h1><p>Acesse o sistema para verificar.</p>", "text/html");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void emailParaAlterarSenha(Socio socio) {

        String email_socio = socio.getDadosContato().getEmail();
        String nome_socio = socio.getDadosOficial().getPosto() + " " + socio.getDadosOficial().getNome_guerra();
        String link = "http://31.220.61.60/nova-senha/"+socio.getId();

        Message message = new MimeMessage(getSession());
        try {
            message.setFrom(new InternetAddress("contato@aocbmma.com.br"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse( email_socio ));
            message.setSubject("Alteração de senha do sistema da AOCBMMA");
            message.setContent(
                "<h3>Prezado(a) " + nome_socio + ",</h3>"+
                "<p>clique no link abaixo para concluir a alteração da sua senha.</p>"+
                "<a href='"+ link +"'>Alterar minha senha</a>", "text/html");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public boolean enviarEmailDoSiteParaPresidente(JavaMailSender mailSender, Mensagem mensagem) {
        simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("contato@aocbmma.com.br");
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

    public void enviarExceptionAoDesenvolvedor(String error, String url){
        Message message = new MimeMessage(getSession());
        try {
            message.setFrom(new InternetAddress("contato@aocbmma.com.br"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("pedrobrito17@gmail.com"));
            message.setSubject("Error 500");
            message.setContent(
                "<p>URL: "+ url +"</p>"+
                "<p>Datetime: " + new Date() + "</p>"+
                "<p>Erro: "+ error +"</p>" 
                , "text/html");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public Session getSession() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.weblink.com.br");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.enable", "false");
        properties.put("mail.test-connection", "true");

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("contato@aocbmma.com.br", "FUSh3WTSn0Cy");
            }
        };

        Session session = Session.getInstance(properties, auth);
        return session;
    }

}