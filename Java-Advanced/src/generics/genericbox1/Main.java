package generics.genericbox1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        try {
            int n = Integer.parseInt(reader.readLine());

            while (n-- > 0) {

                String line = reader.readLine();

                Box<String> box = new Box<>(line);

                System.out.println(box.toString());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
