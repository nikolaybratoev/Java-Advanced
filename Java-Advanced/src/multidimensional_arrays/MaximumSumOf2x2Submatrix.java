package multidimensional_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(reader.readLine().split("[, ]+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = input[0];
        int cols = input[1];

        int[][] matrix = new int[rows][cols];

        readMatrix(reader, matrix);

        long maxSum = Integer.MIN_VALUE;
        int maxRow = -1;
        int maxCol = -1;

        for (int row = 0; row < matrix.length - 1; row++) {

            for (int col = 0; col < matrix[row].length - 1; col++) {

                int currentSum = findMaxSum(matrix, row, col);

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }

        printMaxInnerMatrix(matrix, maxRow, maxCol, maxSum);

    }

    private static void printMaxInnerMatrix(int[][] matrix, int maxRow, int maxCol, long maxSum) {
        System.out.printf("%d %d%n%d %d%n%d",
                matrix[maxRow][maxCol],
                matrix[maxRow][maxCol + 1],
                matrix[maxRow + 1][maxCol],
                matrix[maxRow + 1][maxCol + 1],
                maxSum);
    }

    private static int findMaxSum(int[][] matrix, int row, int col) {
        return matrix[row][col] +
                matrix[row][col + 1] +
                matrix[row + 1][col] +
                matrix[row + 1][col + 1];
    }

    private static void readMatrix(BufferedReader reader, int[][] matrix) throws IOException {
        for (int row = 0; row < matrix.length; row++) {

            int[] array = Arrays.stream(reader.readLine().split("[, ]+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = array[col];
            }
        }
    }
}

