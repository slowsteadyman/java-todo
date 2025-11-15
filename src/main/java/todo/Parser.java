package todo;

public class Parser {
    private static final int TABID_MISCELLANEOUS = 2;

    public static int parseTabId(String tabId) {
        if (tabId.isEmpty()) {
            return TABID_MISCELLANEOUS;
        }
        return Integer.parseInt(tabId);
    }
}
