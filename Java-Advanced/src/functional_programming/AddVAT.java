package functional_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<String, Double> parse = Double::parseDouble;

        UnaryOperator<Double> addVat = e -> e * 1.2;

        try {
            System.out.println("Prices with VAT:");

            Arrays.stream(reader.readLine().split("[, ]+"))
                    .map(parse)
                    .forEach(e -> {
                        double priceWithVat = addVat.apply(e);
                        System.out.printf("%.2f%n", priceWithVat);
                    });

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}

