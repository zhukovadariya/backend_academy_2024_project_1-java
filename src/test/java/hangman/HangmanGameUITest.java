package hangman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HangmanGameUITest {
    private HangmanGameUI hangmanGameUI;
    private ByteArrayOutputStream outputStream;
    private PrintStream printStream;

    @BeforeEach
    public void setUp() {
        hangmanGameUI = new HangmanGameUI();
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
    }


    @Test
    void drawHangmanStage6() {
        hangmanGameUI.drawHangman(6, printStream);
        String expectedOutput = """
                                       ----
                                       |  |
                                          |
                                          |
                                          |
                                          |""";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    void drawHangmanStage5() {
        hangmanGameUI.drawHangman(5, printStream);
        String expectedOutput = """
                                    ----
                                    |  |
                                    O  |
                                       |
                                       |
                                       |""";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    void drawHangmanStage4() {
        hangmanGameUI.drawHangman(4, printStream);
        String expectedOutput = """
                                    ----
                                    |  |
                                    O  |
                                    |  |
                                       |
                                       |""";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    void drawHangmanStage3() {
        hangmanGameUI.drawHangman(3, printStream);
        String expectedOutput = """
                                    ----
                                     |  |
                                     O  |
                                    /|  |
                                        |
                                        |""";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    void drawHangmanStage2() {
        hangmanGameUI.drawHangman(2, printStream);
        String expectedOutput = """
                                    ----
                                     |  |
                                     O  |
                                    /|\\ |
                                        |
                                        |""";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    void drawHangmanStage1() {
        hangmanGameUI.drawHangman(1, printStream);
        String expectedOutput = """
                                    ----
                                     |  |
                                     O  |
                                    /|\\ |
                                    /   |
                                        |""";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    void drawHangmanStage0() {
        hangmanGameUI.drawHangman(0, printStream);
        String expectedOutput = """
                                    ----
                                     |  |
                                     O  |
                                    /|\\ |
                                    / \\ |
                                        |""";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }
}
