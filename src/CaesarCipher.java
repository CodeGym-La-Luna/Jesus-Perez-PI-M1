public class CaesarCipher {
    private char[] alphabet;

    public CaesarCipher() {
        this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()_+-=[]{}|;:',.?/".toCharArray();
    }

    public String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();
//se retiran la linea de codigo text = text-toUppercase(); para poder tener mas claridad y no exista la conversion de letras de mayusculas a minusculas cuando no se necesitan
        for (char character : text.toCharArray()) {
            int index = findIndex(character);
            if (index != -1) {
                int newIndex = (index + key) % alphabet.length;
                encryptedText.append(alphabet[newIndex]);
            } else {
                encryptedText.append(character);
            }
        }
        return encryptedText.toString();
    }
//tanto el cifrado como el descifrado se remplazo el shift a key para que se detecte la frase que fue cifrada
    public String decrypt(String encryptedText, int key) {
        StringBuilder decryptedText = new StringBuilder();
// se retira la misma linea de codigo que en el encriptado
        for (char character : encryptedText.toCharArray()) {
            int index = findIndex(character);
            if (index != -1) {
                int newIndex = (index - key + alphabet.length) % alphabet.length;
                decryptedText.append(alphabet[newIndex]);
            } else {
                decryptedText.append(character);
            }
        }
        return decryptedText.toString();
    }

    private int findIndex(char character) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == character) {
                return i;
            }
        }
        return -1;
    }

    public char[] getAlphabet() {
        return alphabet;
    }
}
