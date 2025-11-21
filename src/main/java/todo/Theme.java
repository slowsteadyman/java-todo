package todo;

public class Theme {
    private static final int CYAN = 36;
    private static final int BRIGHT_CYAN = 96;
    private static final int MAGENTA = 35;
    private static final int GRAY = 90;
    private static final int BRIGHT_BLUE_BACKGROUND = 44;
    private static final int SKYBLUE_BACKGROUND = 75;
    private static final int BOLD = 1;
    private static final int ITALIC = 3;
    private static final int UNDERLINE = 4;
    private static final String RESET = "\u001B[0m";

    public static String applyMainBold(String text) {
        String prefix = String.format("\u001B[%d;%dm", CYAN, BOLD);
        return String.format("%s%s%s", prefix, text, RESET);
    }

    public static String applyErrorBold(String text) {
        String prefix = String.format("\u001B[%d;%dm", MAGENTA, BOLD);
        return String.format("%s%s%s", prefix, text, RESET);
    }

    public static String applyBold(String text) {
        String prefix = String.format("\u001B[%dm", BOLD);
        return String.format("%s%s%s", prefix, text, RESET);
    }

    public static String applySubmainBoldItalic(String text) {
        String prefix = String.format("\u001B[%d;%d;%dm", BOLD, ITALIC, BRIGHT_CYAN);
        return String.format("%s%s%s", prefix, text, RESET);
    }

    public static String applyGrayUnderline(String text) {
        String prefix = String.format("\u001B[%d;%dm", UNDERLINE, GRAY);
        return String.format("%s%s%s", prefix, text, RESET);
    }

    public static String applyBrightBlueBackBold(String text) {
        String prefix = String.format("\u001B[%d;%dm", BRIGHT_BLUE_BACKGROUND, BOLD);
        return String.format("%s%s%s", prefix, text, RESET);
    }

    public static String applySkyblueBackBold(String text) {
        String prefix = String.format("\u001B[48;5;%d;%dm", SKYBLUE_BACKGROUND, BOLD);
        return String.format("%s%s%s", prefix, text, RESET);
    }
}
