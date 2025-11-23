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
        View.printStartMessage();

        while (true) {
            int option = readOptionUntilValid();
            switch (option) {
                case -1:
                    terminalManager.close();
                    return;
                case 0:
                    View.printOptions();
                    break;
                case 1:
                    createTodo();
                    break;
                case 2:
                    readTodo();
                    break;
                case 3:
                    updateTodo();
                    break;
                case 4:
                    deleteTodo();
                    break;
                case 5:
                    completeTodo();
                    break;
                case 6:
                    readTodoDone();
                    break;
                case 7:
                    createTab();
                    break;
                case 8:
                    updateTab();
                    break;
                case 9:
                    deleteTab();
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
        View.printCurrentOption("create");
        String name = readNameUntilValid();
        String description = View.readTodoDescription();
        int tabId = readTodoTabIdUntilValidForCreate();
        String deadline = readTodoDeadlineUntilValid();
        Todo todo = new Todo(name, description, tabId, deadline);

        dbManager.insertTodo(todo);
        View.printSuccess("create");
    }

    private String readNameUntilValid() {
        while (true) {
            try {
                String name = View.readTodoName();
                Validator.validateName(name);
                return name;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int readTodoTabIdUntilValidForCreate() {
        HashMap<Integer, String> tabs = dbManager.readTabsWithoutDone();
        while (true) {
            try {
                String tabId = View.readTodoTabIdForCreate(tabs);
                int parsedTabID = Parser.tabIdParser(tabId);
                Validator.validateTodoTabId(parsedTabID, tabs);
                return parsedTabID;
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
        View.printCurrentOption("read");
        int tabId = readTodoTabIdUntilValidForRead();
        List<TodoView> todos = dbManager.selectTodo(tabId);
        View.printTodos(todos);
    }

    private int readTodoTabIdUntilValidForRead() {
        HashMap<Integer, String> tabs = dbManager.readTabsWithoutDone();
        while (true) {
            try {
                String tabId = View.readTodoTabIdForRead(tabs);
                int parsedTabID = Parser.tabIdParser(tabId);
                Validator.validateTodoTabId(parsedTabID, tabs);
                return parsedTabID;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void updateTodo() {
        View.printCurrentOption("update");
        TodoView todoView = selectTodo();
        if (todoView == null) {
            return;
        }

        String name = readNameUntilValidForUpdate(todoView.getName());
        String description = View.readTodoDescriptionForUpdate(terminalManager, todoView.getDescription());
        int tabId = readTodoTabIdUntilValidForUpdate(todoView.getTabId());
        String deadline = readTodoDeadlineUntilValidForUpdate(todoView.getDeadline());
        Todo todo = new Todo(todoView.getId(), name, description, tabId, deadline);

        dbManager.updateTodo(todo);
        View.printSuccess("update");
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

    private String readNameUntilValidForUpdate(String name) {
        while (true) {
            try {
                String nameUpdated = View.reaadAdjustedName(terminalManager, name);
                Validator.validateName(nameUpdated);
                // terminal.flush();
                return nameUpdated;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int readTodoTabIdUntilValidForUpdate(int tabId) {
        HashMap<Integer, String> tabs = dbManager.readTabsWithoutDone();
        while (true) {
            try {
                String tabIdUpdated = View.readTodoTabIdForUpdate(terminalManager, tabId, tabs);
                int tabIdUpdatedNParsed = Parser.tabIdParser(tabIdUpdated);
                Validator.validateTodoTabId(tabIdUpdatedNParsed, tabs);
                return tabIdUpdatedNParsed;
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

    private void deleteTodo() {
        View.printCurrentOption("delete");
        TodoView todoView = selectTodo();
        if (todoView == null) {
            return;
        }
        int id = todoView.getId();
        dbManager.deleteTodo(id);
        View.printSuccess("delete");
    }

    private void completeTodo() {
        View.printCurrentOption("complete");
        TodoView todoView = selectTodo();
        if (todoView == null) {
            return;
        }
        dbManager.completeTodo(todoView.getId());
        View.printSuccess("complete");
    }

    private TodoView selectTodo() {
        List<TodoView> todos = dbManager.selectTodo(Parser.TAB_NOT_SELECTE);
        View.printTodos(todos);
        int todoNum = readTodoNumUntilValid(todos.size());
        if (todoNum == -1) {
            return null;
        }
        return todos.get(todoNum);
    }

    private void readTodoDone() {
        View.printCurrentOption("completed");
        List<TodoView> todos = dbManager.selectTodo(DbManager.DONE_TABID);
        View.printTodos(todos);
    }

    private void createTab() {
        String name = readNameUntilValid();
        Tab tab = new Tab(name);

        dbManager.insertTab(tab);
        View.printSuccess("create");
    }

    private void updateTab() {
        Tab tab = selectTab();
        if (tab == null) {
            return;
        }

        String name = readNameUntilValidForUpdate(tab.getName());
        tab.setName(name);
        dbManager.updateTab(tab);
    }

    private Tab selectTab() {
        HashMap<Integer, String> tabs = dbManager.readTabsWithoutDone();
        while (true) {
            try {
                String tabId = View.readTabIdForUpdate(tabs);
                Validator.validateTabId(tabId);
                int tabIdValid = Integer.parseInt(tabId);
                if (tabIdValid == 0) {
                    return null;
                }
                Tab tab = dbManager.selectTab(tabIdValid);
                if (tab != null) {
                    return tab;
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void deleteTab() {
        Tab tab = selectTab();
        if (tab == null) {
            return;
        }
        int id = tab.getId();
        dbManager.deleteTab(id);
    }
}
