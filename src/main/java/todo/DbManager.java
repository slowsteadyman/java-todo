package todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DbManager {
    private static final String dbUrl = "jdbc:sqlite:todo.db";

    public void configureDefaultEnvironment() {
        this.createDefaultTable();
        this.insertDefaultTabs();
    }

    private void createDefaultTable() {
        try (
            Connection connection = DriverManager.getConnection(dbUrl);
            Statement statement = connection.createStatement();
        ) {
            statement.setQueryTimeout(30);
            statement.executeUpdate(SqlQueries.CREATE_TABLE_TABS);
            statement.executeUpdate(SqlQueries.CREATE_TABLE_TODOS);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    private void insertDefaultTabs() {
        try (
            Connection connection = DriverManager.getConnection(dbUrl);
            Statement statement = connection.createStatement();
        ) {
            statement.setQueryTimeout(30);
            statement.executeUpdate(SqlQueries.INSERT_DEFAULT_TABS);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
}
