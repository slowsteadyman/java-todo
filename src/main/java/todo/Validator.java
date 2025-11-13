package todo;

public class Validator {
    private static final String ERROR_INVALID_OPTION = "1,2,3,4 중 하나를 선택해 주시기 바랍니다.";

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
}
