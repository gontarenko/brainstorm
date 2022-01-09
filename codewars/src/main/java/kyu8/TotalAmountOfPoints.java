package kyu8;

import java.util.Arrays;

public class TotalAmountOfPoints {
    public static void main(String[] args) {
        assert 30 == TotalAmountOfPoints.points(new String[]{"1:0", "2:0", "3:0", "4:0", "2:1", "3:1", "4:1", "3:2", "4:2", "4:3"});
        assert 10 == TotalAmountOfPoints.points(new String[]{"1:1", "2:2", "3:3", "4:4", "2:2", "3:3", "4:4", "3:3", "4:4", "4:4"});
        assert 0 == TotalAmountOfPoints.points(new String[]{"0:1", "0:2", "0:3", "0:4", "1:2", "1:3", "1:4", "2:3", "2:4", "3:4"});
    }

    public static int points(String[] games) {
        return Arrays.stream(games)
                .mapToInt(TotalAmountOfPoints::toPoints)
                .sum();
    }

    private static int toPoints(String matchScore) {
        char ourScore = matchScore.charAt(0);
        char enemyScore = matchScore.charAt(2);
        if (ourScore > enemyScore)
            return 3;
        if (ourScore == enemyScore)
            return 1;
        return 0;
    }
}
