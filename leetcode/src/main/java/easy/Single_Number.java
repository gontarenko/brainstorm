package easy;

import java.util.HashSet;
import java.util.Set;

public class Single_Number {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.iterator().next();
    }
}
