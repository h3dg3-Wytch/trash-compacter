package kibo;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @org.junit.Test
    public void TestNoParameters(){
        String[] params = {};
        App.main(params);
        assertEquals("Please provide arguments! You can either enter a filename, or a directory!\n",outContent.toString());
    }

    @org.junit.Test
    public void TestTooLargeParamaters(){
     App.main(new String[]{"temp.txt","temp.txt"});
     assertEquals("Please provide either a file name or directory name!\n", outContent.toString());
    }

    @org.junit.Test
    public void TestThatItWillConvertIntoZip()throws IOException{
        File tempFile = folder.newFile("example.txt");
        FileUtils.write(tempFile, "Hello, Compression", "US-ASCII");
        App.main(new String[]{tempFile.toString()});
        assertThat(new File(folder.getRoot() + "/example.zip").exists(),is(true));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }


}
