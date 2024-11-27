import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Clase que realiza las validaciones generales para el programa.
 * Verifica claves de cifrado y existencia de archivos.
 *
 * @author Jesús Pérez Noriega.
 * @version 1.0
 */
public class Validator {
    /**
     * Verifica si una clave de desplazamiento es válida según el alfabeto proporcionado
     * @param key Clave de desplazamiento.
     * @param alphabet Alfabeto utilizado para el cifrado.
     * @preturn true si la clave es válida, false en caso contrario.
     */
    public boolean isValidkey(int key, char[] alphabet) {
        if (key < 0 || key >= alphabet.length) {
            System.out.println("Clave no valida: debe estar entre 0 y " + (alphabet.length - 1));
            return false;
        }
        return true;
    }

    /**
     * Verifica si un archivo existe en la ruta especificada.
     * @param filePath Ruta del archivo.
     * @return true si el archivo existe, false en caso contrario.
     */
    public boolean isFileExists(String filePath) {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            System.out.println("El archivo no existe: " + filePath);
            return false;
        }
        return true;
    }

    /**
     * Verifica si un archivo es de tipo `.txt`.
     * @param filePath Ruta del archivo.
     * @return true si el archivo es de tipo `.txt`., false en caso contrario.
     */
    public boolean isTxtFile(String filePath) {
        if (!filePath.toLowerCase().endsWith(".txt")) {
            System.out.println("El archivo no tiene una extensión válida (.txt): " + filePath);
            return false;
        }
        return true;
    }

    /**
     * Valida si un archivo existe y tiene la extensión correcta.
     * @param filePath Ruta del archivo.
     * @return true si el archivo existe y es de tipo `.txt`, false en caso contrario.
     */
    public boolean isValidTxtFile(String filePath) {
        return isFileExists(filePath) && isTxtFile(filePath);
    }
}
