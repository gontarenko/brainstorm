package easy;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n) {
        if (n < 0) {
            return false;
        }
        int count = 0;
        while (true) {
            int number = n;
            int sum = 0;
            do {
                int tmp = number % 10;
                number /= 10;
                sum += tmp * tmp;
            } while (number / 10 > 0);
            if (sum == 1) {
                return true;
            } else {
                n = sum;
                count++;
            }
            if (count > 10) {
                return false;
            }
        }
    }
}
