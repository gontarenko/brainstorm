package easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public int majorityElementDummy(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = nums[i];
            int v = map.getOrDefault(key, 0);
            map.put(key, v + 1);
        }
        for (var e : map.entrySet()) {
            if (e.getValue() > (n / 2)) {
                return e.getKey();
            }
        }
        return -1;
    }
}
