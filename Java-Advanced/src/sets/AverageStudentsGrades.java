package sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class AverageStudentsGrades {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, ArrayList<Double>> students = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String[] input = reader.readLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
                students.get(name).add(grade);
            } else {
                students.get(name).add(grade);
            }
        }

        for (Map.Entry<String, ArrayList<Double>> student : students.entrySet()) {

            System.out.printf("%s -> ", student.getKey());

            student.getValue()
                    .forEach(e -> System.out.print(String.format("%.2f ", e)));

            double avg = findAverageSum(student.getValue());

            System.out.printf("(avg: %.2f)%n", avg);
        }

    }

    private static double findAverageSum(ArrayList<Double> value) {
        double sum = 0;

        for (int i = 0; i < value.size(); i++) {
            sum += value.get(i);
        }

        return sum / value.size();
    }
}

