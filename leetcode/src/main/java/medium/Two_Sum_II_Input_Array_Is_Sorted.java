package medium;

public class Two_Sum_II_Input_Array_Is_Sorted {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[] {5,25,75}, 100));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = 1;
        while (p1 < p2 && p2 < numbers.length) {
            int sum = numbers[p1] + numbers[p2];
            if (sum < target) {
                p2++;
            } else if (sum > target) {
                p1++;
            } else {
                return new int[]{p1 + 1, p2 + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
