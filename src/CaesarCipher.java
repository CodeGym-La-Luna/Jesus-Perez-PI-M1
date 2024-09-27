public class CaesarCipher {
    private char[] alphabet;

    public CaesarCipher() {
        this.alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()_+-=[]{}|;:',.?/".toCharArray();
    }

    public String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        text = text.toUpperCase();

        for (char character : text.toCharArray()) {
            int index = findIndex(character);
            if (index != -1) {
                int newIndex = (index + shift) % alphabet.length;
                encryptedText.append(alphabet[newIndex]);
            } else {
                encryptedText.append(character);
            }
        }
        return encryptedText.toString();
    }

    public String decrypt(String encryptedText, int shift) {
        StringBuilder decryptedText = new StringBuilder();
        encryptedText = encryptedText.toUpperCase();

        for (char character : encryptedText.toCharArray()) {
            int index = findIndex(character);
            if (index != -1) {
                int newIndex = (index - shift + alphabet.length) % alphabet.length;
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
