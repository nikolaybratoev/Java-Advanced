package sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Set<String> parking = new HashSet<>();

        while (!input.equals("END")) {

            String[] tokens = input.split("[, ]+");
            String command = tokens[0];
            String car = tokens[1];

            if (command.equals("IN")) {
                parking.add(car);
            } else {
                parking.remove(car);
            }

            input = reader.readLine();

        }

        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parking) {
                System.out.println(car);
            }
        }

    }
}

