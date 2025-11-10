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
        "INSERT INTO tabs VALUES" +
            "(1, 'done')," +
            "(2, 'miscellaneous')" +
            ";";
}
