public class CaesarCipher {
    private char[] alphabet;

    /**
     * Clase que implementa el cifrado y descifrado utilizando el método César.
     * Permite trabajar con alfabetos extendidos para tener un mayor rango de caracteres.
     *
     * @author Jesús Pérez Noriega.
     * @version 1.0
     */
    public CaesarCipher() {
        this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()_+-=[]{}|;:',.?/".toCharArray();
    }

    /**
     * Metodo para cifrar textos utilizando el cifrado César.
     * @param text Texto Original a cifrar.
     * @param key numero de desplazamiento (clave)
     * @return Texto cifrado.
     */

    public String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();

        for (char character : text.toCharArray()) {
            int index = findIndex(character); //Buscar indice del caracter en el alfabeto
            if (index != -1) {
                // Se Calcula nuevo indice despues del desplazamiento inverso
                int newIndex = (index + key) % alphabet.length;
                encryptedText.append(alphabet[newIndex]);
            } else {
                encryptedText.append(character);
            }
        }
        return encryptedText.toString();
    }

    /**
     * Metodo para descifrar texto cifrado utilizando el cifrado César.
     * @param encryptedText Texto Cifrado.
     * @param key Numero de desplazamiento utilizado para cifrar.
     * @return Texto original descifrado.
     */

    public String decrypt(String encryptedText, int key) {
        StringBuilder decryptedText = new StringBuilder();

        for (char character : encryptedText.toCharArray()) {
            int index = findIndex(character); // Buscar indice del caracter en el alfabeto
            if (index != -1) {
                // Se calcula nuevo indice despues del desplazamiento inverso
                int newIndex = (index - key + alphabet.length) % alphabet.length;
                decryptedText.append(alphabet[newIndex]); // Se añade caracter descifrado
            } else {
                decryptedText.append(character);
            }
        }
        return decryptedText.toString();
    }

    /**
     * Metodo auxiliar para buscar el indice de un caracter en el alfabeto.
     * @param character Carácter a buscar.
     * @return índice del caracter, o -1 si no se encuentra en el alfabeto.
     */

    private int findIndex(char character) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == character) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Obtener el alfabeto usado por el cifrado.
     * @return Array de caracteres del alfabeto.
     */
    public char[] getAlphabet() {
        return alphabet;
    }
}
