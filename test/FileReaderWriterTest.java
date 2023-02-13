package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FileReaderWriterTest {

    private FileReadWrite fileRW;
    private Path testFilePath;

    @Before
    public void setUp() throws Exception {
        fileRW = new FileReadWrite();
        testFilePath = Paths.get("input file.txt");
    }

    @After
    public void tearDown() throws Exception {
        Files.deleteIfExists(testFilePath);
    }

    @Test
    public void testSaveAndRead() throws IOException {
        String content = "This is some test content";
        fileRW.save(testFilePath);

        String result = fileRW.load(testFilePath);

        assertEquals(content, result);
    }

    @Test
    public void testReadFromNonExistentFile() {
        Path nonExistentFilePath = Paths.get("non_existent.txt");

        fileRW.save(nonExistentFilePath);
        fail("Expected IOException not thrown");
    }

    private class FileReadWrite {
        public void save(Path testFilePath) {
        }

        public String load(Path testFilePath) {
            return null;
        }
    }
}

