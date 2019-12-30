package functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FilterByAge {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(reader.readLine());

            Map<String, Integer> data = new LinkedHashMap<>();

            fillData(reader, n, data);

            String condition = reader.readLine();
            int filterAge = Integer.parseInt(reader.readLine());
            String input = reader.readLine();

            switch (condition) {

                case "older":
                    filterOlderThan(data, filterAge, input);
                    break;

                case "younger":
                    filterYoungerThen(data, filterAge, input);
                    break;

                default:
                    System.out.println("Wrong input!");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void fillData(BufferedReader reader, int n, Map<String, Integer> data) throws IOException {
        for (int i = 0; i < n; i++) {

            String[] input = reader.readLine().split("[, ]+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            data.putIfAbsent(name, age);
        }
    }

    private static void filterYoungerThen(Map<String, Integer> data, int filterAge, String input) {
        switch (input) {

            case "name": {
                Stream<Map.Entry<String, Integer>> filtered = findYoungerThen(filterAge, data, input);
                filtered.forEach(e -> System.out.println(e.getKey()));
            }
            break;

            case "age": {
                Stream<Map.Entry<String, Integer>> filtered = findYoungerThen(filterAge, data, input);
                filtered.forEach(e -> System.out.println(e.getValue()));
            }
            break;

            case "name age": {
                Stream<Map.Entry<String, Integer>> filtered = findYoungerThen(filterAge, data, input);
                filtered.forEach(e -> System.out.printf("%s - %d%n",
                        e.getKey(),
                        e.getValue()));
            }
            break;

            default:
                System.out.println("Wring input!");
        }
    }

    private static Stream<Map.Entry<String, Integer>> findYoungerThen(int age, Map<String, Integer> data, String input) {
        if (input.equals("name")) {
            return data.entrySet()
                    .stream()
                    .filter(e -> e.getValue() <= age)
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()));
        }
        return data.entrySet()
                .stream()
                .filter(e -> e.getValue() <= age);
    }

    private static void filterOlderThan(Map<String, Integer> data, int filterAge, String input) {
        switch (input) {

            case "name": {
                Stream<Map.Entry<String, Integer>> filtered = findOlderThen(filterAge, data, input);
                filtered.forEach(e -> System.out.println(e.getKey()));
            }
            break;

            case "age": {
                Stream<Map.Entry<String, Integer>> filtered = findOlderThen(filterAge, data, input);
                filtered.forEach(e -> System.out.println(e.getValue()));
            }
            break;

            case "name age": {
                Stream<Map.Entry<String, Integer>> filtered = findOlderThen(filterAge, data, input);
                filtered.forEach(e -> System.out.printf("%s - %d%n",
                        e.getKey(),
                        e.getValue()));
            }
            break;

            default:
                System.out.println("Wring input!");
        }
    }

    private static Stream<Map.Entry<String, Integer>> findOlderThen(int age, Map<String, Integer> data, String input) {
        if (input.equals("name")) {
            return data.entrySet()
                    .stream()
                    .filter(e -> e.getValue() >= age)
                    .sorted(Comparator.comparing(Map.Entry::getKey));
        }

        return data.entrySet()
                .stream()
                .filter(e -> e.getValue() >= age);
    }
}
