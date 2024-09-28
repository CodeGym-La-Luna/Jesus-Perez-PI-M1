import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CaesarCipher cipher = new CaesarCipher();
        FileManager fileManager = new FileManager();
        Validator validator = new Validator();

        while (true) {
            // Mostrar menú al usuario
            System.out.println("Bienvenido al Cifrador César");
            System.out.println("1. Cifrar un mensaje desde consola");
            System.out.println("2. Descifrar un mensaje desde consola");
            System.out.println("3. Cifrar un archivo .txt");
            System.out.println("4. Descifrar un archivo .txt");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Introduce el texto a cifrar: ");
                    String textoCifrar = scanner.nextLine();
                    System.out.print("Introduce el número de desplazamiento: ");
                    int desplazamientoCifrar = scanner.nextInt();
                    scanner.nextLine();

                    if (validator.isValidKey(desplazamientoCifrar, cipher.getAlphabet())) {
                        System.out.println("Texto cifrado: " + cipher.encrypt(textoCifrar, desplazamientoCifrar));
                    } else {
                        System.out.println("Clave de desplazamiento no válida.");
                    }
                    break;

                case "2":
                    System.out.print("Introduce el texto a descifrar: ");
                    String textoDescifrar = scanner.nextLine();
                    System.out.print("Introduce el número de desplazamiento: ");
                    int desplazamientoDescifrar = scanner.nextInt();
                    scanner.nextLine();

                    if (validator.isValidKey(desplazamientoDescifrar, cipher.getAlphabet())) {
                        System.out.println("Texto descifrado: " + cipher.decrypt(textoDescifrar, desplazamientoDescifrar));
                    } else {
                        System.out.println("Clave de desplazamiento no válida.");
                    }
                    break;

                case "3":
                    System.out.print("Introduce la ruta del archivo a cifrar: ");
                    String filePathCifrar = scanner.nextLine();

                    if (validator.isFileExists(filePathCifrar)) {
                        System.out.print("Introduce el número de desplazamiento: ");
                        int desplazamientoArchivoCifrar = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea

                        if (validator.isValidKey(desplazamientoArchivoCifrar, cipher.getAlphabet())) {
                            String fileContent = fileManager.readFile(filePathCifrar);
                            String encryptedContent = cipher.encrypt(fileContent, desplazamientoArchivoCifrar);
                            fileManager.writeFile(encryptedContent, filePathCifrar.replace(".txt", "_cifrado.txt"), false);
                        } else {
                            System.out.println("Clave de desplazamiento no válida.");
                        }
                    } else {
                        System.out.println("El archivo no existe.");
                    }
                    break;
                //C:\Users\yizuz\Downloads\Ayuda y Proyecto Git\P-CG-M1-JP\src\El programa que jamas corrio
                case "4":
                    System.out.print("Introduce la ruta del archivo a descifrar: ");
                    String filePathDescifrar = scanner.nextLine();

                    if (validator.isFileExists(filePathDescifrar)) {
                        System.out.print("Introduce el número de desplazamiento: ");
                        int desplazamientoArchivoDescifrar = scanner.nextInt();
                        scanner.nextLine();

                        if (validator.isValidKey(desplazamientoArchivoDescifrar, cipher.getAlphabet())) {
                            String fileContent = fileManager.readFile(filePathDescifrar);
                            String decryptedContent = cipher.decrypt(fileContent, desplazamientoArchivoDescifrar);
                            fileManager.writeFile(decryptedContent, filePathDescifrar.replace(".txt", "_descifrado.txt"), false);
                        } else {
                            System.out.println("Clave de desplazamiento no válida.");
                        }
                    } else {
                        System.out.println("El archivo no existe.");
                    }
                    break;

                case "5":
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }
    }
}