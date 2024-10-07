package easy;

import org.junit.Assert;

import java.util.Map;

public class ShortestDistanceToTargetStringInACircularArray {
    public static void main(String[] args) {
//        Input: words = ["hello","i","am","leetcode","hello"], target = "hello", startIndex = 1
//        Output: 1
//        Explanation: We start from index 1 and can reach "hello" by
//                - moving 3 units to the right to reach index 4.
//                - moving 2 units to the left to reach index 4.
//                - moving 4 units to the right to reach index 0.
//                - moving 1 unit to the left to reach index 0.
//        The shortest distance to reach "hello" is 1.
        Assert.assertEquals(1, new ShortestDistanceToTargetStringInACircularArray().closetTarget(
                new String[]{"hello","i","am","leetcode","hello"},
                "hello",
                1
        ));
        Assert.assertEquals(1, new ShortestDistanceToTargetStringInACircularArray().closetTargetFaster(
                new String[]{"hello","i","am","leetcode","hello"},
                "hello",
                1
        ));
    }

    public int closetTargetFaster(String[] words, String target, int startIndex) {
        final int length = words.length;
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                int distance = Math.abs(startIndex - i);
                int newResult = Math.min(distance, length - distance);
                if (newResult < result) {
                    result = newResult;
                }
            }
        }

        return result;
    }


    public int closetTarget(String[] words, String target, int startIndex) {
        if (words[startIndex].equals(target)) {
            return 0;
        }
        CircularArray circularArray = new CircularArray(words, startIndex);
        int found = -1;
        int count = 0;
        String value;

        while ((value = circularArray.next()) != null) {
            count++;
            if (value.equals(target)) {
                found = count;
                break;
            }
        }

        count = 0;
        circularArray.reset();

        while ((value = circularArray.previous()) != null) {
            count++;
            if (value.equals(target)) {
                if (found == -1 || count < found) {
                    found = count;
                }
                break;
            }
        }
        return found;
    }

    class CircularArray {
        String[] arr;
        int startIndex;
        int index;

        public CircularArray(String[] arr, int index) {
            this.arr = arr;
            this.index = index;
            this.startIndex = index;
        }

        /**
         * @return null if was make a circle
         */
        String next() {
            index++;
            if (index >= arr.length) {
                index = 0;
            }
            if (index == startIndex) {
                return null;
            }
            return arr[index];
        }

        /**
         * @return null if was make a circle
         */
        String previous() {
            index--;
            if (index < 0) {
                index = arr.length - 1;
            }
            if (index == startIndex) {
                return null;
            }
            return arr[index];
        }

        void reset() {
            index = startIndex;
        }
    }
}
