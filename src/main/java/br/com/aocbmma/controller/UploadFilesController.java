package br.com.aocbmma.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import br.com.aocbmma.model.Socio;
import br.com.aocbmma.model.aux.DadosUploadFilesDoc;
import br.com.aocbmma.service.SocioService;
import br.com.aocbmma.service.UploadFilesDocService;

@Controller
public class UploadFilesController {

    @Autowired
    private UploadFilesDocService service;

    @Autowired
    private SocioService socioService;

    @Autowired
    private ServletContext servlet;

    @RequestMapping(value = "/sisaocbmma/upload-files", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody String postUploadFiles(@RequestParam("file") MultipartFile[] files) {

        try {
            service.saveFiles(files);
            
            ObjectMapper mapperJson = new ObjectMapper();
            try {
                List<DadosUploadFilesDoc> dados = service.getAllDadosUploadFilesDocBySocioLogado();
                String json = mapperJson.writeValueAsString(dados);
                return json;
            } catch (JsonProcessingException e) {
                return "{\"msg\": \"gravou\"}";
            }

        } catch (IOException e) {
            return "{\"msg\": \"vazio\"}";
        }
    }

    @PostMapping(value="/sisaocbmma/deletar-upload-file-doc/{id}")
    public @ResponseBody String deletarUploadFile(@PathVariable("id") int id) {
        try {
            service.deletarUploadFile(id);
            return "true";
        } catch (IOException e) {
            return "false";
        }
    }

    @RequestMapping(value="/admin/download-files-doc-zip", method=RequestMethod.GET)
    public ModelAndView pageUploadFilesDocAdmin() {
        Socio socioLogado = socioService.getSocioByEmail();
        ModelAndView mv = new ModelAndView("paginas-sistema/admin/download-docs");
        mv.addObject("socio", socioLogado);
        mv.addObject("dadosUploadDoc", service.getDadosSelectUploadFilesDoc());
        return mv;
    }

    @GetMapping(value="/admin/download-zip/{id}")
    public HttpEntity<byte[]> getFileZip(@PathVariable("id") int id) {
        String path_root = servlet.getRealPath("/");
        String nome_socio = socioService.getNomeBy(id);
        byte[] fileZipBytes = service.getArquivoZipByte(path_root, id, nome_socio);
        String name_file = nome_socio+".zip";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment; filename=\"" + name_file + "\"");

        HttpEntity<byte[]> httpEntity = new HttpEntity<byte[]>( fileZipBytes, httpHeaders );
        return httpEntity;
    }
}