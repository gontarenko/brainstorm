package easy;

public class FinalValueOfVariableAfterPerformingOperations {

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            x += operation.contains("++") ? 1 : -1;
        }
        return x;
    }
}
