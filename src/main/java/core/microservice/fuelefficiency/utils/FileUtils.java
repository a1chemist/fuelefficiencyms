package core.microservice.fuelefficiency.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public interface FileUtils {
    byte[] readStream(InputStream inputStream) throws IOException;

    void deleteFile(Path path);

    boolean fileExists(Path path);
}
