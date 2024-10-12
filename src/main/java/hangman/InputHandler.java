package hangman;

import java.io.PrintStream;
import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
    private static final SecureRandom random = new SecureRandom();

    public static int chooseCategory(Scanner scanner, PrintStream out) {
        while (true) {
//            out.println("Доступные категории:");
//            for (int category : WordDictionary.getCategories()) {
//                out.println("- " + category);
//            }
            out.print("Выберите категорию (1 - дом, 2 - программирование, 3 - растения): ");
            try {
                int category = scanner.nextInt();
                if (WordDictionary.getCategories().contains(category)) {
                    scanner.nextLine();
                    return category;
                }
                else {
                    out.println("Введен некорректный номер, будет выбрана случайная категория.");
                    return random.nextInt(WordDictionary.getCategories().size()) + 1;
                }
            } catch (InputMismatchException e) {
                out.println("Ошибка: введите число.");
                scanner.next();
//                return random.nextInt(WordDictionary.getCategories().size()) + 1;
            }
        }
    }

    public static int chooseLevel(Scanner scanner, PrintStream out) {
        while (true) {
            out.print("Выберите уровень сложности (1-3): ");
            try {
                final int minLevel = 1;
                final int maxLevel = 3;
                int level = scanner.nextInt();
                if (level >= minLevel && level <= maxLevel) {
                    scanner.nextLine();
                    return level;
                } else {
                    out.println("Введен некорректный номер, будет выбран случайный уровень сложности.");
                    return random.nextInt(3) + 1; // Рандомный выбор
                }
            } catch (InputMismatchException e) {
                out.println("Ошибка: введите число.");
                scanner.next();
//                return random.nextInt(3) + 1; // Рандомный выбор
            }
        }
    }
}