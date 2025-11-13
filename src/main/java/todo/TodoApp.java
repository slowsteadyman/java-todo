package todo;

public class TodoApp {
    private DbManager dbManager;

    public TodoApp(DbManager dbManager) {
        this.dbManager = dbManager;
    }

    public void run() {
        dbManager.configureDefaultEnvironment();

        int option = Validator.validateOption(View.chooseOption());
        switch (option) {
            case 1:
                createTodo();
        }
    }

    private void createTodo() {
        String name = Helper.repeatUntilValid(View.todoNameInput, Validator.validateTodoName);
        String description = View.todoDescriptionInput();
    }
}
