package functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<String, Integer> parse = Integer::parseInt;

        Function<Integer, String> reverse = String::valueOf;

        Predicate<Integer> even = e -> e % 2 == 0;

        Comparator<Integer> sort = Integer::compareTo;

        try {
            List<String> input = getEvenNumbers(reader, parse, reverse, even);

            printCollection(input);

            List<String> collect = getSortedCollection(parse, reverse, sort, input);

            printCollection(collect);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static List<String> getSortedCollection(Function<String, Integer> parse, Function<Integer, String> reverse, Comparator<Integer> sort, List<String> input) {
        return input.stream()
                .map(parse)
                .sorted(sort)
                .map(reverse)
                .collect(Collectors.toList());
    }

    private static List<String> getEvenNumbers(BufferedReader reader, Function<String, Integer> parse, Function<Integer, String> reverse, Predicate<Integer> even) throws IOException {
        return Arrays.stream(reader.readLine().split("[, ]+"))
                .map(parse)
                .filter(even)
                .map(reverse)
                .collect(Collectors.toList());
    }

    private static void printCollection(List<String> collect) {
        System.out.println(String.join(", ", collect));
    }
}
