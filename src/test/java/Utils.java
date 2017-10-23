import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Utils {
    private static Random random = new Random();

    static int generateRandomNumber(int n) {
        return Math.abs(random.nextInt()) % n;
    }

    static String generateRandomLetter() {
        List<String> russianLetters = Arrays.asList("а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л",
                "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я");
        return russianLetters.get(generateRandomNumber(russianLetters.size()));
    }

    static String generateRandomWorld(int n) {
        String word = "";
        int maxWordSize = n;
        int wordSize = generateRandomNumber(maxWordSize);
        for(int i = 0; i < wordSize; i++){
            word += generateRandomLetter();
        }
        return word;
    }

    static String generateRandomSentence() {
        String sentence = "";
        int maxWordInSentence = 10;
        int maxWordSize = 10;
        int sentenceSize = generateRandomNumber(maxWordInSentence);
        for(int i = 0; i < sentenceSize; i++){
            sentence += generateRandomWorld(maxWordSize) + " ";
        }
        return sentence;
    }
}
