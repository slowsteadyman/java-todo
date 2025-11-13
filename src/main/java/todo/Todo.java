package todo;

public class Todo {
    private int id;
    private String name;
    private String description;
    private int tabId;
    private String deadline;

    public Todo(int id, String name, String description, int tabId, String deadline) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tabId = tabId;
        this.deadline = deadline;
    }
}
