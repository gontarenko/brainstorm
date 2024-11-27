package easy;

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        // Input: columnTitle = "ZY"
        //Output: 701

        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String columnTitle) {
        int columnNumber = 0;
        for (char c : columnTitle.toCharArray()) {
            columnNumber *= 26;
            columnNumber += c - 'A' + 1;
        }
        return columnNumber;
    }
}
