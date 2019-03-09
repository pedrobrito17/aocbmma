package br.com.aocbmma.config;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilesConvenio{

    @Autowired
    ServletContext servlet;

    public void copiarImagensConvenioParaServidor(String pathDestination) {

        String source = "/home/pedro/Downloads/uploads";
        File src = new File(source);
        
        System.out.println(pathDestination);
        File destination = new File(pathDestination+"/uploads");
        
        try{
            FileUtils.copyDirectory(src, destination);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}