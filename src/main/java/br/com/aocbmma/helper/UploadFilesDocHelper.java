package br.com.aocbmma.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import br.com.aocbmma.model.UploadFilesDoc;

public class UploadFilesDocHelper {

    public static String DIRECTORY_DOCS = "uploads/docs/";

    private String path_file;

    private String path_root_file;

    public boolean uploadFileServer(String pathRoot, MultipartFile file, int socio_id) {
        boolean diretorioFoiCriado = createDirectory(pathRoot, socio_id);
        path_file = DIRECTORY_DOCS + socio_id + File.separator;
        path_root_file = pathRoot + path_file + file.getOriginalFilename();

        System.out.println(pathRoot);

        if (diretorioFoiCriado) {
            deleteFileIfExist();
            return writeFileServer(pathRoot, file);
        } else {
            return false;
        }
    }

    public boolean createDirectory(String pathRoot, int socio_id) {
        File directory = new File(pathRoot + DIRECTORY_DOCS + socio_id);
        if (!directory.exists()) {
            return directory.mkdirs();
        }else{
            return true;
        }
    }
    
    public boolean writeFileServer(String pathRoot, MultipartFile file){
        FileOutputStream fout = null;
        try{
            String name = file.getOriginalFilename();
            System.out.println(name);
            byte[] bytes = file.getBytes();
            fout = new FileOutputStream(pathRoot + path_file + name);
            fout.write(bytes);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            try {
                fout.flush();
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void deleteFileIfExist(){
        File file = new File(path_root_file);
        if(file.exists()){
            file.delete();
        }
    }
    
    public void deleteFile(String pathRoot, UploadFilesDoc uploadFile){
        File file = new File(pathRoot+uploadFile.getPath_file());
        file.delete();
    }

}