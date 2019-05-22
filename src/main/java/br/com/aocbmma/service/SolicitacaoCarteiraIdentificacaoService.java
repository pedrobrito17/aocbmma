package br.com.aocbmma.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.aocbmma.helper.FileUpload;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.model.SolicitacaoCarteiraIdentificacao;
import br.com.aocbmma.repository.SolicitacaoCarteiraIdentificacaoRepository;

@Service
public class SolicitacaoCarteiraIdentificacaoService{

    @Autowired
    private SolicitacaoCarteiraIdentificacaoRepository repository;

    private SolicitacaoCarteiraIdentificacao solicitacaoCarteiraIdentificacao;

    @Autowired
    private ServletContext servlet;

	public void salvarSolicitacao(Socio socioLogado, MultipartFile foto) {

        solicitacaoCarteiraIdentificacao = new SolicitacaoCarteiraIdentificacao();
        solicitacaoCarteiraIdentificacao.setSocio(socioLogado);
        solicitacaoCarteiraIdentificacao.setStatus("solicitado");
        String path = salvarFotoNoServidor(foto);
        solicitacaoCarteiraIdentificacao.setFoto(path);
        repository.save(solicitacaoCarteiraIdentificacao);

    }
    
    public String salvarFotoNoServidor(MultipartFile foto){

        String fileName = foto.getOriginalFilename();
        String pathRoot = servlet.getRealPath("/");
        String pathFile = FileUpload.DIRECTORY_FOTO_CARTEIRA + fileName;

        try {
            FileUpload.uploadServerFile(FileUpload.DIRECTORY_FOTO_CARTEIRA, pathRoot, fileName, foto);
            return pathFile;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

	public List<SolicitacaoCarteiraIdentificacao> getSolicitacoesDeCarteiraDeIdentidade() {
		return repository.findByStatus("solicitado");
	}

	public void atualizarStatusParaPronta(int cod) {
        SolicitacaoCarteiraIdentificacao carteira = repository.findById(cod).get();
        carteira.setStatus("pronto");
        repository.save(carteira);
	}

	public List<SolicitacaoCarteiraIdentificacao> getMinhasSolicitacoesDeCarteiraDeIdentidade(Socio socioLogado) {
		return repository.findBySocioOrderByDataSolicitacaoDesc(socioLogado.getId());
	}

	public List<SolicitacaoCarteiraIdentificacao> getTodasSolicitacoes() {
		return repository.findAllOrderByDataSolicitacaoDesc();
	}
    
}