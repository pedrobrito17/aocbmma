package br.com.aocbmma.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

    public static String DIRECTORY_CONVENIOS = "/uploads/img/convenios/";
    public static String DIRECTORY_FOTO_PERFIL = "/uploads/img/perfil/";
    public static String DIRECTORY_NOTICIAS = "/uploads/img/noticias/";
    public static String DIRECTORY_FINANCEIRO = "/uploads/files/financeiro/";

    public static String uploadServerFile(String diretorioServidor, String pathRoot, String fileName,
            MultipartFile file) throws IOException {

        byte[] bytes = file.getBytes();
        String diretorio = criaDiretorio(pathRoot, diretorioServidor);
        String file_path = pathRoot + diretorio + File.separator +  fileName;
        gravarArquivo(file_path, bytes);

        return diretorio;
    }

    public static String uploadServerFileFinanceiro(String diretorioServidor, String pathRoot, String fileName,
            MultipartFile file, String ano) throws IOException {

        byte[] bytes = file.getBytes();
        String diretorio = criarDiretorioFinanceiro(pathRoot, diretorioServidor, ano);
        String file_path = pathRoot + diretorio + File.separator +  fileName;
        gravarArquivo(file_path, bytes);

        return diretorio;
    }

    public static String criaDiretorio(String pathRoot, String diretorioServidor) {
        if (!diretorioServidor.equals(DIRECTORY_NOTICIAS)) {
            File directory = new File(pathRoot + diretorioServidor);
            System.out.println(directory.getPath());
            if (!directory.exists()) {
                if (directory.mkdirs()) {
                    System.out.println("Diretório criado.");
                }
            }
            return diretorioServidor;
        }
        else{
            return criarDiretorioNoticia(pathRoot, diretorioServidor);
        }
    }

    public static String criarDiretorioFinanceiro(String pathRoot, String diretorioServidor, String ano) {

        File directory = new File(pathRoot + diretorioServidor + ano);
        System.out.println(directory.getPath());
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Diretório criado.");
            }
        }
        return diretorioServidor + ano;
    }

    public static String criarDiretorioNoticia(String pathRoot, String diretorioServidor) {
        Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH) + 1;

        File directory = new File(pathRoot + diretorioServidor + ano + File.separator + mes);
        System.out.println(directory.getPath());
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Diretório criado.");
            }
        }
        return diretorioServidor + ano + File.separator + mes;
    }

    public static void gravarArquivo(String file_path, byte[] bytes) {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(file_path);
            fout.write(bytes);
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String pathRoot, String pathFile) {
        File file = new File(pathRoot + pathFile);
        if (file.delete()) {
            System.out.println("deletado");
        }
    }

}