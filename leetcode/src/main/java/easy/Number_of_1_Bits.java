package easy;

public class Number_of_1_Bits {
    public static void main(String[] args) {

    }

    public int hammingWeight(int n) {
        return (int) Integer.toBinaryString(n).chars().filter(c -> c == '1').count();
    }

    public int hammingWeight2(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (char c : binaryString.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}
