package multidimensional_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = array[0];
        int cols = array[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int row = rows - 1;
        int col = cols - 1;

        while (row != -1) {

            int c = col;
            int r = row;

            while (c < cols && r >= 0) {
                System.out.print(matrix[r--][c++] + " ");
            }

            System.out.println();
            col--;

            if (col == -1) {
                col = 0;
                row--;
            }
        }
    }
}

