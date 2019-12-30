package arraydeque;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> browser = new ArrayDeque<>();

        while (!input.equals("Home")) {

            if (input.equals("back")) {

                if (browser.size() > 1) {
                    browser.pop();
                    System.out.println(browser.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                browser.push(input);
                System.out.println(input);
            }

            input = scanner.nextLine();

        }
    }
}

