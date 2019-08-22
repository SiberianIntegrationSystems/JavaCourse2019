package pro.it.sis.javacourse.homework03;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import static java.nio.file.Files.copy;

public class FileService {

	public static Path getTempFolderPath() {
		return Paths.get("C:", "temp");
	}

	public static File copyStream(InputStream stream) {
		Path tempFilePath = getTempFolderPath().resolve(UUID.randomUUID().toString());
		File targetFile = new File(tempFilePath.toString());

		try {
			copy(stream, tempFilePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new RuntimeException(e.getLocalizedMessage());
		}

		return targetFile;
	}
}
