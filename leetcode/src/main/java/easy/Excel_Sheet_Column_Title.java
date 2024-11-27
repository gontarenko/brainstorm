package easy;

public class Excel_Sheet_Column_Title {
    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }

    public static String convertToTitle(int columnNumber) {
        char countFrom = 'A';
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            result.append((char) (columnNumber % 26 + countFrom));
            columnNumber /= 26;
        }
        return result.reverse().toString();
    }
}
