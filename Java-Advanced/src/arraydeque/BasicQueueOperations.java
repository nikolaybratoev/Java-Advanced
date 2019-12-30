package arraydeque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] commands = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .limit(commands[0])
                .mapToInt(Integer::parseInt)
                .forEach(queue::offer);

        while (commands[1]-- > 0) {
            queue.poll();
        }

        if (queue.contains(commands[2])) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }

    }
}

