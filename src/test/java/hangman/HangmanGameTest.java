package hangman;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HangmanGameTest {
    @Test
    void guessedLettersShouldHandleDifferentCase() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        String wordToGuess = "стол";
        HangmanGame game = new HangmanGame(1, 1, printStream);
        game.gameState.wordToGuess = wordToGuess;
        game.gameState.currentGuess = new StringBuilder("_".repeat(wordToGuess.length()));
        game.gameState.attemptsLeft = 1;

        String input = "A";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        game.play();

        assertFalse(game.gameState.guessedLetters.contains('A'));
        assertTrue(game.gameState.guessedLetters.contains('a'));
    }
}