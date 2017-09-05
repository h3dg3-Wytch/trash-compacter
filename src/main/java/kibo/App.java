package kibo;

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
            System.out.println("Please provide arguments!");
            return;
        }

        for(String fileName : args){
            Zip.zipFile(fileName, ".");
            Zip.unzipFile(fileName+".zip");
        }

    }



}
