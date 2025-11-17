package todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.HashMap;

public class DbManager {
    private static final String dbUrl = "jdbc:sqlite:todo.db";
    private static final String DEFAULT_TABID = "2";

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

    public HashMap<String, String> readTabsWithoutDone() {
        HashMap<String, String> tabs = new HashMap<>();
        try (
            Connection connection = DriverManager.getConnection(dbUrl);
            Statement statement = connection.createStatement();
        ) {
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery(SqlQueries.READ_TABS_WITHOUT_DONE);
            while (rs.next()) {
                tabs.put(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return tabs;
    }

    public void insertTodo(Todo todo) {
        try (
            Connection connection = DriverManager.getConnection(dbUrl);
            PreparedStatement pstmt = connection.prepareStatement(SqlQueries.INSERT_TODO);
        ) {
            String tabId = todo.getTabId();
            if (tabId.isEmpty()) {
                tabId = DEFAULT_TABID;
            }
            pstmt.setString(1, todo.getName());
            pstmt.setString(2, todo.getDescription());
            pstmt.setString(3, tabId);
            pstmt.setString(4, todo.getDeadline());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
}
