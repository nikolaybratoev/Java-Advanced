package multidimensional_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CompareMatrices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = input[0];
        int cols = input[1];

        int[][] firstMatrix = new int[rows][cols];

        fillMatrix(reader, firstMatrix);

        input = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        rows = input[0];
        cols = input[1];

        int[][] secondMatrix = new int[rows][cols];

        fillMatrix(reader, secondMatrix);

        if (isEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    private static boolean isEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {

            for (int col = 0; col < firstMatrix[row].length; col++) {

                if (firstMatrix[row].length != secondMatrix[row].length) {
                    return false;
                }

                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void fillMatrix(BufferedReader reader, int[][] matrix) throws IOException {
        for (int row = 0; row < matrix.length; row++) {

            int[] firstMatrixFill = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = firstMatrixFill[col];
            }
        }
    }
}

