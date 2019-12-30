package classes.constructors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(reader.readLine());

            for (int i = 0; i < n; i++) {

                String input = reader.readLine();

                if (!input.contains(" ")) {
                    Car car = new Car(input);
                    System.out.println(car.infoPrint());
                } else {
                    String[] tokens = input.split("\\s+");
                    String make = tokens[0];
                    String model = tokens[1];
                    int horsePower = Integer.parseInt(tokens[2]);

                    Car car = new Car(make, model, horsePower);

                    System.out.println(car.infoPrint());
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
