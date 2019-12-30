package multidimensional_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumMatrixElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(reader.readLine().split("[, ]+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = input[0];
        int cols = input[1];

        System.out.println(rows);
        System.out.println(cols);

        int[][] matrix = new int[rows][cols];

        readMatrix(reader, matrix);

        sumMatrixAndPrint(matrix);

    }

    private static void sumMatrixAndPrint(int[][] matrix) {
        long sum = 0;

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }

        System.out.println(sum);
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

