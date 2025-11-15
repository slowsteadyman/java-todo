package todo;

import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class Validator {
    private static final String ERROR_INVALID_OPTION = "1,2,3,4 중 하나를 선택해 주시기 바랍니다.";
    private static final String ERROR_NULL_NAME = "할 일을 입력해 주시기 바랍니다.";
    private static final String ERROR_NOT_EXIST_TAB = "존재하지 않는 탭 번호입니다.";

    public static int validateOption(String option) {
        int validatedOption;
        try {
            validatedOption = Integer.parseInt(option);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_OPTION);
        }
        if (validatedOption < 1 || validatedOption > 4) {
            throw new IllegalArgumentException(ERROR_INVALID_OPTION);
        }
        return validatedOption;
    }

    public static Function<String, String> validateTodoName = name -> {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NULL_NAME);
        }
        return name;
    };

    public static BiConsumer<String, HashMap<String, String>> validateTodoTabId = (tab, tabs) -> {
        if (tab.isEmpty()) {
            return;
        }

        if (tabs.get(tab) == null) {
            throw new IllegalArgumentException(ERROR_NOT_EXIST_TAB);
        }
    };
}
