import java.util.*;
import java.util.stream.Collectors;

public class FunctionalTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String inputText = scanner.nextLine();
        String text = inputText.toLowerCase().replace(",", "").replace(".", "");

        String[] words = text.split(" ");
        System.out.println("Количество слов в тексте: " + words.length + ".");

        System.out.println("10 наиболее часто встречающихся слов в тексте");
        Map<String, Integer> countedWords = new HashMap<>();
        for (String word : words) {
            int newValue = countedWords.getOrDefault(word, 0) + 1;
            countedWords.put(word, newValue);
        }

        Map<String, Integer> countedWordsSortedByKey = countedWords.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        Map<String, Integer> countedWordsSortedByValue = countedWordsSortedByKey.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (Map.Entry<String, Integer> word : countedWordsSortedByValue.entrySet()) {
            System.out.println(word.getValue() + " - " + word.getKey());
        }
    }
}

