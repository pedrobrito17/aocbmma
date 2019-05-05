package br.com.aocbmma.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.aocbmma.model.Dependente;
import br.com.aocbmma.model.Role;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.repository.Dependentes;
import br.com.aocbmma.repository.Roles;
import br.com.aocbmma.repository.Socios;

@Service
public class SocioService {

    @Autowired
    private Socios socios;

    @Autowired
    private Roles roles;

    @Autowired
    private Dependentes dependentes;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public String salvarSocio(Socio socio) {
        Socio socioExiste = socios.findByEmail(socio.getDadosContato().getEmail());

        if (socioExiste == null) {
            verificarCadastroDependentes(socio.getDependentes());
            relacionarEntidadePaiComEntidadeFilha(socio);

            Role socioRole = roles.findByRole("SOCIO");
            socio.setRoles(new HashSet<Role>(Arrays.asList(socioRole)));
            socio.setSenha(bCryptPasswordEncoder.encode(socio.getSenha()));
            socios.save(socio);

            return "";
        }
        return "Este e-mail já está cadastrado. Tente novamente com outro e-mail.";

    }

    public void relacionarEntidadePaiComEntidadeFilha(Socio socio) {
        socio.getDadosBancarios().setSocio(socio);
        socio.getDadosContato().setSocio(socio);
        socio.getDadosOficial().setSocio(socio);

        List<Dependente> dependentes = socio.getDependentes();
        relacionarEntidadePaiComOsSeusDependentes(dependentes, socio);
    }

    public void verificarCadastroDependentes(List<Dependente> socioDependentes) {
        for (int i = 0; i < socioDependentes.size(); i++) {
            if (socioDependentes.get(i).getNome().isEmpty() || socioDependentes.get(i).getParentesco().isEmpty()) {
                socioDependentes.remove(i);
            }
        }
        if (socioDependentes.isEmpty()) {
            socioDependentes = null;
        }
    }

    public void relacionarEntidadePaiComOsSeusDependentes(List<Dependente> socioDependentes, Socio socio) {
        if (socioDependentes != null) {
            for (int i = 0; i < socioDependentes.size(); i++) {
                socioDependentes.get(i).setSocio(socio);
            }
        }
    }

    public List<Socio> getSociosSolicitados() {
        return socios.findBySituacao("solicitado");
    }

    @Transactional
    public void atualizarSituacaoSocio(int id) {
        Socio socio = socios.getOne(id);
        socio.setSituacao("ativo");
        socio.setAtivo(1);
        socios.save(socio);
    }

    public void atualizarSocio(Socio socio) {
        Socio socioBd = socios.findById(socio.getId()).get();
        
        socio.setRoles(socioBd.getRoles());
        socio.setDependentes(socioBd.getDependentes());
        socio.setSenha(socioBd.getSenha());
        socio.setAtivo(socioBd.getAtivo());

        socio.getDadosBancarios().setId(socioBd.getId());
        socio.getDadosBancarios().setSocio(socio);
        socio.getDadosContato().setId(socioBd.getId());
        socio.getDadosContato().setSocio(socio);
        socio.getDadosOficial().setId(socioBd.getId());
        socio.getDadosOficial().setSocio(socio);
        
        socios.save(socio);
    }

    public void atualizarSenhaSocio(Socio socio){
        Socio socioBd = socios.findById(socio.getId()).get();
        socioBd.setSenha(bCryptPasswordEncoder.encode(socio.getSenha()));
        socios.save(socioBd);
    }

    public void atualizarMeusDependentes(Socio socio){
        Socio socioBd = socios.findById(socio.getId()).get();
        
        verificarCadastroDependentes(socio.getDependentes());
        relacionarEntidadePaiComOsSeusDependentes(socio.getDependentes(), socioBd);

        socioBd.setDependentes(socio.getDependentes());
        socios.save(socioBd);
    }

    public List<Socio> getAniversariantesDoMes() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        return socios.getAniversariantes(month);
    }

    public Socio findSocioByEmail(String email) {
        return socios.findByEmail(email);
    }

    @Transactional
    public Socio getSocioByEmail() {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        Socio socioIncompleto = socios.findByEmail(email);
        Socio socio = socios.findById(socioIncompleto.getId()).get();
        return socio;
    }

	public boolean deletarDependente(int id) {
        dependentes.deleteById(id);
        return true;
    }
    
    public Socio findSocio(int id){
        return socios.findById(id).get();
    }

    public List<Socio> getSociosDesta(String categoria){
        return socios.findByTipoSocio(categoria);
    }
}