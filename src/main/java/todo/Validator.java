package todo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;

public class Validator {
    private static final int NUM_OPTIONS = 8;
    private static final String ERROR_INVALID_OPTION = Theme.applyErrorBold("INVALID OPTION NUMBER!");
    private static final String ERROR_NULL_NAME = Theme.applyErrorBold("NAME NOT NULL!");
    private static final String ERROR_NOT_EXIST_TAB = Theme.applyErrorBold("NOT EXIST TAB NUMBER!");
    private static final String ERROR_DATEFORMAT = Theme.applyErrorBold("INVALID DATE FORMAT!");
    private static final String ERROR_DATE_PAST = Theme.applyErrorBold("NO PAST DATE!");
    private static final String ERROR_INVALID_TODONUM = Theme.applyErrorBold("INVALID TODO NUMBER!");
    private static final String ERROR_NOT_NUMBER = Theme.applyErrorBold("NOT NUMBER!");

    public static void validateOption(String option) {
        if (!option.matches(String.format("-1|\\d+"))) {
            throw new IllegalArgumentException(ERROR_INVALID_OPTION);
        }
        int num = Integer.parseInt(option);
        if (num < -1 || num > NUM_OPTIONS) {
            throw new IllegalArgumentException(ERROR_INVALID_OPTION);
        }
    }

    public static void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NULL_NAME);
        }
    }

    public static void validateTodoTabId(int tabId, HashMap<Integer, String> tabs) {
        if (tabId == Parser.TAB_NOT_SELECTE) {
            return;
        }

        if (tabs.get(tabId) == null) {
            throw new IllegalArgumentException(ERROR_NOT_EXIST_TAB);
        }
    }

    public static void validateTodoDeadline(String deadline) {
        if (deadline.isEmpty()) {
            return;
        }
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

    public static void validateTodoNum(String todoNum, int count) {
        if (!todoNum.matches(String.format("\\d+"))) {
            throw new IllegalArgumentException(ERROR_INVALID_TODONUM);
        }
        int num = Integer.parseInt(todoNum);
        if (num < 0 || num > count) {
            throw new IllegalArgumentException(ERROR_INVALID_TODONUM);
        }
    }

    public static void validateTabId(String s) {
        if (!s.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }

        if (s.equals("1")) {
            throw new IllegalArgumentException(ERROR_NOT_EXIST_TAB);
        }
    }
}
