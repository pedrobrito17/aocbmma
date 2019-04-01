package br.com.aocbmma.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload{

    public static String DIRECTORY_CONVENIOS = "/uploads/img/convenios/";
    public static String DIRECTORY_FOTO_PERFIL = "/uploads/img/perfil/";
    public static String DIRECTORY_NOTICIAS = "/uploads/img/noticias/";

    public static void uploadServerImgConvenio(String diretorioServidor, String pathRoot, String fileName, MultipartFile file) throws IOException{
        String file_path = diretorioServidor + File.separator + fileName;
        byte[] bytes = file.getBytes();

        criaDiretorioConvenio(pathRoot, diretorioServidor);
        FileOutputStream fout = new FileOutputStream(pathRoot + file_path);
        fout.write(bytes);
        fout.close();
    }

    public static void criaDiretorioConvenio(String pathRoot, String diretorioServidor){
        File directory = new File(pathRoot + diretorioServidor);
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