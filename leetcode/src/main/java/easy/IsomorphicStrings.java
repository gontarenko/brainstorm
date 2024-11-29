package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) {
            return false;
        }

        Map<Integer, Integer> mappings = HashMap.newHashMap(sLen);
        Set<Integer> alreadyMapped = HashSet.newHashSet(sLen);

        for (int i = 0; i < sLen; i++) {
            int sChar = s.charAt(i);
            int tChar = t.charAt(i);
            Integer mapping = mappings.get(sChar);
            if (mapping == null) {
                if (alreadyMapped.contains(tChar)) {
                    return false;
                }
                mappings.put(sChar, tChar);
                alreadyMapped.add(tChar);
            } else {
                if (mapping != tChar) {
                    return false;
                }
            }
        }

        return true;
    }
}
