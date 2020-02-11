package multidimensional_arrays;


/*
String Matrix Rotation

You are given a sequence of text lines. Assume these text lines form a matrix of characters 
(pad the missing positions with spaces to build a rectangular matrix). Write a program to rotate
the matrix by 90, 180, 270, 360, … degrees. Print the result at the console as sequence of strings
after receiving the “END” command.

INPUT
The input is read from the console:
    •	The first line holds a command in format "Rotate(X)" where X are the degrees of the requested rotation
    •	The next lines contain the lines of the matrix for rotation.
    •	The input ends with the command "END".
    
OUTPUT
Print at the console the rotated matrix as a sequence of text lines.

Examples

INPUT           OUTPUT   |   INPUT          OUTPUT
Rotate(90)      esh      |   Rotate(810)    ej
hello           xoe      |   js             xs
softuni         afl      |   exam           a
exam            mtl      |   END            m
END              uo      |
                 n       |
                 i       |

*/

import java.util.ArrayList;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rotateData = scanner.nextLine().split("[()]+");

        int rotateAngle = Integer.parseInt(rotateData[1]) % 360;

        ArrayList<String> inputStrings = new ArrayList<>();

        String line = scanner.nextLine();

        int maxLength = line.length();

        while (!line.equals("END")) {

            inputStrings.add(line);
            line = scanner.nextLine();

            if (maxLength < line.length()) {
                maxLength = line.length();
            }
        }

        char[][] matrix = new char[inputStrings.size()][maxLength];

        for (int r = 0; r < inputStrings.size(); r++) {

            for (int c = 0; c < maxLength; c++) {

                if (c > inputStrings.get(r).length() - 1) {
                    matrix[r][c] = ' ';
                } else {
                    matrix[r][c] = inputStrings.get(r).charAt(c);
                }
            }
        }

        if (rotateAngle == 90) {

            for (int c = 0; c < maxLength; c++) {

                for (int r = matrix.length - 1; r >= 0; r--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else if (rotateAngle == 180) {
            for (int r = matrix.length - 1; r >= 0; r--) {

                for (int c = maxLength - 1; c >= 0; c--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else if (rotateAngle == 270) {
            for (int c = maxLength - 1; c >= 0; c--) {

                for (int r = 0; r < matrix.length; r++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        } else {
            for (int r = 0; r < matrix.length; r++) {

                for (int c = 0; c < maxLength; c++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }
    }
}

