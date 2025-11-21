package todo;

public class Theme {
    private static final int MAIN_COLOR = 36;
    private static final int SUBMAIN_COLOR = 96;
    private static final int ERROR_COLOR = 35;
    private static final int GRAY = 90;
    private static final int BOLD = 1;
    private static final int ITALIC = 3;
    private static final String RESET = "\u001B[0m";

    public static String applyMainBold(String text) {
        String prefix = String.format("\u001B[%d;%dm", MAIN_COLOR, BOLD);
        return String.format("%s%s%s", prefix, text, RESET);
    }

    public static String applyErrorBold(String text) {
        String prefix = String.format("\u001B[%d;%dm", ERROR_COLOR, BOLD);
        return String.format("%s%s%s", prefix, text, RESET);
    }

    public static String applyBold(String text) {
        String prefix = String.format("\u001B[%dm", BOLD);
        return String.format("%s%s%s", prefix, text, RESET);
    }

    public static String applySubmainBoldItalic(String text) {
        String prefix = String.format("\u001B[%d;%d;%dm", BOLD, ITALIC, SUBMAIN_COLOR);
        return String.format("%s%s%s", prefix, text, RESET);
    }

    public static String applyGray(String text) {
        String prefix = String.format("\u001B[%dm", GRAY);
        return String.format("%s%s%s", prefix, text, RESET);
    }
}
