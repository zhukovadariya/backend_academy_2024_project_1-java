package hangman;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class WordDictionaryTest {
    @Test
    void getRandomWord_shouldReturnRandomWordFromCorrectCategoryAndLevel() {

        List<String> expectedWordsCategory1Level1 = Arrays.asList("окно", "стол", "люстра", "пол", "стул");
        String randomWordCategory1Level1 = WordDictionary.getRandomWord(1, 1);
        assertTrue(expectedWordsCategory1Level1.contains(randomWordCategory1Level1));

        List<String> expectedWordsCategory1Level2 = Arrays.asList("чашка", "сумка", "одеяло", "подушка", "книга");
        String randomWordCategory1Level2 = WordDictionary.getRandomWord(1, 2);
        assertTrue(expectedWordsCategory1Level2.contains(randomWordCategory1Level2));

        List<String> expectedWordsCategory1Level3 = Arrays.asList("часы", "зеркало", "ваза", "картина", "ковер");
        String randomWordCategory1Level3 = WordDictionary.getRandomWord(1, 3);
        assertTrue(expectedWordsCategory1Level3.contains(randomWordCategory1Level3));

        List<String> expectedWordsCategory2Level1 = Arrays.asList("код", "программа", "мышка", "файл", "строка");
        String randomWordCategory2Level1 = WordDictionary.getRandomWord(2, 1);
        assertTrue(expectedWordsCategory2Level1.contains(randomWordCategory2Level1));

        List<String> expectedWordsCategory2Level2 = Arrays.asList("алгоритм", "функция", "переменная", "цикл", "условие");
        String randomWordCategory2Level2 = WordDictionary.getRandomWord(2, 2);
        assertTrue(expectedWordsCategory2Level2.contains(randomWordCategory2Level2));

        List<String> expectedWordsCategory2Level3 = Arrays.asList("интерфейс", "полиморфизм", "наследование", "парадигма", "модульность");
        String randomWordCategory2Level3 = WordDictionary.getRandomWord(2, 3);
        assertTrue(expectedWordsCategory2Level3.contains(randomWordCategory2Level3));

        List<String> expectedWordsCategory3Level1 = Arrays.asList("роза", "лилия", "тюльпан", "мак", "подсолнух");
        String randomWordCategory3Level1 = WordDictionary.getRandomWord(3, 1);
        assertTrue(expectedWordsCategory3Level1.contains(randomWordCategory3Level1));

        List<String> expectedWordsCategory3Level2 = Arrays.asList("сирень", "ландыш", "ромашка", "василек", "фиалка");
        String randomWordCategory3Level2 = WordDictionary.getRandomWord(3, 2);
        assertTrue(expectedWordsCategory3Level2.contains(randomWordCategory3Level2));

        List<String> expectedWordsCategory3Level3 = Arrays.asList("акация", "барбарис", "жасмин", "зверобой", "одонтоглоссум");
        String randomWordCategory3Level3 = WordDictionary.getRandomWord(3, 3);
        assertTrue(expectedWordsCategory3Level3.contains(randomWordCategory3Level3));
    }

    @Test
    void getRandomWord_shouldThrowIllegalArgumentExceptionForIncorrectLevel() {
        assertThrows(IllegalArgumentException.class, () -> WordDictionary.getRandomWord(1, 0));
        assertThrows(IllegalArgumentException.class, () -> WordDictionary.getRandomWord(1, 4));
    }

    @Test
    void getRandomWord_shouldThrowIllegalArgumentExceptionForIncorrectCategory() {
        assertThrows(IllegalArgumentException.class, () -> WordDictionary.getRandomWord(4, 2));
    }

    @Test
    void getCategories_shouldReturnListOfCategories() {
        List<Integer> expectedCategories = Arrays.asList(1, 2, 3);
        List<Integer> actualCategories = WordDictionary.getCategories();
        assertEquals(expectedCategories, actualCategories);
    }
}