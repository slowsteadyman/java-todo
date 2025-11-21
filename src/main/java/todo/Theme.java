package todo;

public class Theme {
    private static final String CYAN = "\u001B[36m";
    private static final String BRIGHT_CYAN = "\u001B[96m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String GRAY = "\u001B[90m";
    private static final String SKYBLUE_BACKGROUND = "\u001B[48;5;75m";
    private static final String BOLD = "\u001B[1m";
    private static final String ITALIC = "\u001B[3m";
    private static final String UNDERLINE = "\u001B[4m";
    private static final String RESET = "\u001B[0m";

    public static String applyMainBold(String text) {
        return CYAN + BOLD + text + RESET;
    }

    public static String applyErrorBold(String text) {
        return MAGENTA + BOLD + text + RESET;
    }

    public static String applyBold(String text) {
        return BOLD + text + RESET;
    }

    public static String applySubmainBoldItalic(String text) {
        return BRIGHT_CYAN + BOLD + ITALIC + text + RESET;
    }

    public static String applyGrayUnderline(String text) {
        return GRAY + UNDERLINE + text + RESET;
    }

    public static String applySkyblueBackBold(String text) {
        return SKYBLUE_BACKGROUND + BOLD + text + RESET;
    }
}
