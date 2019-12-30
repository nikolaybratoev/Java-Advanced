package sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> firstPlayerDeck = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayerDeck = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (int round = 0; round <= 50; round++) {

            if (firstPlayerDeck.isEmpty()) {
                System.out.println("Second player win!");
                return;
            }

            if (secondPlayerDeck.isEmpty()) {
                System.out.println("First player win!");
                return;
            }

            Integer firstPlayerCard = getTopCard(firstPlayerDeck);

            Integer secondPlayerCard = getTopCard(secondPlayerDeck);

            firstPlayerDeck.remove(firstPlayerCard);

            secondPlayerDeck.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerDeck.add(secondPlayerCard);
                secondPlayerDeck.add(firstPlayerCard);
            } else {
                firstPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
                continue;
            }
        }

        Integer firstPlayerSize = firstPlayerDeck.size();

        Integer secondPlayerSize = secondPlayerDeck.size();

        if (firstPlayerSize > secondPlayerSize) {
            System.out.println("First player win!");
        } else if (secondPlayerSize > firstPlayerSize) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }

    private static Integer getTopCard(Set<Integer> firstPlayerDeck) {
        return firstPlayerDeck.stream()
                .findFirst()
                .orElse(0);
    }
}

