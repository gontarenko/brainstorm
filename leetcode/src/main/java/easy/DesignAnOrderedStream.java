package easy;

import java.util.ArrayList;
import java.util.List;

public class DesignAnOrderedStream {
    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);
        // Inserts (3, "ccccc"), returns [].
        assert List.of().equals(os.insert(3, "ccccc"));
        // Inserts (1, "aaaaa"), returns ["aaaaa"].
        assert List.of("aaaaa").equals(os.insert(1, "aaaaa"));
        // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
        assert List.of("bbbbb", "ccccc").equals(os.insert(2, "bbbbb"));
        // Inserts (5, "eeeee"), returns [].
        assert List.of().equals(os.insert(5, "eeeee"));
        // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
        assert List.of("ddddd", "eeeee").equals(os.insert(4, "ddddd"));
    }

    static class OrderedStream {
        private final String[] values;
        private int ptr = 0;

        public OrderedStream(int n) {
            values = new String[n];
        }

        public List<String> insert(int idKey, String value) {
            values[--idKey] = value;
            List<String> chunk = new ArrayList<>();
            while (ptr < values.length && values[ptr] != null) {
                chunk.add(values[ptr]);
                ptr++;
            }
            return chunk;
        }
    }
}
