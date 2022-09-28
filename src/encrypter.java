import java.util.LinkedList;
import java.util.*;
public interface encrypter {
    
    public static LinkedList<String> encrypt(LinkedList<String> order){
        LinkedList<String> result = new LinkedList<>();
        for (String string : order) {
            char[] ch = string.toCharArray();
            for (int i = 0; i < ch.length; i ++) {
             ch[i] = ch[i] += i + 2;
            }
            String Sencrypted = String.valueOf(ch);
            result.addLast(Sencrypted);
        }
        return result;
        
    }

    public static LinkedList<String> decrypt(LinkedList<String> order){
        LinkedList<String> result = new LinkedList<>();
        for (String string : order) {
            char[] ch = string.toCharArray();
            for (int i = 0; i < ch.length; i ++) {
             ch[i] = ch[i] -= i + 2;
            }
            String Decrypted = String.valueOf(ch);
            result.addLast(Decrypted);
        }
        return result;
        
    }
}
