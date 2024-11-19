package easy;

public class LengthOfLastWord {
    public static void main(String[] args) {

    }

    public int lengthOfLastWord(String s) {
        int result = 0;
        boolean word = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                result++;
                word = true;
            } else {
                if (word) {
                    break;
                }
            }
        }
        return result;
    }
}
