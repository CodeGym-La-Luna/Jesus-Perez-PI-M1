import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileManager {

    public String readFile(String filePath) {
        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            System.out.println("El archivo no existe: " + filePath);
            return null;
        }

        try {
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }

    public void writeFile(String content, String filePath, boolean append) {
        Path path = Paths.get(filePath);

        try {
            if (Files.notExists(path.getParent())) {
                Files.createDirectories(path.getParent());
                System.out.println("Directorio creado: " + path.getParent());
            }

            if (append) {
                Files.write(path, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } else {
                Files.write(path, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            }

            System.out.println("Archivo guardado correctamente en: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
