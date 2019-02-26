package br.com.aocbmma.helper;

public class Mensagem {

    private String remetente;

    private String email;

    private String assunto;

    private String mensagem;


    public Mensagem() {
    }

    public Mensagem(String remetente, String email, String destinatario, String assunto, String mensagem) {
        this.remetente = remetente;
        this.email = email;
        this.assunto = assunto;
        this.mensagem = mensagem;
    }

    public String getRemetente() {
        return this.remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAssunto() {
        return this.assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}