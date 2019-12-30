package classes.OpinionPoll;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Person> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            people.put(name, new Person(name, age));
        }

        people.entrySet()
                .stream()
                .filter(person -> person.getValue().getAge() > 30)
                .sorted(Comparator.comparing(a -> a.getValue().getName()))
                .forEach(p -> System.out.printf("%s - %d%n",
                        p.getValue().getName(),
                        p.getValue().getAge()));
    }
}
