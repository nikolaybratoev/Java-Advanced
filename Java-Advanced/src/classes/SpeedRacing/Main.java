package classes.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCoast = Double.parseDouble(tokens[2]);

            cars.putIfAbsent(model, new Car(model, fuelAmount, fuelCoast));
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");
            String model = tokens[1];
            double distanceToTravel = Double.parseDouble(tokens[2]);

            if (cars.containsKey(model)) {

                if (!cars.get(model).travel(distanceToTravel)) {
                    System.out.println("Insufficient fuel for the drive");
                }
            }

            input = scanner.nextLine();

        }

        for (Map.Entry<String, Car> entry : cars.entrySet()) {
            System.out.printf("%s %.2f %.0f%n",
                    entry.getKey(),
                    entry.getValue().getFuel(),
                    entry.getValue().getDistance());
        }

    }
}
