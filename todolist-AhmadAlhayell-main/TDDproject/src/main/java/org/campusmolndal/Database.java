package org.campusmolndal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Database {
    private static final String DB_URL = "jdbc:sqlite:todo.db";

    public Database() {
        createDatabase();
    }

    /**
     * Skapar en ny databas om den inte redan finns.
     */
    private void createDatabase() {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS todos (id INTEGER PRIMARY KEY AUTOINCREMENT, task TEXT, description TEXT)";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Skapar en ny TODO-post i databasen med hjälp av en Todo-objekt.
     * @param todo Todo-objektet att lägga till i databasen
     * @return true om posten skapades framgångsrikt, annars false
     */
    public boolean createTodoItem(Todo todo) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO todos (task, description) VALUES (?, ?)")) {
            statement.setString(1, todo.getTask());
            statement.setString(2, todo.getDescription());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Hämtar en TODO-post från databasen baserat på angivet ID.
     * @param id ID för den sökta TODO-posten
     * @return Todo-objektet med matchande ID, eller null om ingen post hittades
     */
    public Todo getTodoItemById(int id) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM todos WHERE id = ?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String task = resultSet.getString("task");
                String description = resultSet.getString("description");

                Todo todo = new Todo();
                todo.setId(id);
                todo.setTask(task);
                todo.setDescription(description);

                return todo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Hämtar alla TODO-poster från databasen.
     * @return En lista med alla Todo-objekt i databasen, eller en tom lista om ingen post hittades
     */
    public List<Todo> getAllTodoItems() {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM todos")) {

            List<Todo> todos = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String task = resultSet.getString("task");
                String description = resultSet.getString("description");

                Todo todo = new Todo();
                todo.setId(id);
                todo.setTask(task);
                todo.setDescription(description);

                todos.add(todo);
            }

            return todos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * Uppdaterar en TODO-post i databasen med hjälp av en Todo-objekt.
     * @param todo Todo-objektet med uppdaterad information
     * @return true om posten uppdaterades framgångsrikt, annars false
     */
    public boolean updateTodoItem(Todo todo) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("UPDATE todos SET task = ?, description = ? WHERE id = ?")) {
            statement.setString(1, todo.getTask());
            statement.setString(2, todo.getDescription());
            statement.setInt(3, todo.getId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Raderar en TODO-post från databasen baserat på angivet ID.
     * @param id ID för den TODO-posten som ska raderas
     * @return true om posten raderades framgångsrikt, annars false
     */
    public boolean deleteTodoItem(int id) {
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM todos WHERE id = ?")) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

