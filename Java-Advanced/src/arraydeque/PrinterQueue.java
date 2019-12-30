package arraydeque;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> printer = new ArrayDeque<>();

        while (!input.equals("print")) {

            if (input.equals("cancel")) {

                if (printer.size() >= 1) {
                    System.out.println("Canceled " + printer.pollFirst());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                printer.offer(input);
            }

            input = scanner.nextLine();

        }

        for (String file : printer) {
            System.out.println(file);
        }

    }
}

