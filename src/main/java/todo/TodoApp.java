package todo;

import java.util.HashMap;
import java.util.List;

public class TodoApp {
    private DbManager dbManager;

    public TodoApp(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void run() {
        dbManager.configureDefaultEnvironment();

        int option = readOptionUntilValid();
        switch (option) {
            case 1:
                createTodo();
                break;
            case 2:
                readTodo();
                break;
        }
    }

    private int readOptionUntilValid() {
        while (true) {
            try {
                String option = View.readOption();
                Validator.validateOption(option);
                return Integer.parseInt(option);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void createTodo() {
        String name = readTodoNameUntilValid();
        String description = View.readTodoDescription();
        String tabId = readTodoTabIdUntilValidForCreate();
        String deadline = readTodoDeadlineUntilValid();
        Todo todo = new Todo(name, description, tabId, deadline);

        dbManager.insertTodo(todo);
    }

    private String readTodoNameUntilValid() {
        while (true) {
            try {
                String name = View.readTodoName();
                Validator.validateTodoName(name);
                return name;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String readTodoTabIdUntilValidForCreate() {
        String message = "탭 번호를 입력해 주시기 바랍니다. 입력하지 않을 경우 '잡동사니 서랍' 탭으로 자동 분류됩니다.";
        HashMap<String, String> tabs = dbManager.readTabsWithoutDone();
        while (true) {
            try {
                String tabId = View.readTodoTabId(message, tabs);
                Validator.validateTodoTabId(tabId, tabs);
                return tabId;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String readTodoDeadlineUntilValid() {
        while (true) {
            try {
                String deadline = View.readTodoDeadline();
                Validator.validateTodoDeadline(deadline);
                return deadline;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void readTodo() {
        String tabId = readTodoTabIdUntilValidForRead();
        List<TodoView> todos = dbManager.selectTodo(tabId);
        View.printTodos(todos);
    }

    private String readTodoTabIdUntilValidForRead() {
        return readTodoTabIdUntilValid(
            "탭 번호를 입력해 주시기 바랍니다. 입력하지 않을 경우 전체 목록을 조회합니다."
        );
    }

    private String readTodoTabIdUntilValid(String message) {
        HashMap<String, String> tabs = dbManager.readTabsWithoutDone();
        while (true) {
            try {
                String tabId = View.readTodoTabId(message, tabs);
                Validator.validateTodoTabId(tabId, tabs);
                return tabId;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
