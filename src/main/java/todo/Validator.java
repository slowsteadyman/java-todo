package todo;

import java.util.function.Function;

public class Validator {
    private static final String ERROR_INVALID_OPTION = "1,2,3,4 중 하나를 선택해 주시기 바랍니다.";
    private static final String ERROR_NULL_NAME = "할 일을 입력해 주시기 바랍니다.";

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
}
