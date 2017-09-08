package kibo;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ZipTest {

   private final String EXAMPLE_STRING = "example.txt";

   @Rule
   public TemporaryFolder folder = new TemporaryFolder();

   @Test
   public void TestCompressionAndDecompression() throws IOException{
      File tempFile = folder.newFile("example.txt");
      FileUtils.write(tempFile, "Hello, Compresion!" ,"US-ASCII");
      Zip.zipFile(tempFile);

      File zipFile = new File(folder.getRoot()+"/example.zip");
      assertThat(new File("example.zip").exists(), is(true));


      tempFile.delete();
      Zip.unzipFile(zipFile);
      assertThat(new File(folder.getRoot()+"/example.txt(1)").exists(), is(true));

   }




}
