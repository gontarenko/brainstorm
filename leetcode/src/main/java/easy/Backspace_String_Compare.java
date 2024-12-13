package easy;

public class Backspace_String_Compare {

    public static void main(String[] args) {

        String s = "ab#c";
        String t = "ad#c";
        s = "ab##";
        t = "c#d#";

        System.out.println(backspaceCompare(s, t));
    }
    public static boolean backspaceCompare(String s, String t) {
        int sPointer = s.length() - 1;
        int tPointer = t.length() - 1;

        while (sPointer >= 0 || tPointer >= 0) {
            sPointer = nextLetterIndex(sPointer, s);
            tPointer = nextLetterIndex(tPointer, t);
            if (sPointer < 0 && tPointer < 0) {
                return true;
            }
            if (sPointer < 0 || tPointer < 0) {
                return false;
            }
            if (s.charAt(sPointer) != t.charAt(tPointer)) {
                return false;
            }
            sPointer--;
            tPointer--;
        }
        return true;
    }

    private static int nextLetterIndex(int i, String s) {
        int backspaceCount = 0;

        char c;
        while (i > -1 && (s.charAt(i) == '#' || backspaceCount != 0)) {
            c = s.charAt(i);
            if (c == '#') {
                backspaceCount++;
            } else {
                backspaceCount--;
            }
            i--;
        }
        return i;
    }

}
