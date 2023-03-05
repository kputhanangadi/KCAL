package src.test;

import org.junit.After;
import org.junit.Before;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    private class FileReadWrite {
        public void save(Path testFilePath) {
        }

        public String load(Path testFilePath) {
            return null;
        }
    }
}

