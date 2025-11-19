package todo;

public class Todo {
    private int id;
    private String name;
    private String description;
    private int tabId;
    private String deadline;

    public Todo(String name, String description, int tabId, String deadline) {
        this.id = -1;
        this.name = name;
        this.description = description;
        this.tabId = tabId;
        this.deadline = deadline;
    }

    public Todo(int id, String name, String description, int tabId, String deadline) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tabId = tabId;
        this.deadline = deadline;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getTabId() {
        return this.tabId;
    }

    public String getDeadline() {
        return this.deadline;
    }
}
