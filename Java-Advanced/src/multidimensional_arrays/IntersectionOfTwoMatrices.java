package multidimensional_arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        char[][] firstMatrix = readMatrix(reader, rows, cols);

        char[][] secondMatrix = readMatrix(reader, rows, cols);

        checkMatrices(firstMatrix, secondMatrix);

        printMatrix(secondMatrix);

    }

    private static char[][] readMatrix(BufferedReader reader, int rows, int cols) throws IOException {
        char[][] firstMatrix = new char[rows][cols];

        for (int row = 0; row < firstMatrix.length; row++) {

            String[] input = reader.readLine().split("\\s+");

            for (int col = 0; col < firstMatrix[row].length; col++) {
                firstMatrix[row][col] = input[col].charAt(0);
            }
        }

        return firstMatrix;
    }

    private static void printMatrix(char[][] secondMatrix) {
        for (int row = 0; row < secondMatrix.length; row++) {

            for (int col = 0; col < secondMatrix[row].length; col++) {

                System.out.print(secondMatrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static void checkMatrices(char[][] firstMatrix, char[][] secondMatrix) {
        for (int row = 0; row < firstMatrix.length; row++) {

            for (int col = 0; col < secondMatrix[row].length; col++) {

                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    secondMatrix[row][col] = '*';
                }
            }
        }
    }
}

