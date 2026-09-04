import java.util.*;

public class StopWordFilteredWordFrequency {

    public static void printFilteredWordFrequency(String feedback) {

        // Convert to lowercase and remove punctuation
        String cleanedText = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "");

        // Split into words
        String[] words = cleanedText.split("\\s+");

        // Stop words
        Set<String> stopWords = new HashSet<>(
                Arrays.asList("the", "was", "and", "a", "is", "of", "in")
        );

        // Count word frequencies
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            if (stopWords.contains(word)) {
                continue;
            }

            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        // Sort entries by frequency in descending order
        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        entries.sort((a, b) ->
                b.getValue().compareTo(a.getValue()));

        // Print result
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        String feedback =
                "The mentor was great, the session was great and clear.";

        printFilteredWordFrequency(feedback);
    }
}
