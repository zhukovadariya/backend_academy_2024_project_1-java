package hangman;

import java.io.PrintStream;
import java.util.Scanner;

public class HangmanGame {
    public static final int MAX_ATTEMPTS = 6;
    protected final GameState gameState;
    protected final PrintStream out;
    protected final HangmanGameUI hangmanGameUI;

    public HangmanGame(int category, int level, PrintStream out) {
        this.out = out;
        this.gameState = new GameState(category, level);
        this.hangmanGameUI = new HangmanGameUI();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (!gameState.isGameOver()) {
            displayState();
            if (gameState.getAttemptsLeft() == 1) {
                out.println("Подсказка: " + gameState.getHint());
            }
            out.print("Введите букву: ");
            String input = scanner.nextLine().trim().toLowerCase();

            // Обработка введенной буквы
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                out.println("Некорректный ввод. Пожалуйста, введите одну букву.");
                continue;
            }
            char letter = input.charAt(0);

            // Проверка, была ли уже введена эта буква
            if (gameState.getGuessedLetters().contains(letter)) {
                out.println("Эта буква уже была введена.");
                continue;
            }

            // Обновление состояния игры
            gameState.update(letter);
            hangmanGameUI.drawHangman(gameState.getAttemptsLeft(), out);

        }

        // Окончание игры
        if (gameState.getCurrentGuess().equals(gameState.getWordToGuess())) {
            out.println("Поздравляем! Вы угадали слово: " + gameState.getWordToGuess());
        } else {
            out.println("Вы проиграли. Загаданное слово было: " + gameState.getWordToGuess());
        }
        scanner.close();
    }

    // Отображение текущего состояния игры
    private void displayState() {
        out.println("Текущее слово: " + gameState.getCurrentGuess());
        out.println("Введенные буквы: " + gameState.getGuessedLetters());
        out.println("Осталось попыток: " + gameState.getAttemptsLeft());
    }
}