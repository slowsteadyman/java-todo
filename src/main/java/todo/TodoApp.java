package todo;

import java.util.HashMap;

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
        }
    }

    private void createTodo() {
        String name = readNameUntilValid();
        String description = View.todoDescriptionInput();
        int tabId = readTabIdUntilValid();
    }

    private int readOptionUntilValid() {
        while (true) {
            try {
                String option = View.optionInput();
                Validator.validateOption(option);
                return Integer.parseInt(option);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String readNameUntilValid() {
        while (true) {
            try {
                String name = View.todoNameInput();
                Validator.validateTodoName(name);
                return name;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int readTabIdUntilValid() {
        HashMap<String, String> tabs = dbManager.readTab();
        while (true) {
            try {
                String tabId = View.todoTabIdInput(tabs);
                Validator.validateTodoTabId(tabId, tabs);
                return Parser.parseTabId(tabId);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
