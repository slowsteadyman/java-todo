package todo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class Helper {
    public static String readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String toIsoLocalDate(String basicIsoDate) {
        LocalDate localDate = LocalDate.parse(basicIsoDate, DateTimeFormatter.BASIC_ISO_DATE);
        return localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static Terminal terminalBuilder() {
        try {
            return TerminalBuilder.builder().system(true).build();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static TodoLongestFieldLen findTodoLongestFieldLen(List<TodoView> todos) {
        TodoLongestFieldLen todoLongestFieldLen = new TodoLongestFieldLen();

        for (TodoView todoView : todos) {
            if (todoView.idLen() > todoLongestFieldLen.getId()) {
                todoLongestFieldLen.setId(todoView.idLen());
            }
            if (todoView.getNameLen() > todoLongestFieldLen.getName()) {
                todoLongestFieldLen.setName(todoView.getNameLen());
            }
            if (todoView.getDescriptionLen() > todoLongestFieldLen.getDescription()) {
                todoLongestFieldLen.setDescription(todoView.getDescriptionLen());
            }
            if (todoView.getTabNameLen() > todoLongestFieldLen.getTabName()) {
                todoLongestFieldLen.setTabName(todoView.getTabNameLen());
            }
        }

        return todoLongestFieldLen;
    }

    public static int hangulCount(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= '\uAC00' && c <= '\uD7A3') || (c >= '\u3130' && c <= '\u318F')) {
                count++;
            }
        }
        return count;
    }
}
