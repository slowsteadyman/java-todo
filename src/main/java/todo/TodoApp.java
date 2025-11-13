package todo;

public class TodoApp {
    private DbManager dbManager;
    private View view;

    public TodoApp(DbManager dbManager, View view) {
        this.dbManager = dbManager;
        this.view = view;
    }

    public void run() {
        dbManager.configureDefaultEnvironment();

        int option = Validator.validateOption(view.chooseOption());

    }
}
