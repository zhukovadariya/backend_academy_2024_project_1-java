package hangman;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameStateTest {
    @Test
    void update_shouldUpdateGameStateCorrectlyForCorrectLetter() {
        GameState gameState = new GameState(1, 1);
        gameState.attemptsLeft = 6;
        String wordToGuess = "окно";
        gameState.wordToGuess = wordToGuess;

        gameState.update('о');

        assertEquals(6, gameState.getAttemptsLeft());
        assertTrue(gameState.getGuessedLetters().contains('о'));

        StringBuilder expectedGuess = new StringBuilder("_".repeat(wordToGuess.length()));
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == 'о') {
                expectedGuess.setCharAt(i, 'о');
            }
        }
        assertEquals(expectedGuess.toString(), gameState.getCurrentGuess());
    }

    @Test
    void update_shouldUpdateGameStateCorrectlyForIncorrectLetter() {
        GameState gameState = new GameState(1, 1);
        gameState.attemptsLeft = 6;
        String wordToGuess = "окно";
        gameState.wordToGuess = wordToGuess;

        gameState.update('а');

        assertEquals(5, gameState.getAttemptsLeft());
        assertTrue(gameState.getGuessedLetters().contains('а'));
        assertEquals(wordToGuess.length(), gameState.getCurrentGuess().length());
        assertEquals("_".repeat(wordToGuess.length()), gameState.getCurrentGuess());
    }

    @Test
    void isGameOver_shouldReturnTrueWhenGameIsOver() {
        GameState gameState = new GameState(1, 2);
        gameState.attemptsLeft = 0;
        assertTrue(gameState.isGameOver());
    }

    @Test
    void isGameOver_shouldReturnFalseWhenGameIsNotOver() {
        GameState gameState = new GameState(1, 2);
        gameState.attemptsLeft = 4;
        assertFalse(gameState.isGameOver());
    }
}