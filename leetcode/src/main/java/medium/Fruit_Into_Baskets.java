package medium;

import java.util.HashMap;
import java.util.Map;

public class Fruit_Into_Baskets {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }

    public static int totalFruit(int[] fruits) {
        int begin = 0;
        Map<Integer, Integer> state = HashMap.newHashMap(3);
        int result = 0;
        for (int i = 0; i < fruits.length; i++) {
            int fruit = fruits[i];
            int count = state.getOrDefault(fruit, 0);
            state.put(fruit, count + 1);

            while (state.size() > 2) {
                int key = fruits[begin];
                count = state.get(key);
                if (count == 1) {
                    state.remove(key);
                } else {
                    state.put(key, count - 1);
                }
                begin++;
            }

            result = Math.max(result, i - begin + 1);
        }
        return result;
    }
}
