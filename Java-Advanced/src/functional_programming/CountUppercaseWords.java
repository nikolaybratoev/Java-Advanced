package functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Predicate<String> findUpperCaseWords = word -> Character.isUpperCase(word.charAt(0));

        Consumer<String> printUpperCaseWords = System.out::println;

        try {
            List<String> list = Arrays.stream(reader.readLine().split("\\s+"))
                    .filter(findUpperCaseWords)
                    .collect(Collectors.toList());

            System.out.println(list.size());

            list.forEach(printUpperCaseWords);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
