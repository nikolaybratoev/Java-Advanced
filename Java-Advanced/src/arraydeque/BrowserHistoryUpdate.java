package arraydeque;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> stackForward = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {

                if (stack.size() > 1) {
                    String url = stack.pop();
                    stackForward.push(url);
                    System.out.println(stack.peek());
                } else {
                    System.out.println("no previous URLs");
                }

            } else if (input.equals("forward")) {

                if (stackForward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    String url = stackForward.pop();
                    System.out.println(url);
                    stack.push(url);
                }
            } else {
                stackForward.clear();
                stack.push(input);
                System.out.println(stack.peek());
            }

            input = scanner.nextLine();

        }
    }
}

