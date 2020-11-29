package core.microservice.fuelefficiency.utils;

import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

@Component
public class FileUtilsImpl implements FileUtils {

    @Override
    public byte[] readStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[16384];

        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        return buffer.toByteArray();
    }

    @Override
    public void deleteFile(Path path) {
        if (fileExists(path)) {
            File file = path.toFile();
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Override
    public boolean fileExists(Path path) {
        if (path != null && path.toFile() != null) {
            return true;
        }
        return false;
    }

}
