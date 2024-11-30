package easy;

import java.util.ArrayList;
import java.util.List;

public class Find_All_Numbers_Disappeared_in_an_Array {
    public static void main(String[] args) {

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] numbers = new int[nums.length + 1];
        for (int num : nums) {
            numbers[num]++;
        }
        List<Integer> disappearedNumbers = new ArrayList<>(nums.length);
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                disappearedNumbers.add(i);
            }
        }
        return disappearedNumbers;
    }
}
