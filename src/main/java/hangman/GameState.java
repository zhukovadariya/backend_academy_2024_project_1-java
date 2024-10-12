package hangman;

import java.util.HashSet;
import java.util.Set;

public class GameState {
    protected String wordToGuess; // Загаданное слово
    protected StringBuilder currentGuess; // Текущее состояние слова
    protected Set<Character> guessedLetters; // Угаданные буквы
    protected int attemptsLeft; // Осталось попыток
    private String hint; // Подсказка

    // Конструктор состояния игры
    public GameState(int category, int level) {
        this.wordToGuess = WordDictionary.getRandomWord(category, level);
        this.currentGuess = new StringBuilder("_".repeat(wordToGuess.length()));
        this.guessedLetters = new HashSet<>();
        this.attemptsLeft = HangmanGame.MAX_ATTEMPTS;
        this.hint = HintProvider.getHint(category, level);
    }

    // Получение загаданного слова
    public String getWordToGuess() {
        return wordToGuess;
    }

    // Получение текущего состояния слова
    public String getCurrentGuess() {
        return currentGuess.toString();
    }

    // Получение множества угаданных букв
    public Set<Character> getGuessedLetters() {
        return guessedLetters;
    }

    // Получение оставшегося количества попыток
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    // Получение подсказки
    public String getHint() {
        return hint;
    }

    // Обновление состояния игры после ввода буквы
    public void update(char letter) {
        boolean found = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                currentGuess.setCharAt(i, letter);
                found = true;
            }
        }
        if (!found) {
            attemptsLeft--;
        }
        guessedLetters.add(letter);
    }

    // Проверка, закончилась ли игра
    public boolean isGameOver() {
        return attemptsLeft == 0 || !currentGuess.toString().contains("_");
    }
}
