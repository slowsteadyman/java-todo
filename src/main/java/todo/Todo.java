package todo;

public class Todo {
    private String name;
    private String description;
    private String tabId;
    private String deadline;

    public Todo(String name, String description, String tabId, String deadline) {
        this.name = name;
        this.description = description;
        this.tabId = tabId;
        this.deadline = deadline;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTabId() {
        return this.tabId;
    }

    public String getDeadline() {
        return this.deadline;
    }
}
