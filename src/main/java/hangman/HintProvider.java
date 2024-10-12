package hangman;

public class HintProvider {

    public static String getHint(int category, int level) {
        final int category1 = 1;
        final int category2 = 2;
        final int category3 = 3;
        final int level1 = 1;
        final int level2 = 2;
        final int level3 = 3;
        return switch (category) {
            case category1 -> switch (level) {
                case level1 -> "Это что-то, что есть в каждой комнате.";
                case level2 -> "Это что-то, что может быть как большим, так и маленьким.";
                case level3 -> "Это что-то, что делает ваш дом уютным.";
                default -> "";
            };
            case category2 -> switch (level) {
                case level1 -> "Это что-то, что связано с компьютерами.";
                case level2 -> "Это что-то, что помогает писать программы.";
                case level3 -> "Это что-то, что делает код более сложным, но и более мощным.";
                default -> "";
            };
            case category3 -> switch (level) {
                case level1 -> "Это что-то, что цветет и пахнет.";
                case level2 -> "Это что-то, что может быть как полевым, так и садовым.";
                case level3 -> "Это что-то, что может иметь необычное название.";
                default -> "";
            };
            default -> "";
        };
    }
}
