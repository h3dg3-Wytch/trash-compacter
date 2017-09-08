package kibo;

import java.io.File;

public class PathOrganizer {
    public static boolean isFolder(File tempFolder) {
        return tempFolder.isDirectory();
    }

    public static String cleanPath(String fileName){
        String result =  fileName.substring(0, fileName.indexOf("."));
        return result;
    }



}
