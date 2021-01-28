package server;

import java.util.HashMap;
import java.util.Map;

public class Censored {

    private static Map<String, String> words = new HashMap<>();

    static {
        words.put("спб", "СПБ");
        words.put("екб", "ЕКБ");
        words.put("мск", "МСК");
    }

    public static String toCensored(String inputText) {

        boolean wasCensored = false;

        String[] wordsToCheck = inputText.split(" ");

        for (int i=0; i < wordsToCheck.length; i++) {

            String replacement = words.get(wordsToCheck[i]);

            if (replacement != null) {
                wasCensored = true;
                wordsToCheck[i] = replacement;
            }
        }

        if (wasCensored) {
            return String.join(" ", wordsToCheck);
        }
        else {
            return inputText;
        }

    }
}