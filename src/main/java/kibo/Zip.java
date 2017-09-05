package kibo;

import java.io.*;
import java.nio.Buffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zip {

    private static final byte[] BUFFER = new byte[1024];

    public static void fileSize(String fileName){
        File file = new File(fileName);
        System.out.println(file.length()+ " bytes");
    }

    public static void unzipFile(String fileName){

        try{
            ZipInputStream inputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            BufferedOutputStream destination = new BufferedOutputStream(new FileOutputStream("anotherexample.txt"));

            ZipEntry zipEntry = inputStream.getNextEntry();

            while (zipEntry != null){

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
            System.out.println("Error, something happened!");
        }
    }


    public static void zipFile(String fileName, String filePath){
        FileOutputStream destination = null;
        ZipOutputStream zipOutputStream = null;
        FileInputStream origin = null;
        try{
            destination = new FileOutputStream("example.zip");
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(destination));
            ZipEntry zipEntry = new ZipEntry(fileName);
            zipOutputStream.putNextEntry(zipEntry);
            origin = new FileInputStream(fileName);

            int length;
            while((length = origin.read(BUFFER)) > 0){
                zipOutputStream.write(BUFFER, 0, length);
            }
            //Closing
            zipOutputStream.close();
            origin.close();
        }catch(FileNotFoundException e){
            System.out.println("Please enter a valid file name!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
