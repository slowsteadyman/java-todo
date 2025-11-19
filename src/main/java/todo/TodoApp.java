package todo;

import java.util.HashMap;
import java.util.List;

public class TodoApp {
    private DbManager dbManager;
    private TerminalManager terminalManager;

    public TodoApp(DbManager dbManager, TerminalManager terminalManager) {
        this.dbManager = dbManager;
        this.terminalManager = terminalManager;
    }

    public void run() {
        dbManager.configureDefaultEnvironment();

        while (true) {
            int option = readOptionUntilValid();
            switch (option) {
                case 0:
                    terminalManager.close();
                    return;
                case 1:
                    createTodo();
                    break;
                case 2:
                    readTodo();
                    break;
                case 3:
                    updateTodo();
                default:
                    break;
            }
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
        return readTodoTabIdUntilValid(
            "탭 번호를 입력해 주시기 바랍니다. 입력하지 않을 경우 '잡동사니 서랍' 탭으로 자동 분류됩니다."
        );
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

    private void updateTodo() {
        List<TodoView> todos = dbManager.selectTodo("");
        View.printTodos(todos);
        int todoNum = readTodoNumUntilValid(todos.size());
        TodoView todoView = todos.get(todoNum);

        String name = readTodoNameUntilValidForUpdate(todoView.getName());
        String description = View.readTodoDescriptionForUpdate(terminalManager, todoView.getDescription());
        String tabId = readTodoTabIdUntilValidForUpdate(todoView.getTabId());
        String deadline = readTodoDeadlineUntilValidForUpdate(todoView.getDeadline());
        Todo todo = new Todo(todoView.getId(), name, description, tabId, deadline);

        dbManager.updateTodo(todo);
    }

    private int readTodoNumUntilValid(int count) {
        while (true) {
            try {
                String todoNum = View.readTodoNum();
                Validator.validateTodoNum(todoNum, count);
                return Integer.parseInt(todoNum) - 1;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String readTodoNameUntilValidForUpdate(String name) {
        while (true) {
            try {
                String nameUpdated = View.reaadAdjustedTodoName(terminalManager, name);
                Validator.validateTodoName(nameUpdated);
                // terminal.flush();
                return nameUpdated;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String readTodoTabIdUntilValidForUpdate(String tabId) {
        HashMap<String, String> tabs = dbManager.readTabsWithoutDone();
        while (true) {
            try {
                String tabIdUpdated = View.readTodoTabIdForUpdate(terminalManager, tabId, tabs);
                Validator.validateTodoTabId(tabIdUpdated, tabs);
                return tabIdUpdated;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String readTodoDeadlineUntilValidForUpdate(String deadline) {
        while (true) {
            try {
                String deadlineUpdated = View.readTodoDeadlineForUpdate(terminalManager, deadline);
                Validator.validateTodoDeadline(deadlineUpdated);
                return deadlineUpdated;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
