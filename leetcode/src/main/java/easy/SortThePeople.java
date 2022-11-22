package easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;

/**
 * 2418. Sort the People
 */
public class SortThePeople {
    public static void main(String[] args) {
        // Input: names = ["Mary","John","Emma"], heights = [180,165,170]
        // Output: ["Mary","Emma","John"]
        // Explanation: Mary is the tallest, followed by Emma and John.
        var solution = new SortThePeople();
        assertArrayEquals(new String[]{"Mary", "Emma", "John"}, solution.sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170}));
    }

    public String[] sortPeople(String[] names, int[] heights) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            people.add(new Person(names[i], heights[i]));
        }
        return people.stream().sorted(Comparator.reverseOrder())
                .map(Person::getName)
                .toArray(String[]::new);
    }

    class Person implements Comparable<Person> {
        private final String name;
        private final int height;

        public Person(String name, int height) {
            this.name = name;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Person o) {
            return this.height - o.height;
        }
    }
}
