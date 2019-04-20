package br.com.aocbmma.helper;

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

    public Session getSession() {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.aocbmma.com.br");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.enable", "false");
        properties.put("mail.test-connection", "true");

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("contato@aocbmma.com.br", "@Miguel10");
            }
        };

        Session session = Session.getInstance(properties, auth);
        return session;
    }

}