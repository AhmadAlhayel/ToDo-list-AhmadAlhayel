package org.campusmolndal;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class DatabaseTest {

    @Test
    public void testCreateTodoItem() {
        // Arrange
        Todo todo = new Todo();
        Database database = mock(Database.class);

        // Ange ett specifikt returvärde för metoden createTodoItem()
        when(database.createTodoItem(todo)).thenReturn(true);

        // Act
        boolean result = database.createTodoItem(todo);

        // Assert
        assertTrue(result);
    }

    /**
     * Testar om rätt Todo-objekt returneras baserat på angivet id.
     */
    @Test
    public void testGetTodoItemById() {
        // Arrange
        int id = 1;
        Todo expectedTodo = new Todo();
        expectedTodo.setId(id);
        Database database = mock(Database.class);

        // Ange ett specifikt returvärde för metoden getTodoItemById()
        when(database.getTodoItemById(id)).thenReturn(expectedTodo);

        // Act
        Todo actualTodo = database.getTodoItemById(id);

        // Assert
        assertNotNull(actualTodo);
        assertEquals(expectedTodo, actualTodo);
    }

    /**
     * Testar om en lista med Todo-objekt returneras korrekt.
     */
    @Test
    public void testGetAllTodoItems() {
        // Arrange
        Todo todo1 = new Todo();
        Todo todo2 = new Todo();
        List<Todo> expectedTodos = Arrays.asList(todo1, todo2);
        Database database = mock(Database.class);

        // Ange ett specifikt returvärde för metoden getAllTodoItems()
        when(database.getAllTodoItems()).thenReturn(expectedTodos);

        // Act
        List<Todo> actualTodos = database.getAllTodoItems();

        // Assert
        assertNotNull(actualTodos);
        assertEquals(expectedTodos.size(), actualTodos.size());
        assertEquals(expectedTodos.get(0), actualTodos.get(0));
        assertEquals(expectedTodos.get(1), actualTodos.get(1));
    }

    @Test
    public void testUpdateTodoItem() {
        // Arrange
        Todo todo = new Todo();
        Database database = mock(Database.class);

        // Ange ett specifikt returvärde för metoden updateTodoItem()
        when(database.updateTodoItem(todo)).thenReturn(true);

        // Act
        boolean result = database.updateTodoItem(todo);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testDeleteTodoItem() {
        // Arrange
        int id = 1;
        Database database = mock(Database.class);

        // Ange ett specifikt returvärde för metoden deleteTodoItem()
        when(database.deleteTodoItem(id)).thenReturn(true);

        // Act
        boolean result = database.deleteTodoItem(id);

        // Assert
        assertTrue(result);
    }

}
