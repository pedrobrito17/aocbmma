package br.com.aocbmma.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import br.com.aocbmma.helper.UploadFilesDocHelper;
import br.com.aocbmma.helper.ZipDirectory;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.model.UploadFilesDoc;
import br.com.aocbmma.model.aux.DadosSelectUploadFilesDoc;
import br.com.aocbmma.model.aux.DadosUploadFilesDoc;
import br.com.aocbmma.repository.UploadFilesDocRepository;

@Service
public class UploadFilesDocService {

    @Autowired
    private SocioService socioService;

    @Autowired
    private SocioTransferenciaService socioTransferenciaService;

    @Autowired
    private ServletContext servlet;

    @Autowired
    private UploadFilesDocRepository repository;

    private Socio socioLogado;

    private UploadFilesDocHelper uploadHelper = new UploadFilesDocHelper();

    @Transactional
    public boolean saveFiles(MultipartFile[] files) {
        socioLogado = socioService.getSocioByEmail();
        String status = socioTransferenciaService.getStatusDeAdimplenciaDo(socioLogado);

        if (status.equals("adimplente") || status.isEmpty()) {
            return save(files);
        }
        return false;
    }

    public boolean save(MultipartFile[] files) {
        String pathRoot = servlet.getRealPath("/");
        int socio_id = socioLogado.getId();

        for (MultipartFile file : files) {
            boolean uploadServer = uploadHelper.uploadFileServer(pathRoot, file, socio_id);
            String name = file.getOriginalFilename();

            if (uploadServer) {
                String path_file = getPathFile(file);
                UploadFilesDoc uploadFiles = new UploadFilesDoc();
                uploadFiles.setSocio(socioLogado);
                uploadFiles.setPath_file(path_file);
                uploadFiles.setName_file(name);
                uploadFiles.setTamanho(file.getSize());
                uploadFiles.setDataInsercao(new Date());
                repository.save(uploadFiles);
            } else {
                return false;
            }
        }
        return true;
    }

    public String getPathFile(MultipartFile file) {
        String directory = UploadFilesDocHelper.DIRECTORY_DOCS;
        String name = file.getOriginalFilename();
        int socio_id = socioLogado.getId();
        return directory + socio_id + File.separator + name;
    }

    public List<UploadFilesDoc> getAllUploadFilesDocBySocioLogado(Socio socioLogado) {
        return repository.findBySocio(socioLogado);
    }

    public List<DadosUploadFilesDoc> getAllDadosUploadFilesDocBySocioLogado() {
        socioLogado = socioService.getSocioByEmail();
        List<UploadFilesDoc> uploadFiles = repository.findBySocio(socioLogado);

        List<DadosUploadFilesDoc> listDados = new ArrayList<DadosUploadFilesDoc>();
        for (UploadFilesDoc upload : uploadFiles) {
            DadosUploadFilesDoc dados = new DadosUploadFilesDoc();
            dados.setId(upload.getId());
            dados.setName(upload.getName_file());
            dados.setPath(upload.getPath_file());
            dados.setTamanho(upload.getTamanho());
            dados.setSocioid(upload.getSocio().getId());
            listDados.add(dados);
        }
        return listDados;
    }

    public void deletarUploadFile(int id) {
        String pathRoot = servlet.getRealPath("/");
        UploadFilesDoc uploadFile = repository.getOne(id);
        repository.deleteById(id);
        uploadHelper.deleteFile(pathRoot, uploadFile);
    }

    public List<DadosSelectUploadFilesDoc> getDadosSelectUploadFilesDoc() {
        return new DadosSelectUploadFilesDoc().getLista(repository.getDadosViewAdmin());
    }

    public byte[] getArquivoZipByte(String path_root, int socio_id, String nomeSocio) {
        try {
            ZipDirectory zipDirectory = new ZipDirectory();
            zipDirectory.createZipDirectory(path_root, socio_id, nomeSocio);
            return zipDirectory.getZipFile(path_root, nomeSocio);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
	}

	public String getNomeSocioLogado() {
        socioLogado = socioService.getSocioByEmail();
        return socioLogado.getNome();        
	}

}