package arraydeque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> numbers = new ArrayDeque<>(Arrays.asList(input));

        while (numbers.size() != 1) {

            int firstNumber = Integer.parseInt(numbers.pop());
            String operator = numbers.pop();
            int secondNumber = Integer.parseInt(numbers.pop());

            if (operator.equals("+")) {
                int result = firstNumber + secondNumber;
                numbers.push(String.valueOf(result));
            } else {
                int result = firstNumber - secondNumber;
                numbers.push(String.valueOf(result));
            }
        }

        System.out.println(numbers.peek());

    }
}
