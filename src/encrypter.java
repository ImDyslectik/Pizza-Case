import java.util.LinkedList;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public interface encrypter {
    final String ALGORITHM = "AES";
    final String secretKey = "Dyslecthick";

    /**
     * makes a key for encryption of data from a given seed
     * @param myKey the seed for the creation of key
     * @return the encrytion key
     */

    public static SecretKeySpec prepareSecreteKey(String seed) {
        byte[] key;
        MessageDigest sha = null;
        try {
            key = seed.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
            return secretKey;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * encrypts a list of strings
     * @param order list of strings to encrypt
     * @return encrypted list of strings
     */
    public static LinkedList<String> encryptList(LinkedList<String> order) {
        LinkedList<String> result = new LinkedList<>();
        for (String string : order) {
            String Sencrypted = encrypt(string, secretKey);
            result.addLast(Sencrypted);
        }
        return result;
    }

    /**
     * encrypts a single string
     * @param strToEncrypt string that needs to be encrypted
     * @param secret seed for the creation of encrytion key
     * @return encrypted string
     */
    public static String encrypt(String strToEncrypt, String secret) {
        try {
            SecretKeySpec secretKey = prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    /**
     * decrypts a list of strings
     * @param order list of strings that need to be decrypted
     * @return decrypted list of strings
     */
    public static LinkedList<String> decryptList(LinkedList<String> order) {
        LinkedList<String> result = new LinkedList<>();
        for (String string : order) {
            String Decrypted = decrypt(string, secretKey);
            result.addLast(Decrypted);
        }
        return result;
    }

    /**
     *decrypts a single string with a given seed 
     * @param strToDecrypt string that needs to be decrypted
     * @param secret seed used for creating the decryption key
     * @return decrypted string
     */
    public static String decrypt(String strToDecrypt, String secret) {
        try {
            SecretKeySpec secretKey = prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
