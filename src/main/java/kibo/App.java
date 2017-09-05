package kibo;

import java.io.File;
import java.util.zip.GZIPOutputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if(args.length < 2){
            System.out.println("Please provide arguments!");
        }


    }

    public static void fileSize(String fileName){
        File file = new File(fileName);
        System.out.println(file.length()+ " bytes");
    }


}
