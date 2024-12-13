package easy;

public class Is_Subsequence {
    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        int sPointer = 0;
        char sChar = s.charAt(sPointer);
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == sChar) {
                sPointer++;
                if (sPointer == s.length()) {
                    return true;
                }
                sChar = s.charAt(sPointer);
            }
        }
        return false;
    }
}
