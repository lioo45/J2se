package pratice.java第三次上机;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pro on 17/4/24.
 */
public class UseMap {
    public static void main(String[] args) {

        System.out.println(firstUniqueChar("loveleetcode"));
    }
    public static String firstUniqueChar(String s) {
        Map<Character, Integer> hash = new HashMap<Character, Integer>();
        char c[] = s.toCharArray();
        for (char cc : c) {
            Integer i = hash.get(cc);
            if (i == null)
                hash.put(cc, 1);
            else {
                ++i;
                hash.put(cc, i);
            }
        }
        for (int i = 0; i < c.length; i++) {
            if (hash.get(c[i]) < 2)
                return String.valueOf(c[i]);
        }

        return null;
    }
}
