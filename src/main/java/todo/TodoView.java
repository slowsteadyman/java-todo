package todo;

public class TodoView {
    private String name;
    private String description;
    private String deadline;
    private String tabName;

    public TodoView(String name, String description, String deadline, String tabName) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.tabName = tabName;
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

    public String getTabName() {
        return this.tabName;
    }
}
