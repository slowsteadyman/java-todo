package todo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class View {
    public static void printStartMessage() {
        System.out.println();
        System.out.printf("%s to simple todo app!\n", Theme.applyBold("Welcome"));
        System.out.printf("Enter %s to see options\n", Theme.applyMainBold("'0'"));
    }

    public static String readOption() {
        System.out.printf(Theme.applyMainBold("> "));
        return Helper.readLine();
    }

    public static void printOptions() {
        System.out.println("----------------------");
        System.out.println(Theme.applyMainBold("Option list"));
        System.out.println(Theme.applyBold("""
            1. create   todo
            2. read     todo
            3. update   todo
            4. delete   todo
            5. complete todo
            6. read completed todo
            7. create tab"""));
        System.out.println("""
            ----------------------
            -1. exit
            0. see options
            """);
    }

    public static String readTodoName() {
        System.out.printf(Theme.applyBold("Enter name: "));
        return Helper.readLine();
    }

    public static String readTodoDescription() {
        System.out.printf(Theme.applyBold("Enter description(optional): "));
        return Helper.readLine();
    }

    public static String readTodoTabIdForCreate(HashMap<Integer, String> tabs) {
        printTabs(tabs);
        System.out.printf(Theme.applyBold("Enter tab number(optional, default=2): "));
        return Helper.readLine();
    }

    public static void printTabs(HashMap<Integer, String> tabs) {
        System.out.println("----------------------");
        System.out.println(Theme.applyMainBold("current tabs"));
        for (Map.Entry<Integer, String> tab : tabs.entrySet()) {
            String text = String.format("%d. %s", tab.getKey(), tab.getValue());
            System.out.println(Theme.applyBold(text));
        }
        System.out.println("----------------------");
    }

    public static String readTodoDeadline() {
        System.out.printf(Theme.applyBold("Enter deadline(optional, format=yyyyMMdd): "));
        return Helper.readLine();
    }

    public static String readTodoTabIdForRead(HashMap<Integer, String> tabs) {
        printTabs(tabs);
        System.out.printf(Theme.applyBold("Enter tab number(optional, empty=ALL tabs): "));
        return Helper.readLine();
    }

    public static void printTodos(List<TodoView> todos) {
        int index = 1;
        TodoLongestFieldLen todoLongestFieldLen = Helper.findTodoLongestFieldLen(todos);

        printTodoField(todoLongestFieldLen);
        for (TodoView todoView : todos) {
            System.out.printf("%" + todoLongestFieldLen.getId() + "d ", index);
            System.out.printf("%-" + (todoLongestFieldLen.getName() - todoView.getNameHangulCount()) +
                "s ", todoView.getName());
            System.out.printf("%-" + (todoLongestFieldLen.getDescription() - todoView.getDescriptionHangulCount()) +
                "s ", todoView.getDescription());
            System.out.printf("%-10s ", Helper.toIsoLocalDate(todoView.getDeadline()));
            System.out.printf("%" + (todoLongestFieldLen.getTabName() - todoView.getTabNameHangulCount()) +
                "s\n", todoView.getTabName());
            index++;
        }
        System.out.println();
    }

    public static void printTodoField(TodoLongestFieldLen todoLongestFieldLen) {
        String id = String.format("%" + todoLongestFieldLen.getId() + "s ", "ID");
        String name = String.format("%-" + todoLongestFieldLen.getName() + "s ", "Name");
        String description = String.format("%-" + todoLongestFieldLen.getDescription() + "s ", "Description");
        String deadline = String.format("%-10s ", "Deadline");
        String tabName = String.format("%" + todoLongestFieldLen.getTabName() + "s\n", "TabName");

        System.out.printf(Theme.applyGrayUnderline(id));
        System.out.printf(Theme.applyGrayUnderline(name));
        System.out.printf(Theme.applyGrayUnderline(description));
        System.out.printf(Theme.applyGrayUnderline(deadline));
        System.out.printf(Theme.applyGrayUnderline(tabName));
    }

    public static String readTodoNum() {
        System.out.printf(Theme.applyBold("Enter Todo Number(0=cancel): "));
        return Helper.readLine();
    }

    public static String reaadAdjustedTodoName(TerminalManager terminalManager, String name) {
        System.out.printf(Theme.applyBold("Update name: "));
        return terminalManager.readLine(name);
    }

    public static String readTodoDescriptionForUpdate(TerminalManager terminalManager, String description) {
        System.out.printf(Theme.applyBold("Update description(optional): "));
        return terminalManager.readLine(description);
    }

    public static String readTodoTabIdForUpdate(TerminalManager terminalManager, int tabId,
                                                HashMap<Integer, String> tabs) {
        printTabs(tabs);
        System.out.printf(Theme.applyBold("Update tab number(optional, default=2): "));
        return terminalManager.readLine(String.format("%d", tabId));
    }

    public static String readTodoDeadlineForUpdate(TerminalManager terminalManager, String deadline) {
        System.out.printf(Theme.applyBold("Update deadline(optional, format=yyyyMMdd): "));
        return terminalManager.readLine(deadline);
    }

    public static void printSuccess(String task) {
        System.out.println(Theme.applySubmainBoldItalic(String.format("success %s", task)));
        System.out.println();
    }

    public static void printCurrentOption(String task) {
        System.out.println();
        System.out.println(Theme.applySkyblueBackBold(String.format("todo %s", task)));
    }
}
