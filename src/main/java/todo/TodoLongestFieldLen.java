package todo;

public class TodoLongestFieldLen {
    private int id;
    private int name;
    private int description;
    private int tabName;

    public TodoLongestFieldLen() {
        this.id = "id".length();
        this.name = "name".length();
        this.description = "description".length();
        this.tabName = "tabName".length();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int len) {
        this.id = len;
    }

    public int getName() {
        return this.name;
    }

    public void setName(int len) {
        this.name = len;
    }

    public int getDescription() {
        return this.description;
    }

    public void setDescription(int len) {
        this.description = len;
    }

    public int getTabName() {
        return this.tabName;
    }

    public void setTabName(int len) {
        this.tabName = len;
    }
}
