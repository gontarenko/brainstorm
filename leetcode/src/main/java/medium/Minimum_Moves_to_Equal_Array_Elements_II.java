package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;

public class Minimum_Moves_to_Equal_Array_Elements_II {

    public static void main(String[] args) {
//        System.out.println(minMoves2(new int[]{1,0,0,8,6}));
    }

//    public static int minMoves2(int[] nums) {
//        int avg = (int) Arrays.stream(nums).average().getAsDouble();
//        int moves = 0;
//        for (int num : nums) {
//            int move = Math.abs(avg - num);
//            moves += move;
//            System.out.println(move);
//        }
//        return moves;
//    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums); // O(log n)
        int median = nums[nums.length / 2];
        int moves = 0;
        for (int num : nums) { // O (n)
            moves += Math.abs(median - num);
        }
        return moves;
    }
}
