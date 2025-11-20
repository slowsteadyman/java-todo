package todo;

public class SqlQueries {
    public static final String CREATE_TABLE_TABS =
        "CREATE TABLE IF NOT EXISTS tabs (" +
            "id   INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL" +
            ");";

    public static final String CREATE_TABLE_TODOS =
        "CREATE TABLE IF NOT EXISTS todos (" +
            "id          INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name        TEXT NOT NULL," +
            "description TEXT," +
            "tabid       INTEGER," +
            "deadline    TEXT," +
            "FOREIGN KEY (tabid) REFERENCES tabs(id)" +
            ");";

    public static final String INSERT_DEFAULT_TABS =
        "INSERT OR IGNORE INTO tabs VALUES" +
            "(1, 'done')," +
            "(2, 'miscellaneous')" +
            ";";

    public static final String READ_TABS_WITHOUT_DONE =
        "SELECT * FROM tabs "
        + "WHERE id <> 1;";

    public static final String INSERT_TODO =
        "INSERT INTO todos (name, description, tabId, deadline) VALUES (?, ?, ?, ?);";

    public static final String SELECT_ALL_TODOS =
        "SELECT td.id, td.name, description, deadline, tb.id, tb.name "
            + "FROM todos td "
            + "JOIN tabs tb ON td.tabid = tb.id "
            + "WHERE td.tabid <> 1;";

    public static final String SELECT_SPECIFIC_TODOS =
        "SELECT td.id, td.name, description, deadline, tb.id, tb.name "
            + "FROM todos td "
            + "JOIN tabs tb ON td.tabid = tb.id "
            + "WHERE td.tabid = ?;";

    public static final String UPDATE_TODO =
        "UPDATE todos SET "
            + "name = ?,"
            + "description = ?,"
            + "tabId = ?,"
            + "deadline = ? "
            + "WHERE id = ?;";

    public static final String DELETE_TODO =
        "DELETE FROM todos WHERE id = ?;";

    public static final String COMPLETE_TODO =
        "UPDATE todos SET "
            + "tabId = 1 "
            + "WHERE id = ?;";
}
