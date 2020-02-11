package multidimensional_arrays;

//Reverse Matrix Diagonals

/*
You are given a matrix (2D array) of integers. 
You have to print the matrix diagonal but in reversed order. Print each diagonal on new line. 

INPUT
On the first line, single integer the number R of rows in the matrix. On each of the next R lines, 
C numbers separated by single spaces. Note that R and C may have different values. 

OUTPUT
The output should consist of R lines, each consisting of exactly C characters, separated by spaces,
representing the matrix diagonals reversed.
*/

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

