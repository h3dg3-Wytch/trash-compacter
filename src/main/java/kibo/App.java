package kibo;

import javafx.scene.shape.Path;

import java.io.File;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if(args.length < 1){
            System.out.println("Please provide arguments! You can either enter a filename, or a directory!");
            return;
        }
        if(args.length > 1){
            System.out.println("Please provide either a file name or directory name!");
            return;
        }


        PathOrganizer pathOrganizer = new PathOrganizer();
        File targetFile = new File(args[0]);
        if(!pathOrganizer.isFolder(targetFile)) {
            zipAndUnZipFile(targetFile);
        }else{
            for(File file : targetFile.listFiles()){
               zipAndUnZipFile(file);
            }
        }

    }

    public static void zipAndUnZipFile(File targetFile){
        Zip.zipFile(targetFile);

        String cleanPath = PathOrganizer.cleanPath(targetFile.toString()) + ".zip";
    }





}
