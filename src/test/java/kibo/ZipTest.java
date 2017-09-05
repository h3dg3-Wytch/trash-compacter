package kibo;

import javafx.scene.shape.Path;
import org.junit.Test;

import java.io.File;

public class ZipTest {

   private final String EXAMPLE_STRING = "example.txt";
   @Test
   public void checkFileSize(){
      Zip.fileSize(EXAMPLE_STRING);
   }

   @Test
   public void testIfFileZips(){
      Zip.zipFile(EXAMPLE_STRING, ".");
      assert new File("example.zip").exists();
   }

   @Test
   public void testDecompression(){

      Zip.unzipFile("anotherexample.zip");
      assert new File("anotherexample.txt").exists();
   }

}
