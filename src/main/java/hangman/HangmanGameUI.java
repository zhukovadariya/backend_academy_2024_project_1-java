package hangman;

import java.io.PrintStream;

public class HangmanGameUI {

    protected void drawHangman(int stage, PrintStream out) {
         final int startStage = 6;
         final int headStage = 5;
         final int bodyStage = 4;
         final int leftArmStage = 3;
         final int rightArmStage = 2;
         final int leftLegStage = 1;
         final int rightLegStage = 0;

        switch (stage) {
            case startStage:
                out.println("""
                                       ----
                                       |  |
                                          |
                                          |
                                          |
                                          |""");
                break;
            case headStage:
                out.println("""
                                    ----
                                    |  |
                                    O  |
                                       |
                                       |
                                       |""");
                break;
            case bodyStage:
                out.println("""
                                       ----
                                       |  |
                                       O  |
                                       |  |
                                          |
                                          |""");
                break;
            case leftArmStage:
                out.println("""
                                       ----
                                       |  |
                                       O  |
                                      /|  |
                                          |
                                          |""");
                break;
            case rightArmStage:
                out.println("""
                                       ----
                                       |  |
                                       O  |
                                      /|\\ |
                                          |
                                          |""");
                break;
            case leftLegStage:
                out.println("""
                                       ----
                                       |  |
                                       O  |
                                      /|\\ |
                                      /   |
                                          |""");
                break;
            case rightLegStage:
                out.println("""
                                       ----
                                       |  |
                                       O  |
                                      /|\\ |
                                      / \\ |
                                          |""");
                break;
            default:
                out.println("Неверный этап виселицы");
                break;
        }
    }
}
