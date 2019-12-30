package classes.Carinfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(reader.readLine());

            for (int i = 0; i < n; i++) {

                String[] input = reader.readLine().split("\\s+");
                String make = input[0];
                String model = input[1];
                int horsePower = Integer.parseInt(input[2]);

                Car car = new Car(make, model, horsePower);

                System.out.println(car.toString());

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
