package br.com.aocbmma.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;

public class ZipDirectory {

    private static String DIRECTORY_ZIP_FILE = "uploads/docs/zipfiles/";

    public byte[] getZipFile(String path_root, String nomeSocio) throws IOException {
        File zipFile = new File(path_root + DIRECTORY_ZIP_FILE + nomeSocio + ".zip");
        return FileUtils.readFileToByteArray(zipFile);
    }
    
    public void createZipDirectory(String path_root, int socio_id, String nomeSocio) throws IOException{
        createDirectoryZipFiles(path_root);
        String sourceFile = path_root + UploadFilesDocHelper.DIRECTORY_DOCS + socio_id;
        FileOutputStream fos = new FileOutputStream(path_root + DIRECTORY_ZIP_FILE + nomeSocio + ".zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        File fileToZip = new File(sourceFile);
    
        zipFile(fileToZip, nomeSocio, zipOut);
        zipOut.close();
        fos.close();
    }

    private void createDirectoryZipFiles(String path_root){
        File directory = new File(path_root + DIRECTORY_ZIP_FILE);
        if(!directory.exists()){
            directory.mkdirs();
        }
    }

    private void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if(fileToZip.isDirectory()){
            if(fileName.endsWith("/")){
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                zipOut.closeEntry();
            }

            File[] filesbyDirectory = fileToZip.listFiles();
            for(File file : filesbyDirectory){
                zipFile(file, fileName+"/"+file.getName(), zipOut);
            }
            return;
        }
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        fis.close();
    }

    public void deleteAllZipFiles(String path_root){
        File directory = new File(path_root + DIRECTORY_ZIP_FILE);
        File[] files = directory.listFiles();
        if(files!=null){
            for(File file : files){
                if(!file.isDirectory()){
                    file.delete();
                }
            }
        }
    }
}