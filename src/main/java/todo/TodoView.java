package todo;

public class TodoView {
    private int id;
    private String name;
    private String description;
    private String deadline;
    private int tabId;
    private String tabName;

    public TodoView(int id, String name, String description, String deadline, int tabId, String tabName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.tabId = tabId;
        this.tabName = tabName;
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

    public String getDeadline() {
        return this.deadline;
    }

    public int getTabId() {
        return this.tabId;
    }

    public String getTabName() {
        return this.tabName;
    }
}
