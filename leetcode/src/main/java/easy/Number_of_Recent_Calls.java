package easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class Number_of_Recent_Calls {

}

class RecentCounter {
    Deque<Integer> queue = new ArrayDeque<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        int target = t - 3000;
        queue.addLast(t);
        while (queue.peekFirst() < target) {
            queue.pollFirst();
        }
        return queue.size();
    }
}
