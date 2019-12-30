package multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        matrix = fillMatrix(scanner, matrix);

        int firstSum = sumFirstDiagonal(matrix, size);
        int secondSum = sumSecondDiagonal(matrix);

        System.out.println(Math.abs(firstSum - secondSum));

    }

    private static int sumSecondDiagonal(int[][] matrix) {
        int sum = 0;

        int rows = matrix.length - 1;
        int cols = 0;

        while (rows >= 0) {
            sum += matrix[rows][cols];
            rows--;
            cols++;
        }

        return sum;
    }

    private static int sumFirstDiagonal(int[][] matrix, int size) {
        int sum = 0;

        int rows = 0;
        int cols = 0;

        while (rows < size && cols <= size) {
            sum += matrix[rows][cols];
            rows++;
            cols++;
        }

        return sum;
    }

    private static int[][] fillMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {

            int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input[col];
            }
        }

        return matrix;
    }
}
