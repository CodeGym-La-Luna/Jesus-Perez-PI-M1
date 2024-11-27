import java.security.Key;
import java.util.Scanner;

/**
 * Clase Principal que ejecuta el programa Cifrado César.
 * Proporciona un menú para cifrar y descifrar texto desde consola o archivos .txt.
 * @author Jesús Pérez Noriega.
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CaesarCipher cipher = new CaesarCipher();
        FileManager fileManager = new FileManager();
        Validator validator = new Validator();

        while (true) {
            // Mostrar menú al usuario
            System.out.println("\nBienvenido al Cifrador César");
            System.out.println("1. Cifrar un mensaje desde consola");
            System.out.println("2. Descifrar un mensaje desde consola");
            System.out.println("3. Cifrar un archivo .txt");
            System.out.println("4. Descifrar un archivo .txt");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            String opcion = scanner.nextLine();
            // revisar saltos de linea
            switch (opcion) {
                case "1":
                    System.out.print("\nIntroduce el texto a cifrar: ");
                    String textoCifrar = scanner.nextLine();
                    System.out.print("Introduce el número de desplazamiento: ");
                    int desplazamientoCifrar = scanner.nextInt();
                    scanner.nextLine();

                    if (validator.isValidkey(desplazamientoCifrar, cipher.getAlphabet())) {
                        System.out.println("Texto cifrado: " + cipher.encrypt(textoCifrar, desplazamientoCifrar));
                    } else {
                        System.out.println("Clave de desplazamiento no válida.");
                    }
                    break;

                case "2":
                    System.out.print("\nIntroduce el texto a descifrar: ");
                    String textoDescifrar = scanner.nextLine();
                    System.out.print("Introduce el número de desplazamiento: ");
                    int desplazamientoDescifrar = scanner.nextInt();
                    scanner.nextLine();

                    if (validator.isValidkey(desplazamientoDescifrar, cipher.getAlphabet())) {
                        System.out.println("Texto descifrado: " + cipher.decrypt(textoDescifrar, desplazamientoDescifrar));
                    } else {
                        System.out.println("Clave de desplazamiento no válida.");
                    }
                    break;

                case "3":
                    System.out.print("\nIntroduce la ruta del archivo a cifrar: ");
                    String filePathCifrar = scanner.nextLine();
                    if (validator.isValidTxtFile(filePathCifrar)) {
                        System.out.println("Introduce la ruta para guardar el archivo cifrado: ");
                        String outputPathCifrar = scanner.nextLine();
                        System.out.println("Introduce el número de desplazamiento: ");
                        int keyCifrar = scanner.nextInt();
                        scanner.nextLine();

                        if (validator.isValidkey(keyCifrar, cipher.getAlphabet())) {
                            fileManager.encryptFile(filePathCifrar, outputPathCifrar, keyCifrar);
                        }
                    }
                    break;

                case "4":
                    System.out.print("\nIntroduce la ruta del archivo a descifrar: ");
                    String filePathDescifrar = scanner.nextLine();
                    if (validator.isValidTxtFile(filePathDescifrar)) {
                        System.out.println("Introduce la ruta para guardar el archivo descifrado: ");
                        String outputPathDescifrar = scanner.nextLine();
                        System.out.println("Introduce el número de desplazamiento: ");
                        int keyDescifrar = scanner.nextInt();
                        scanner.nextLine();

                        if (validator.isValidkey(keyDescifrar, cipher.getAlphabet())) {
                            fileManager.decryptFile(filePathDescifrar, outputPathDescifrar, keyDescifrar);
                        }
                    }
                    break;

                case "5":
                    System.out.println("\nSaliendo del programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }
    }
}