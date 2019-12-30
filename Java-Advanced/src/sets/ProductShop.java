package sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        Map<String, Map<String, Double>> markets = new TreeMap<>();

        while (!input.equals("Revision")) {

            String[] tokens = input.split("[, ]+");
            String market = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            if (!markets.containsKey(market)) {
                markets.put(market, new LinkedHashMap<>());
                markets.get(market).put(product, price);
            } else {
                markets.get(market).put(product, price);
            }

            input = reader.readLine();

        }

        for (Map.Entry<String, Map<String, Double>> market : markets.entrySet()) {

            System.out.println(market.getKey() + "->");

            for (Map.Entry<String, Double> product : market.getValue().entrySet()) {

                System.out.printf("Product: %s, Price: %.1f%n",
                        product.getKey(),
                        product.getValue());
            }
        }

    }
}
