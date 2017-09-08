package kibo;

import javafx.scene.shape.Path;

import java.io.*;
import java.nio.Buffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zip {
    private static final byte[] BUFFER = new byte[1024];

    public static String fileSize(String fileName){
        File file = new File(fileName);
        return file.length() + " bytes.";
    }

    public static void unzipFile(File file){
        System.out.println("---------------------------------");
        System.out.println("Size of unzipped file : " + Zip.fileSize(file.toString()));
        System.out.println("Starting decompression of " + file.toString() + "...");
        long startTime = System.currentTimeMillis();

        try{
            ZipInputStream inputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)));
            BufferedOutputStream destination = null;

            ZipEntry zipEntry = inputStream.getNextEntry();

            while (zipEntry != null){

                destination = new BufferedOutputStream(new FileOutputStream(zipEntry.getName() + "(1)"));

                int length;
                while((length = inputStream.read(BUFFER)) > 0){
                    destination.write(BUFFER, 0, length);
                }

                zipEntry = inputStream.getNextEntry();

            }
            inputStream.close();
            if(destination != null){
                destination.close();
            }
        }catch(Exception e){
            System.out.println("ERROR: Please enter a valid file!");
        }

        long endTime = System.currentTimeMillis();
        long totalTime = (endTime - startTime) /1000;

        System.out.println("Decompressed, took " + totalTime + " seconds.");
    }


    public static void zipFile(File file){
        System.out.println("---------------------------------");
        System.out.println("Size of zipped file : " + Zip.fileSize(file.toString()));
        System.out.println("Starting compression of " + file.toString() + "...");

        long startTime = System.currentTimeMillis();

        try{

            FileOutputStream fos = new FileOutputStream(PathOrganizer.cleanPath(file.toString()) + ".zip");
            ZipOutputStream zos = new ZipOutputStream(fos);
            ZipEntry ze= new ZipEntry(file.toString());
            zos.putNextEntry(ze);
            FileInputStream in = new FileInputStream(file);

            int len;
            while ((len = in.read(BUFFER)) > 0) {
                zos.write(BUFFER, 0, len);
            }

            in.close();
            zos.closeEntry();

            zos.close();

        }catch(IOException ex){
            System.out.println("ERROR: Please enter a valid file!");
        }


        long endTime = System.currentTimeMillis();
        long totalTime = (endTime - startTime) / 1000;

        System.out.println("Compressed, took " + totalTime + " seconds.");}
}
