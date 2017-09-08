package kibo;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class ZipTest {

   private final String EXAMPLE_STRING = "example.txt";


   @Rule
   public TemporaryFolder folder = new TemporaryFolder();
   @Rule
   public ExpectedException thrown = ExpectedException.none();

   @Test(expected = IOException.class)
   public void TestThatItCatchesInvalidFile() throws IOException{
      Zip.zipFile(new File("badfile.file"));
   }
   @Test
   public void TestCompressionAndDecompression() throws IOException{
      File tempFile = folder.newFile("example.txt");
      FileUtils.write(tempFile, "Hello, Compresion!" ,"US-ASCII");
      Zip.zipFile(tempFile);

      File zipFile = new File(folder.getRoot()+"/example.zip");
      assertThat(new File(folder.getRoot()+"/example.zip").exists(), is(true));


      tempFile.delete();
      Zip.unzipFile(zipFile);
      assertThat(new File(folder.getRoot()+"/example.txt(1)").exists(), is(true));

   }

}
