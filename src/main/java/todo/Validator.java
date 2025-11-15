package todo;

import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class Validator {
    private static final String ERROR_INVALID_OPTION = "1,2,3,4 중 하나를 선택해 주시기 바랍니다.";
    private static final String ERROR_NULL_NAME = "할 일을 입력해 주시기 바랍니다.";
    private static final String ERROR_NOT_EXIST_TAB = "존재하지 않는 탭 번호입니다.";

    public static void validateOption(String option) {
        if (!option.matches("[1-4]")) {
            throw new IllegalArgumentException(ERROR_INVALID_OPTION);
        }
    }

    public static void validateTodoName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NULL_NAME);
        }
    }

    /*
    public static BiConsumer<String, HashMap<String, String>> validateTodoTabId = (tab, tabs) -> {
        if (tab.isEmpty()) {
            return;
        }

        if (tabs.get(tab) == null) {
            throw new IllegalArgumentException(ERROR_NOT_EXIST_TAB);
        }
    };
     */
    public static void validateTodoTabId(String tabId, HashMap<String, String> tabs) {
        if (!tabId.isEmpty()) {
            if (tabs.get(tabId) == null) {
                throw new IllegalArgumentException(ERROR_NOT_EXIST_TAB);
            }
        }
    }
}
