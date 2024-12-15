package coures;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {

    public int template(int[] arr) {
        int begin = 0;
        var state = 0;
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
           // state modification

            while (true) { // window shrink condition
                // state modification
                begin++;
            }

//            result = Math.max(result, i - begin + 1);
        }

        return result;
    }
}
