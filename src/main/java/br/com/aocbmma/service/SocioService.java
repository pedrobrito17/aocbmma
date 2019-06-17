package br.com.aocbmma.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import br.com.aocbmma.helper.FileUpload;
import br.com.aocbmma.model.DadosBancarios;
import br.com.aocbmma.model.DadosContato;
import br.com.aocbmma.model.DadosOficial;
import br.com.aocbmma.model.Dependente;
import br.com.aocbmma.model.Role;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.repository.DadosBancariosRepository;
import br.com.aocbmma.repository.DadosContatoRepository;
import br.com.aocbmma.repository.DadosOficialRepository;
import br.com.aocbmma.repository.Dependentes;
import br.com.aocbmma.repository.Roles;
import br.com.aocbmma.repository.Socios;

@Service
public class SocioService {

    @Autowired
    private Socios socios;

    @Autowired
    private DadosOficialRepository oficialRepository;

    @Autowired
    private DadosBancariosRepository bancariosRepository;

    @Autowired
    private DadosContatoRepository contatoRepository;

    @Autowired
    private Dependentes dependentesRepository;

    @Autowired
    private ServletContext servlet;

    @Autowired
    private Roles roles;

    @Autowired
    private Dependentes dependentes;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public String salvarSocio(Socio socio) {
        int socio_id = 0;
        Socio socioExiste = null;
        try {
            socio_id = socios.getSocioIdByEmail(socio.getDadosContato().getEmail());
            socioExiste = socios.findById(socio_id).get();
        } catch (Exception e) {
            System.out.println("NENHUM SÓCIO FOI ENCONTRADO E O RETORNO FOI NULL PARA UM TIPO PRIMITIVO.");
        }

        if (socioExiste == null) {

            DadosOficial dadosOficial = socio.getDadosOficial();
            DadosContato dadosContato = socio.getDadosContato();
            DadosBancarios dadosBancarios = socio.getDadosBancarios();
            List<Dependente> dependentes = socio.getDependentes();

            dependentes = verificarCadastroDependentes(dependentes);
            dadosOficial = verificarDadosOficial(dadosOficial);

            Role socioRole = roles.findByRole("SOCIO");
            socio.setRoles(new HashSet<Role>(Arrays.asList(socioRole)));
            socio.setSenha(bCryptPasswordEncoder.encode(socio.getSenha()));
            socio.setDadosBancarios(null);
            socio.setDadosOficial(null);
            socio.setDadosContato(null);
            socio.setDependentes(null);
            Socio socioSaved = socios.save(socio);

            dadosContato.setSocio(socioSaved);
            dadosContato = contatoRepository.save(dadosContato);
            dadosBancarios.setSocio(socioSaved);
            dadosBancarios = bancariosRepository.save(dadosBancarios);

            if (dadosOficial != null) {
                dadosOficial.setSocio(socioSaved);
                dadosOficial = oficialRepository.save(dadosOficial);
            }

            if (dependentes != null) {
                relacionarEntidadePaiComOsSeusDependentes(dependentes, socioSaved);
                for (Dependente dep : dependentes) {
                    dependentesRepository.save(dep);
                }
            }

            return "";

        } else {
            return "Este e-mail já está cadastrado. Tente novamente com outro e-mail.";
        }

    }

    private DadosOficial verificarDadosOficial(DadosOficial d) {
        if (d.getNome_guerra().isEmpty() && d.getPosto().isEmpty() && d.getLotacao().isEmpty()
                && d.getRg_militar().isEmpty() && d.getMatricula().isEmpty()) {
            return null;
        }
        return d;
    }

    private List<Dependente> verificarCadastroDependentes(List<Dependente> socioDependentes) {
        for (int i = 0; i < socioDependentes.size(); i++) {
            if (socioDependentes.get(i).getNome().isEmpty() || socioDependentes.get(i).getParentesco().isEmpty()) {
                socioDependentes.remove(i);
            }
        }
        if (socioDependentes.isEmpty()) {
            socioDependentes = null;
        }
        return socioDependentes;
    }

    private void relacionarEntidadePaiComOsSeusDependentes(List<Dependente> socioDependentes, Socio socio) {
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
    public void atualizarSituacaoSocioPara(String situacao, int id) {
        Socio socio = socios.getOne(id);
        switch (situacao) {
        case "ativo":
            socio.setSituacao("ativo");
            socio.setAtivo(1);
            socios.save(socio);
            break;
        case "inativo":
            socio.setSituacao("inativo");
            socio.setAtivo(0);
            socios.save(socio);
            break;
        }
    }

    public void salvarFotoDoPerfil(int socio_id, MultipartFile file) {

        Socio socio = findSocio(socio_id);
        if (socio.getPath_foto_perfil() != null) {
            apagaFotoSalvaNoServidor(socio);
        }

        String nameFileOrig = file.getOriginalFilename();
        int tam = nameFileOrig.length();
        int indexType = nameFileOrig.indexOf(".", tam - 5);
        String fileName = socio.getId() + nameFileOrig.substring(indexType, tam);
        String pathRoot = servlet.getRealPath("/");
        String pathFile = FileUpload.DIRECTORY_FOTO_PERFIL + fileName;

        try {
            FileUpload.uploadServerFile(FileUpload.DIRECTORY_FOTO_PERFIL, pathRoot, fileName, file);
            socio.setPath_foto_perfil(pathFile);
            socios.save(socio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void apagaFotoSalvaNoServidor(Socio socio) {
        String pathRoot = servlet.getRealPath("/");
        String pathFile = socio.getPath_foto_perfil();
        FileUpload.deleteFile(pathRoot, pathFile);
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
        try {
            socio.getDadosOficial().setId(socioBd.getId());
            socio.getDadosOficial().setSocio(socio);
        } catch (NullPointerException e) {

            socio.setDadosOficial(new DadosOficial());
            socio.getDadosOficial().setId(socioBd.getId());
            socio.getDadosOficial().setSocio(socio);

            System.out.println("O SÓCIO É CIVIL POR ISSO NÃO POSSUI DADOS DE OFICIAL: " + e.getMessage());
        }

        socios.save(socio);
    }

    public void atualizarSenhaSocio(Socio socio) {
        Socio socioBd = socios.findById(socio.getId()).get();
        socioBd.setSenha(bCryptPasswordEncoder.encode(socio.getSenha()));
        socios.save(socioBd);
    }

    public void atualizarMeusDependentes(Socio socio) {
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
        int socio_id = socios.getSocioIdByEmail(email);
        return socios.findById(socio_id).get();
    }

    // Cria um objeto do socioLogado na sessão ativa
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Transactional
    public Socio getSessionScopedSocio() {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        int socio_id = socios.getSocioIdByEmail(email);
        Socio socio = socios.findById(socio_id).get();
        return socio;
    }

    @Transactional
    public Socio getSocioByEmail() {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        int socio_id = socios.getSocioIdByEmail(email);
        Socio socio = socios.findById(socio_id).get();
        return socio;
    }

    public Collection<? extends GrantedAuthority> getRolesBySocio() {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> rols = auth.getAuthorities();
        return rols;
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

    public List<Socio> getSociosAtivosDesta(String categoria){
        return socios.findByTipoSocioAtivo(categoria);
    }

	public List<String> findAllNomesSocios() {
		return socios.findAllNomesSocios();
	}

	public Socio findSocioByNome(String nomeSocio) {
		return socios.findByNome(nomeSocio);
    }

	public String getNomeBy(int id) {
		return socios.findById(id).get().getNome();
	}

    @Transactional
	public void deletarSocio(int socio_id) {
        Socio socio = socios.findById(socio_id).get();
        socio.setRoles(null);
        socios.delete(socio);
	}
    
}