package easy;

public class Merge_Sorted_Array {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[] {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        Double.NEGATIVE_INFINITY
        int i1 = m - 1;
        int i2 = n - 1;
        int pointer = nums1.length - 1;

        while (i1 >= 0 && i2 >= 0) {
            int num1 = nums1[i1];
            int num2 = nums2[i2];
            if (num2 > num1) {
                nums1[pointer--] = num2;
                i2--;
            } else {
                nums1[pointer--] = num1;
                i1--;
            }
        }

        while (i2 >= 0) {
            nums1[pointer--] = nums2[i2];
            i2--;
        }
    }
}
