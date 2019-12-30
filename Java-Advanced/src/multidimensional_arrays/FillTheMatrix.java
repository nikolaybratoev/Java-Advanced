package multidimensional_arrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);

        char pattern = input[1].charAt(0);

        int[][] matrix = new int[size][size];

        if (pattern == 'A') {
            matrix = firstPatternMatrix(size);
        } else {
            matrix = secondPatternMatrix(size);
        }

        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {

                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] secondPatternMatrix(int size) {
        int[][] matrix = new int[size][size];

        int value = 1;
        for (int col = 0; col < size; col++) {

            if (col % 2 == 0) {

                for (int row = 0; row < size; row++) {

                    matrix[row][col] = value;
                    value++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = value;
                    value++;
                }
            }
        }

        return matrix;
    }

    private static int[][] firstPatternMatrix(int size) {
        int[][] matrix = new int[size][size];

        int value = 1;

        for (int col = 0; col < matrix.length; col++) {

            for (int row = 0; row < matrix[col].length; row++) {
                matrix[row][col] = value;
                value++;
            }
        }

        return matrix;
    }
}

