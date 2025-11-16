package todo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashMap;

public class Validator {
    private static final String ERROR_INVALID_OPTION = "1,2,3,4 중 하나를 선택해 주시기 바랍니다.";
    private static final String ERROR_NULL_NAME = "할 일을 입력해 주시기 바랍니다.";
    private static final String ERROR_NOT_EXIST_TAB = "존재하지 않는 탭 번호입니다.";
    private static final String ERROR_DATEFORMAT = "유요하지 않은 날짜 형식입니다.";
    private static final String ERROR_DATE_PAST = "오늘 또는 이후의 날짜를 입력해 주시기 바랍니다.";


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

    public static void validateTodoTabId(String tabId, HashMap<String, String> tabs) {
        if (!tabId.isEmpty()) {
            if (tabs.get(tabId) == null) {
                throw new IllegalArgumentException(ERROR_NOT_EXIST_TAB);
            }
        }
    }

    public static void validateTodoDeadline(String deadline) {
        try {
            LocalDate now = LocalDate.now();
            LocalDate parsedDeadline = LocalDate.parse(deadline, DateTimeFormatter.BASIC_ISO_DATE);
            if (parsedDeadline.isBefore(now)) {
                throw new IllegalArgumentException(ERROR_DATE_PAST);
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(ERROR_DATEFORMAT);
        }
    }
}
