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

    public void uploadFileServer(String pathRoot, MultipartFile file, int socio_id) throws IOException {
        path_file = DIRECTORY_DOCS + socio_id + File.separator;
        path_root_file = pathRoot + path_file + file.getOriginalFilename();

        createDirectory(pathRoot, socio_id);
        deleteFileIfExist();
        writeFileServer(pathRoot, file);
    }

    public void createDirectory(String pathRoot, int socio_id) throws IOException{
        File directory = new File(pathRoot + DIRECTORY_DOCS + socio_id);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public void writeFileServer(String pathRoot, MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();
        byte[] bytes = file.getBytes();
        FileOutputStream fout = new FileOutputStream(pathRoot + path_file + name);
        fout.write(bytes);
        fout.flush();
        fout.close();
    }

    public void deleteFileIfExist() throws IOException{
        File file = new File(path_root_file);
        if (file.exists()) {
            file.delete();
        }
    }

    public void deleteFile(String pathRoot, UploadFilesDoc uploadFile) throws IOException{
        File file = new File(pathRoot + uploadFile.getPath_file());
        file.delete();
    }

}