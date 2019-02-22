package br.com.aocbmma.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload{

    public static String DIRECTORY_CONVENIOS = "/uploads/img/convenios/";

    public static void uploadServerImgConvenio(String pathRoot, MultipartFile logo) throws IOException{
        System.out.println(pathRoot);
        String file_path = DIRECTORY_CONVENIOS + File.separator + logo.getOriginalFilename();
        byte[] bytes = logo.getBytes();

        criaDiretorioConvenio(pathRoot);
        FileOutputStream fout = new FileOutputStream(pathRoot + file_path);
        fout.write(bytes);
        fout.close();
    }

    public static void criaDiretorioConvenio(String pathRoot){
        File directory = new File(pathRoot + DIRECTORY_CONVENIOS);
        System.out.println(directory.getPath());
        if(!directory.exists()){
            if(directory.mkdirs()){
                System.out.println("Diretório criado.");
            }
        } 
    }

    public static void deleteFile(String pathRoot, String pathFile){
        File file = new File(pathRoot + pathFile);
        if(file.delete()){
            System.out.println("deletado");
        }
    }


}