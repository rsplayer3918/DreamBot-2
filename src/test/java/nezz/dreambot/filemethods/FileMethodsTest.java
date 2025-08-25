package nezz.dreambot.filemethods;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;

class FileMethodsTest {

    @Test
    void writeAndReadFileArray() throws IOException {
        Path tempDir = Files.createTempDirectory("scripts");
        System.setProperty("scripts.path", tempDir.toString() + File.separator);
        FileMethods fm = new FileMethods("TestScript");
        String[] data = {"line1", "line2", "line3"};
        fm.writeFile(data, "testfile");
        String[] read = fm.readFileArray("testfile");
        assertArrayEquals(data, read);
    }
}
