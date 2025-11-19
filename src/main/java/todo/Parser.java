package todo;

public class Parser {
    public static final int TAB_NOT_SELECTE = -1;

    public static int tabIdParser(String tabId) {
        if (tabId.isEmpty()) {
            return TAB_NOT_SELECTE;
        }
        return Integer.parseInt(tabId);
    }
}
