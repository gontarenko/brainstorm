package medium;

/**
 * 1476. Subrectangle Queries
 */
public class SubrectangleQueries {

    public static void main(String[] args) {
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(
                new int[][]{
                        {1, 2, 1},
                        {4, 3, 4},
                        {3, 2, 1},
                        {1, 1, 1}
                }
        );
        // The initial rectangle (4x3) looks like:
        // 1 2 1
        // 4 3 4
        // 3 2 1
        // 1 1 1
        subrectangleQueries.getValue(0, 2); // return 1
        subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
        // After this update the rectangle looks like:
        // 5 5 5
        // 5 5 5
        // 5 5 5
        // 5 5 5
        subrectangleQueries.getValue(0, 2); // return 5
        subrectangleQueries.getValue(3, 1); // return 5
        subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
        // After this update the rectangle looks like:
        // 5   5   5
        // 5   5   5
        // 5   5   5
        // 10  10  10
        subrectangleQueries.getValue(3, 1); // return 10
        subrectangleQueries.getValue(0, 2); // return 5
    }

    private int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int row = row1; row <= row2; row++) {
            for (int col = col1; col <= col2; col++) {
                rectangle[row][col] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}
