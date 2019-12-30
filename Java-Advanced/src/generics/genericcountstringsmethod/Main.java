package generics.genericcountstringsmethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        try {
            int n = Integer.parseInt(reader.readLine());

            List<Box<String>> boxes = new ArrayList<>();

            while (n-- > 0) {
                boxes.add(new Box<>(reader.readLine()));
            }

            Box<String> box = new Box<>(reader.readLine());

            System.out.println(findAllOccurrences(boxes, box));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static<T extends Comparable> int findAllOccurrences(List<Box<T>> boxes, Box<String> box) {
        return Math.toIntExact(boxes
                .stream()
                .filter(b -> 0 < b.getElement().compareTo(box.getElement()))
                .count());
    }
}
