package easy;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 7, 9, 10};

        int target = 4;

        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;


        int previousL = left, previousR = right;
        while (left <= right) {
            mid = (right + left) / 2;
            int value = nums[mid];

            if (value < target) {
                previousL = left;
                left = mid + 1;
            } else if (value > target) {
                previousR = right;
                right = mid - 1;
            } else {
                return mid;
            }
        }
        for (int i = previousR; i >= previousL; i--) {
            if (nums[i] < target) {
                return i + 1;
            }
        }
        return 0;
    }
}
