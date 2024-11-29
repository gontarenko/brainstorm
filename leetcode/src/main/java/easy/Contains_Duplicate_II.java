package easy;

import java.util.HashSet;

public class Contains_Duplicate_II {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{2,2}, 3));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = HashSet.newHashSet(k + 1);
        int index = 0; // last removed index
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (set.size() > k) {
                set.remove(nums[index++]);
            }
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static boolean containsNearbyDuplicateDummy(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int j = i + 1;
            while (Math.abs(i - j) <= k && j < nums.length) {
                if (num == nums[j]) {
                    return true;
                }
                j++;
            }

        }
        return false;
    }
}

