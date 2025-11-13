package todo;

public class Application {
    public static void main(String[] args) {
        DbManager dbManager = new DbManager();
        TodoApp todoApp = new TodoApp(dbManager);
        todoApp.run();
    }
}
