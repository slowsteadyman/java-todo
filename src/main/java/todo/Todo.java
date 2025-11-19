package todo;

public class Todo {
    private String id;
    private String name;
    private String description;
    private String tabId;
    private String deadline;

    public Todo(String name, String description, String tabId, String deadline) {
        this.id = "";
        this.name = name;
        this.description = description;
        this.tabId = tabId;
        this.deadline = deadline;
    }

    public Todo(String id, String name, String description, String tabId, String deadline) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tabId = tabId;
        this.deadline = deadline;
    }

    public String getId() {
        return this.id;
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
