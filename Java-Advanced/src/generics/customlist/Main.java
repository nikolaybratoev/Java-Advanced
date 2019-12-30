package generics.customlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String END_COMMAND = "end";
    private static final String INVALID_COMMAND = "Invalid command!";
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        SmartList<String> list = new SmartList<>();

        try {
            String input = reader.readLine();

            while (!input.equalsIgnoreCase(END_COMMAND)) {
                String[] tokens = input.split("\\s+");
                String command = tokens[0];

                switch (command) {

                    case "Add":
                        list.add(tokens[1]);
                        break;

                    case "Remove":
                        list.remove(Integer.parseInt(tokens[1]));
                        break;

                    case "Contains":
                        System.out.println(list.contains(tokens[1]));
                        break;

                    case "Swap":
                        list.swap(Integer.parseInt(tokens[1]),
                                Integer.parseInt(tokens[2]));
                        break;

                    case "Greater":
                        System.out.println(list.countGreaterThan(tokens[1]));
                        break;

                    case "Max":
                        System.out.println(list.getMax());
                        break;

                    case "Min":
                        System.out.println(list.getMin());
                        break;

                    case "Print":
                        list.forEach(System.out::println);
                        break;

                    default:
                        System.out.println(INVALID_COMMAND);
                }

                input = reader.readLine();

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
