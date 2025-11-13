package todo;

public class Application {
    public static void main(String[] args) {
        DbManager dbManager = new DbManager();
        View view = new View();
        TodoApp todoApp = new TodoApp(dbManager, view);
        todoApp.run();
    }
}
