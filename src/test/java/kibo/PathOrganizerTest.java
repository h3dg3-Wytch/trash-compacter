package kibo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class PathOrganizerTest {

    private PathOrganizer service;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setup(){

        service = new PathOrganizer();

    }

    @Test
    public void CheckIfItIsAFolder() throws IOException{
        File tempFolder = folder.newFolder("temp");
        assertThat(service.isFolder(tempFolder), is(true));
    }
    @Test
    public void ReturnFalseIfItIsAFile() throws IOException{
        File tempFile = folder.newFile("temp.txt");
        assertThat(service.isFolder(tempFile), is(false));
    }
    @Test
    public void ReturnJustFileBeforeExentension(){
        assertEquals(service.cleanPath("example.txt"),"example");
    }
}
