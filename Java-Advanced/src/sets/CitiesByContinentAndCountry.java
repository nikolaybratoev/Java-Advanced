package sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, Map<String, ArrayList<String>>> data = new LinkedHashMap<>();

        fillMap(reader, n, data);

        printMap(data);

    }

    private static void printMap(Map<String, Map<String, ArrayList<String>>> data) {
        for (Map.Entry<String, Map<String, ArrayList<String>>> continent : data.entrySet()) {

            System.out.printf("%s:%n", continent.getKey());

            for (Map.Entry<String, ArrayList<String>> country : continent.getValue().entrySet()) {

                System.out.printf("%s -> ", country.getKey());

                for (int city = 0; city < country.getValue().size(); city++) {

                    if (city + 1 == country.getValue().size()) {
                        System.out.print(country.getValue().get(city));
                    } else {
                        System.out.print(country.getValue().get(city) + ", ");
                    }
                }

                System.out.println();
            }
        }
    }

    private static void fillMap(BufferedReader reader, int n, Map<String, Map<String, ArrayList<String>>> data) throws IOException {
        for (int i = 0; i < n; i++) {

            String[] input = reader.readLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (data.containsKey(continent)) {
                data.get(continent).putIfAbsent(country, new ArrayList<>());
                data.get(continent).get(country).add(city);
            } else {
                data.put(continent, new LinkedHashMap<>());
                data.get(continent).put(country, new ArrayList<>());
                data.get(continent).get(country).add(city);
            }
        }
    }
}
