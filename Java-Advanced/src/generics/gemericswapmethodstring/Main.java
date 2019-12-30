package generics.gemericswapmethodstring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(streamReader);

        try {
            int n = Integer.parseInt(reader.readLine());

            List<Box<String>> list = new ArrayList<>();

            while (n-- > 0) {

                String line = reader.readLine();

                Box<String> box = new Box<>(line);

                list.add(box);
            }

            String[] input = reader.readLine().split("\\s+");
            int first = Integer.parseInt(input[0]);
            int second = Integer.parseInt(input[1]);

            swapBoxes(list, first, second);

            list.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static<T> void swapBoxes(List<Box<T>> container, int first, int second) {
        Collections.swap(container, first, second);
    }
}