package sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountRealNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] input = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {

            if (!map.containsKey(input[i])) {
                map.put(input[i], 1);
            } else {
                map.put(input[i], map.get(input[i]) + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            System.out.println(String.format("%.1f -> %d",
                    entry.getKey(),
                    entry.getValue()));
        }

    }
}
