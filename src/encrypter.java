import java.util.LinkedList;
import java.util.*;
public interface encrypter {
    
    public static LinkedList encrypt(LinkedList<String> order){
        LinkedList result = new LinkedList<>();
        for (String string : order) {
            char[] ch = string.toCharArray();
            char[] encrypted = new char[string.length()];
            for (int i = 0; i < ch.length; i ++) {
             ch[i] = ch[i] += i + 2;
            }
            String Sencrypted = ch.toString();
            result.addLast(Sencrypted);
        }
        return result;
        
    }

    public static LinkedList decrypt(LinkedList<String> order){
        LinkedList result = new LinkedList<>();
        for (String string : order) {
            char[] ch = string.toCharArray();
            char[] encrypted = new char[string.length()];
            for (int i = 0; i < ch.length; i ++) {
             ch[i] = ch[i] -= i + 2;
            }
            String Decrypted = ch.toString();
            result.addLast(Decrypted);
        }
        return result;
        
    }
}
