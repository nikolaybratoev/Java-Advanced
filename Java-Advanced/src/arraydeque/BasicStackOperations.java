package arraydeque;

import java.util.*;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] commands = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .limit(commands[0])
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(numbers)
                .forEach(stack::push);

        int push = commands[1];

        for (int i = 0; i < push; i++) {
            stack.pop();
        }

        if (stack.contains(commands[2])) {
            System.out.println("true");
        } else {
            if (stack.size() == 0) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(stack));
            }
        }

    }
}

