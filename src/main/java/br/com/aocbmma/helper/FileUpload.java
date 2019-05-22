package br.com.aocbmma.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

    public static String DIRECTORY_CONVENIOS = "/uploads/img/convenios/";
    public static String DIRECTORY_FOTO_PERFIL = "/uploads/img/perfil/";
    public static String DIRECTORY_FINANCEIRO = "/uploads/files/financeiro/";
    public static String DIRECTORY_ATAS_ASSEMBLEIA = "/uploads/files/atas/";
    public static String DIRECTORY_FOTO_CARTEIRA = "/uploads/files/carteira/";

    public static String uploadServerFile(String diretorioServidor, String pathRoot, String fileName,
            MultipartFile file) throws IOException {

        byte[] bytes = file.getBytes();
        String diretorio = criaDiretorio(pathRoot, diretorioServidor);
        String file_path = pathRoot + diretorio + File.separator +  fileName;
        gravarArquivo(file_path, bytes);

        return diretorio;
    }

    public static String uploadServerFileFinanceiroOuAtaAssembleia(String diretorioServidor, String pathRoot, String fileName,
            MultipartFile file, String ano) throws IOException {

        byte[] bytes = file.getBytes();
        String diretorio = criarDiretorioPorAnoAtual(pathRoot, diretorioServidor, ano);
        String file_path = pathRoot + diretorio + File.separator +  fileName;
        gravarArquivo(file_path, bytes);

        return diretorio;
    }

    public static String criaDiretorio(String pathRoot, String diretorioServidor) {
        File directory = new File(pathRoot + diretorioServidor);
        System.out.println(directory.getPath());
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Diretório criado.");
            }
        }
        return diretorioServidor;
    }

    public static String criarDiretorioPorAnoAtual(String pathRoot, String diretorioServidor, String ano) {

        File directory = new File(pathRoot + diretorioServidor + ano);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Diretório criado.");
            }
        }
        return diretorioServidor + ano;
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
            System.out.println("Arquivo deletado");
        }
    }

}