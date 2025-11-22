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

    public int idLen() {
        return Integer.toString(this.id).length();
    }

    public int getNameHangulCount() {
        return Helper.hangulCount(this.name);
    }

    public int getNameLen() {
        return this.name.length() + this.getNameHangulCount();
    }

    public int getDescriptionHangulCount() {
        return Helper.hangulCount(this.description);
    }

    public int getDescriptionLen() {
        return this.description.length() + this.getDescriptionHangulCount();
    }

    public int getTabNameHangulCount() {
        return Helper.hangulCount(this.tabName);
    }

    public int getTabNameLen() {
        return this.tabName.length() + this.getTabNameHangulCount();
    }
}