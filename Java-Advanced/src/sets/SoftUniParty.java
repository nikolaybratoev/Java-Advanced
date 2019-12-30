package sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Set<String> guests = new TreeSet<>();

        while (!input.equals("PARTY")) {
            guests.add(input);
            input = reader.readLine();
        }

        input = reader.readLine();

        while (!input.equals("END")) {
            guests.remove(input);
            input = reader.readLine();
        }

        System.out.println(guests.size());

        if (!guests.isEmpty()) {
            for (String guest : guests) {
                System.out.println(guest);
            }
        }

    }
}

