package kibo;

import javafx.scene.shape.Path;
import org.junit.Test;

import java.io.File;

public class ZipTest {

   private final String EXAMPLE_STRING = "example.txt";
   @Test
   public void checkFileSize(){
      System.out.println((Zip.fileSize(EXAMPLE_STRING)));
   }

   @Test
   public void testIfFileZips(){

      if(new File(EXAMPLE_STRING).exists()) {
         Zip.zipFile(EXAMPLE_STRING, ".");
         assert new File("example.zip").exists();
      }
   }

   @Test
   public void testDecompression(){
      if(new File("anotherexample.zip").exists()) {
         Zip.unzipFile("anotherexample.zip");
         assert new File("example.txt").exists();
      }
   }

}
