package functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int[] input = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int start = input[0];
            int end = input[1];

            String type = reader.readLine();

            printEvenOrOdd(start, end, type);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void printEvenOrOdd(int start, int end, String type) {
        switch (type) {

            case "odd":
                for (int i = start; i <= end; i++) {

                    if (i % 2 != 0) {
                        System.out.print(i + " ");
                    }
                }
                break;

            case "even":
                for (int i = start; i <= end; i++) {

                    if (i % 2 == 0) {
                        System.out.print(i + " ");
                    }
                }
                break;
        }
    }
}

