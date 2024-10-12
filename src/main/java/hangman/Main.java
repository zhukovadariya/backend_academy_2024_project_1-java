package hangman;

import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        PrintStream out = System.out;
        int category = InputHandler.chooseCategory(scanner, out);
        int level = InputHandler.chooseLevel(scanner, out);
        HangmanGame game = new HangmanGame(category, level, out);
        game.play();
    }
}

