package hangman;

import java.security.SecureRandom;
import java.util.*;

public class WordDictionary {
    static final Map<Integer, List<List<String>>> WORD_CATEGORIES = new HashMap<>();

    static {
        WORD_CATEGORIES.put(1, Arrays.asList(
                Arrays.asList("окно", "стол", "люстра", "пол", "стул"), // Уровень 1
                Arrays.asList("чашка", "сумка", "одеяло", "подушка", "книга"), // Уровень 2
                Arrays.asList("часы", "зеркало", "ваза", "картина", "ковер") // Уровень 3
        ));
        WORD_CATEGORIES.put(2, Arrays.asList(
                Arrays.asList("код", "программа", "мышка", "файл", "строка"), // Уровень 1
                Arrays.asList("алгоритм", "функция", "переменная", "цикл", "условие"), // Уровень 2
                Arrays.asList("интерфейс", "полиморфизм", "наследование", "парадигма", "модульность") // Уровень 3
        ));
        WORD_CATEGORIES.put(3, Arrays.asList(
                Arrays.asList("роза", "лилия", "тюльпан", "мак", "подсолнух"), // Уровень 1
                Arrays.asList("сирень", "ландыш", "ромашка", "василек", "фиалка"), // Уровень 2
                Arrays.asList("акация", "барбарис", "жасмин", "зверобой", "одонтоглоссум") // Уровень 3
        ));
    }

    public static String getRandomWord(int category, int level) {
        if (level < 1 || level > 3) {
            throw new IllegalArgumentException("Неверный уровень сложности.");
        }
        List<List<String>> wordsByLevel = WORD_CATEGORIES.get(category);
        if (wordsByLevel == null) {
            throw new IllegalArgumentException("Некорректная категория.");
        }
        List<String> words = wordsByLevel.get(level - 1); // Индекс начинается с 0
        SecureRandom random = new SecureRandom();
        return words.get(random.nextInt(words.size()));
    }

    public static List<Integer> getCategories() {
        return new ArrayList<>(WORD_CATEGORIES.keySet());
    }
}
