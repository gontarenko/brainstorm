package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T_3Sum {
    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int first = nums[i];
                    int sec = nums[j];
                    int third = nums[k];
                    if (first + sec + third == 0) {
                        List<Integer> pointers = new ArrayList<>();//HashSet.newHashSet(3);
                        pointers.add(first);
                        pointers.add(sec);
                        pointers.add(third);
                        if (res.stream().noneMatch(r -> r.containsAll(pointers))) {
                            res.add(pointers);
                        }
                    }
                }
            }
        }
        return res;
    }
}
