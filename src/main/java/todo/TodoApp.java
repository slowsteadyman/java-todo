package todo;

public class TodoApp {
    public void run() {
        DbManager dbManager = new DbManager();
        dbManager.configureDefaultEnvironment();
    }
}
