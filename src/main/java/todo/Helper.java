package todo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
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
            if (todoView.idLen() > todoLongestFieldLen.getIdLen()) {
                todoLongestFieldLen.setIdLen(todoView.idLen());
            }
            if (todoView.nameLen() > todoLongestFieldLen.getNameLen()) {
                todoLongestFieldLen.setNameLen(todoView.nameLen());
            }
            if (todoView.descriptionLen() > todoLongestFieldLen.getDescriptionLen()) {
                todoLongestFieldLen.setDescriptionLen(todoView.descriptionLen());
            }
            if (todoView.tabNameLen() > todoLongestFieldLen.getTabNameLen()) {
                todoLongestFieldLen.setTabNameLen(todoView.tabNameLen());
            }
        }

        return todoLongestFieldLen;
    }
}
