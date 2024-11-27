import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Clase que permite la lectura y escritura de archivos.
 * Permite cifrar y descifrar archivos utilizando el metodo César.
 *
 * @author Jesús Pérez Noriega.
 * @version 1.0
 */
public class FileManager {
    private CaesarCipher cipher;

    public FileManager() {
        this.cipher = new CaesarCipher();
    }

    /**
     * Lee el contenido de un archivo.
     * @param filePath Ruta del archivo.
     * @return Contenido del archivo como String, o null si ocure un error.
     */
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

    /**
     * Escribe contenido en un archivo.
     * @param content Contenido a guardar.
     * @param filePath Ruta del archivo.
     * @param append Si es true, se añade contenido al archivo existente.
     */
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

    /**
     * Lee un archivo, lo cifra y guarda el contenido cifrado en un nuevo archivo.
     * @param inputFilePath Ruta del archivo a cifrar.
     * @param outputFilePath Ruta del archivo donde se guardará el cifrado.
     * @param key Clave de cifrado.
     */
    public void encryptFile(String inputFilePath, String outputFilePath, int key) {
        String content = readFile(inputFilePath);
        if (content != null) {
            String enryptedContent = cipher.encrypt(content, key);
            writeFile(enryptedContent, outputFilePath, false);
        }
    }

    /**
     * Lee iun archivo cifrado, lo descifra y guarda el contenido descifrado en un nuevo archivo.
     * @param inputFilePath Ruta del archivo cifrado.
     * @param outputFilePath Ruta del archivo donde se guardará el contenido descifrado.
     * @param key Clave de descifrado.
     */
    public void decryptFile(String inputFilePath, String outputFilePath, int key) {
        String content = readFile(inputFilePath);
        if (content != null) {
            String decryptedContent = cipher.decrypt(content, key);
            writeFile(decryptedContent, outputFilePath, false);
        }
    }
}
