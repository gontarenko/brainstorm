package opt;


import java.util.Arrays;

public class МетодНаименьшихКвадратов {

    public static void main(String[] args) {
        // Исходные данные
        double[][] c = {
                {1, 4922.4, 23369, 1865.9, 24951.2, 12.7, 669.4},
                {1, 4130.7, 26629, 1807.9, 14648.1, 10.7, 644.1},
                {1, 4137.4, 29792, 1749.5, 39558.7, 10.8, 668},
                {1, 3889.4, 32495, 1690, 32365, 11.3, 693.7},
                {1, 4263.9, 34030, 1577, 46568.8, 13.4, 611.6},
                {1, 4243.5, 36709, 1444.5, 27929.6, 13.2, 608.3},
                {1, 3966.5, 39167, 1304.6, 37218.5, 12.9, 611.4},
                {1, 3657, 43724, 1208.6, 51418.1, 12.6, 583.9},
                {1, 3461.2, 47867, 1126.7, 116166.5, 12.3, 620.7},
                {1, 4316, 51344, 1102.8, 126304.8, 12.1, 564.7},
                {1, 3624.6, 57244, 1077.7, 159875.4, 11, 644.2}
        };

        double[] y = {2404.8, 2302.2, 2206.2, 2190.6, 2388.5, 2160.1, 2058.5, 1991.5, 2024.3, 2044.2, 2004.4};

        double yСр = Arrays.stream(y).sum() / y.length;

        // оценка МНК = (cT * c)-1 * cT * y
        double[][] cT = transposeMatrix(c);
        double[][] multiply = multiply(cT, c);
        double[][] inversed = inverseMatrix(multiply);
        double[][] multiply2 = multiply(inversed, cT);
        double[] оценкаМНК = matrixVectorMultiply(multiply2, y);
        System.out.println("Оценка MНК: " + Arrays.toString(оценкаМНК));

        // коэф эластичности
        double[] E_arr = new double[6];
        for (int i = 1; i < оценкаМНК.length; i++) {

            double accum = 0;
            int size = 0;
            for (int j = 0; j < c.length; j++) {
                accum += c[j][i];
                size++;
            }
            double xСр = accum / size;
//            System.out.println("i = %s, x = %s".formatted(i, xСр));

            double E = оценкаМНК[i] * xСр / yСр;
            E_arr[i - 1] = E;
        }
        System.out.println("коэф эластичности: " + Arrays.toString(оценкаМНК));

        // среднеквадратичные отклонения
        double sigma1 = calculateStandardDeviation(getArray(c, 1));
        double sigma2 = calculateStandardDeviation(getArray(c, 2));
        double sigma3 = calculateStandardDeviation(getArray(c, 3));
        double sigma4 = calculateStandardDeviation(getArray(c, 4));
        double sigma5 = calculateStandardDeviation(getArray(c, 5));
        double sigma6 = calculateStandardDeviation(getArray(c, 6));
        double sigmaY = calculateStandardDeviation(y);
        double[] sigma_arr = new double[]{sigma1, sigma2, sigma3, sigma4, sigma5, sigma6};
        System.out.println("среднеквадратичные отклонения: " + Arrays.toString(sigma_arr));

        // стандартизированные коэфы
        double fi1 = оценкаМНК[1] * sigma1 / sigmaY;
        double fi2 = оценкаМНК[2] * sigma2 / sigmaY;
        double fi3 = оценкаМНК[3] * sigma3 / sigmaY;
        double fi4 = оценкаМНК[4] * sigma4 / sigmaY;
        double fi5 = оценкаМНК[5] * sigma5 / sigmaY;
        double fi6 = оценкаМНК[6] * sigma6 / sigmaY;
        double[] fi_arr = new double[]{fi1, fi2, fi3, fi4, fi5, fi6};
        System.out.println("стандартизированные коэфы: " + Arrays.toString(fi_arr));

        // уравнение регрессии (вектор прогноза)
        double[] вектор_прогноза = new double[y.length];
        for (int row = 0; row < c.length; row++) {
            double sum = 0;
            for (int i = 0; i < оценкаМНК.length; i++) {
                sum += c[row][i] * оценкаМНК[i];
            }
            вектор_прогноза[row] = sum;
        }
        System.out.println("вектор_прогноза: " + Arrays.toString(вектор_прогноза));

        // вектор остатков
        double[] вектор_остатков = new double[y.length];
        for (int i = 0; i < вектор_прогноза.length; i++) {
            вектор_остатков[i] = y[i] - вектор_прогноза[i];
        }
        System.out.println("вектор_остатков: " + Arrays.toString(вектор_остатков));

        // вектор отклонений
        double[] вектор_отклонений = new double[y.length];
        for (int i = 0; i < y.length; i++) {
            вектор_отклонений[i] = y[i] - yСр;
        }
        System.out.println("вектор_отклонений: " + Arrays.toString(вектор_отклонений));

        double[][] век_ост = new double[][]{
                вектор_остатков
        };

        // коэф детерминации (остатки / отклонения)
        double остатки = multiply(век_ост, transposeMatrix(век_ост))[0][0];

        double[][] век_откл = new double[][]{
                вектор_отклонений
        };
        double отклонения = multiply(век_откл, transposeMatrix(век_откл))[0][0];

        double коэф_детерминации = 1 - (остатки / отклонения);

        System.out.println("коэф_детерминации: " + коэф_детерминации);
    }

    private static double[] getArray(double[][] c, int i) {
        int size = c.length;
        double[] x_arr = new double[size];


        for (int row = 0; row < c.length; row++) {
            x_arr[row] = c[row][i];
        }

        return x_arr;
    }

    private static void printMatrix(double[][] cT) {
        for (int i = 0; i < cT.length; i++) {
            System.out.println(Arrays.toString(cT[i]));
        }
    }

    // метод транспонирования матрицы
    public static double[][] transposeMatrix(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        double[][] transposedMatrix = new double[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }

    public static double[][] inverseMatrix(double[][] matrix) {
        int n = matrix.length;

        double[][] augmentedMatrix = new double[n][2 * n];

        // Создаем расширенную матрицу, где правая часть - единичная матрица
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix[i][j] = matrix[i][j];
                augmentedMatrix[i][j + n] = (i == j) ? 1 : 0;
            }
        }

        // Прямой ход метода Гаусса-Жордана
        for (int i = 0; i < n; i++) {
            double pivot = augmentedMatrix[i][i];

            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix[i][j] /= pivot;
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmentedMatrix[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j];
                    }
                }
            }
        }

        // Извлекаем обратную матрицу из расширенной
        double[][] inverseMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverseMatrix[i][j] = augmentedMatrix[i][j + n];
            }
        }

        return inverseMatrix;
    }

    static double[][] multiply(final double[][] matrixA, final double[][] matrixB) {
        if (matrixA[0].length != matrixB.length) {
            System.err.println("Эти матрицы нельзя перемножить");
            return null;
        }
        final var matrixM = new double[matrixA.length][matrixB[0].length];
        for (var i = 0; i < matrixM.length; i++) {
            for (var j = 0; j < matrixM[0].length; j++) {
                matrixM[i][j] = 0;
                for (var k = 0; k < matrixA[0].length; k++) {
                    matrixM[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return matrixM;
    }

    // Метод умножения матрицы на вектор
    public static double[] matrixVectorMultiply(double[][] a, double[] b) {
        int m = a.length;
        int n = a[0].length;
        double[] result = new double[m];

        for (int i = 0; i < m; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {
                sum += a[i][j] * b[j];
            }
            result[i] = sum;
        }

        return result;
    }

    public static double calculateStandardDeviation(double[] values) {
        // Вычисляем среднее значение
        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }
        double mean = sum / values.length;

        // Вычисляем сумму квадратов разностей
        double sumOfSquares = 0.0;
        for (double value : values) {
            sumOfSquares += Math.pow(value - mean, 2);
        }

        // Вычисляем среднеквадратичное отклонение
        double standardDeviation = Math.sqrt(sumOfSquares / values.length);

        return standardDeviation;
    }
}