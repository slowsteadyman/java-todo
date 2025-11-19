package todo;

public class TodoView {
    private String id;
    private String name;
    private String description;
    private String deadline;
    private String tabId;
    private String tabName;

    public TodoView(String id, String name, String description, String deadline, String tabId, String tabName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.tabId = tabId;
        this.tabName = tabName;
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

    public String getDeadline() {
        return this.deadline;
    }

    public String getTabId() {
        return this.tabId;
    }

    public String getTabName() {
        return this.tabName;
    }
}
