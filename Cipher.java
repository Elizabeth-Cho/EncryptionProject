import java.util.HashMap;
/**
 * The cipher class that creates a shift cipher based on a key.
*/
public class Cipher implements CipherInterface {
    /**
     * The number of characters in the alphabet.
     */
    private static final int NUM_ALPHABET = 26;
    /**
     * The key.
     */
    private KeyInterface key;
    /**
     * The hashmap used for decrypting.
     */
    private HashMap<Character, Character> dCipher;
    /**
     * The hashmap used for encrypting.
     */
    private HashMap<Character, Character> eCipher;

    /**
     * The constructor for a cipher.
     * @param kKey the key to use for the cipher.
     * @throws InvalidFormatException key uses characters not in alphabet 
    */
    public Cipher(KeyInterface kKey) throws InvalidFormatException {
        this.key = kKey;
        this.dCipher = new HashMap<Character, Character>();
        this.eCipher = new HashMap<Character, Character>();
        try {
            this.createCipher();
        } catch (InvalidFormatException e) {
            throw new InvalidFormatException("Cipher");
        }
    }

    @Override
    public void setKey(KeyInterface nKey) throws InvalidFormatException {
        this.key = nKey;
        try {
            this.createCipher();
        } catch (InvalidFormatException e) {
            throw new InvalidFormatException("Cipher");
        }
    }

    @Override
   public char getConversion(char c, boolean encrypt) 
        throws InvalidFormatException {
        try {
            if (encrypt) {
                return this.eCipher.get(Character.valueOf(c));
            } else {
                return this.dCipher.get(Character.valueOf(c));
            }
        } catch (NullPointerException e) {
            throw new InvalidFormatException("Cipher");
        }
    }

    /**
     * Create the cipher based on the key.
     * @throws InvalidFormatException key uses characters not in alphabet
    */
    private void createCipher() throws InvalidFormatException {
        try {
            for (int i = 0; i < this.getKeyCipher().length(); i++) {
                this.eCipher.put(Character.valueOf((
                     this.getAlphabetString().charAt(i))),
                     Character.valueOf(this.getKeyCipher().charAt(i)));
                this.dCipher.put(Character.valueOf(
                     this.getKeyCipher().charAt(i)),
                     Character.valueOf(this.getAlphabetString().charAt(i)));
            }
        } catch (InvalidFormatException e) {
            throw new InvalidFormatException("Cipher");
        }
    }

    /**
     * Get the alphabet used for the key.
     * @return the alphabet used for the key.
     */
    private AlphabetInterface getAlphabet() {
        return this.key.getAlphabet();
    }

    /**
     * Get the string version of the alphabet.
     * @return the string version of the alphabet.
     */
    private String getAlphabetString() {
        return this.getAlphabet().toString();
    }

    /**
     * Get the string version of the key.
     * @return the string version of the key.
     */
    private String getKeyString() {
        return this.key.toString();
    }

    /**
     * Get the string version of the cipher with the key.
     * @return the string version of the cipher
     * @throws InvalidFormatException key uses characters not in alphabet
     */
    private String getKeyCipher() throws InvalidFormatException {
        try {
            Key kCipher = new Key(this.getKeyString()
                + this.getAlphabetString(), this.getAlphabet());
            return kCipher.toString();
        } catch (InvalidFormatException e) {
            throw new InvalidFormatException("Cipher");
        }
    }
}
