package todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DbManager {
    private static final String dbUrl = "jdbc:sqlite:todo.db";
    private static final int DEFAULT_TABID = 2;

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

    public HashMap<Integer, String> readTabsWithoutDone() {
        HashMap<Integer, String> tabs = new HashMap<>();
        try (
            Connection connection = DriverManager.getConnection(dbUrl);
            Statement statement = connection.createStatement();
        ) {
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery(SqlQueries.READ_TABS_WITHOUT_DONE);
            while (rs.next()) {
                tabs.put(rs.getInt(1), rs.getString(2));
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
            pstmt.setString(1, todo.getName());
            pstmt.setString(2, todo.getDescription());
            int tabId = todo.getTabId();
            if (tabId == Parser.TAB_NOT_SELECTE) {
                tabId = DEFAULT_TABID;
            }
            pstmt.setInt(3, tabId);
            pstmt.setString(4, todo.getDeadline());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    public List<TodoView> selectTodo(int tabId) {
        List<TodoView> todos = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(dbUrl);
            PreparedStatement pstmt = conn.prepareStatement(SqlQueries.SELECT_ALL_TODOS);
            if (tabId != Parser.TAB_NOT_SELECTE) {
                pstmt = conn.prepareStatement(SqlQueries.SELECT_SPECIFIC_TODOS);
                pstmt.setInt(1, tabId);
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                todos.add(
                    new TodoView(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        return todos;
    }

    public void updateTodo(Todo todo) {
        try (
            Connection connection = DriverManager.getConnection(dbUrl);
            PreparedStatement pstmt = connection.prepareStatement(SqlQueries.UPDATE_TODO);
        ) {
            int tabId = todo.getTabId();
            if (tabId == Parser.TAB_NOT_SELECTE) {
                tabId = DEFAULT_TABID;
            }
            pstmt.setString(1, todo.getName());
            pstmt.setString(2, todo.getDescription());
            pstmt.setInt(3, tabId);
            pstmt.setString(4, todo.getDeadline());
            pstmt.setInt(5, todo.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
}
