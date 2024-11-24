package easy;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length -1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                break;
            }
        }
        if (digits[0] == 0) {
            int[] result = new int[digits.length +1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
            return result;
        }
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length -1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
