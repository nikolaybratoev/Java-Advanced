package arraydeque;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long input = Long.parseLong(scanner.nextLine());

        ArrayDeque<Long> binary = new ArrayDeque<>();

        if (input == 0) {
            System.out.println(0);
        } else {

            while (input != 0) {
                binary.push(input % 2);
                input /= 2;
            }

        }

        for (Long number : binary) {
            System.out.print(number);
        }

    }
}

