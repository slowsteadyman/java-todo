package todo;

public class Tab {
    private int id;
    private String name;

    public Tab(String name) {
        this.id = -1;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
