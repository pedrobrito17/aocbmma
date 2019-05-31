package br.com.aocbmma.model;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "socio")
@Component
@Scope("session")
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull
    private String nome;

    @Column
    private String path_foto_perfil;

    @Column
    @NotNull
    @CPF
    private String cpf;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_nascimento;

    @Column
    private String situacao = "solicitado";

    @Column
    private String tipoSocio;

    @Column
    private String senha;

    @Column
    private int ativo = 1;

    @OneToOne(mappedBy = "socio", cascade = CascadeType.ALL)
    private DadosContato dadosContato;

    @OneToOne(mappedBy = "socio", cascade = CascadeType.ALL)
    private DadosBancarios dadosBancarios;

    @OneToOne(mappedBy = "socio", cascade = CascadeType.ALL)
    @Nullable
    private DadosOficial dadosOficial;

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL)
    @Nullable
    private List<Dependente> dependentes;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "socio_role", joinColumns = @JoinColumn(name = "socio_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPath_foto_perfil() {
        return this.path_foto_perfil;
    }

    public void setPath_foto_perfil(String path_foto_perfil) {
        this.path_foto_perfil = path_foto_perfil;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nascimento() {
        return this.data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTipoSocio() {
        return this.tipoSocio;
    }

    public void setTipoSocio(String tipoSocio) {
        this.tipoSocio = tipoSocio;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAtivo() {
        return this.ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public DadosContato getDadosContato() {
        return this.dadosContato;
    }

    public void setDadosContato(DadosContato dadosContato) {
        this.dadosContato = dadosContato;
    }

    public DadosBancarios getDadosBancarios() {
        return this.dadosBancarios;
    }

    public void setDadosBancarios(DadosBancarios dadosBancarios) {
        this.dadosBancarios = dadosBancarios;
    }

    public DadosOficial getDadosOficial() {
        return this.dadosOficial;
    }

    public void setDadosOficial(DadosOficial dadosOficial) {
        this.dadosOficial = dadosOficial;
    }

    public List<Dependente> getDependentes() {
        return this.dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String primeiroNome() {
        // Expressão regular a ser usada
        String pattern = "^([a-zA-ZÈ-Úè-ú]+)\\s";
        // Inicialização de RegExp Pattern
        Pattern r = Pattern.compile(pattern);
        // Inicialização do verificador de pattern em texto
        Matcher m = r.matcher(this.nome);

        // Se (matcher encontrou regexp na string)
        if (m.find()) {
            // escreva o grupo encontrado
            System.out.println("Olá, " + m.group(0));
            return m.group(0);
        } else {
            // mensagem de erro
            System.out.println("Você não tem mais de um nome?");
            return "sem nome";
        }
    }

}