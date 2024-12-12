package easy;

public class Valid_Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j;) {
            char first = s.charAt(i);
            if (!Character.isLetter(first)) {
                i++;
                continue;
            }
            char second = s.charAt(j);
            if (!Character.isLetter(second)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(first) != Character.toLowerCase(second)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
