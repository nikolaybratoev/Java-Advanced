package functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            List<String> list = Arrays.stream(reader.readLine().split("[, ]+"))
                    .collect(Collectors.toList());

            System.out.printf("Count = %d%n", list.size());

            int sum = list.stream()
                    .mapToInt(Integer::parseInt)
                    .sum();

            System.out.printf("Sum = %d", sum);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}

