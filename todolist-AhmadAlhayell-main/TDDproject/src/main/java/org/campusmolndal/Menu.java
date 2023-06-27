package org.campusmolndal;

import java.util.List;
import java.util.Scanner;


class Menu {
    private Database database;

    public Menu(Database database) {
        this.database = database;
    }

    /**
     * Metoden som hanterar menylogiken och användarens val.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nVälj en handling:");
            System.out.println("1. Skapa en TODO");
            System.out.println("2. Visa enskild TODO");
            System.out.println("3. Visa alla TODO");
            System.out.println("4. Uppdatera en TODO");
            System.out.println("5. Radera en TODO");
            System.out.println("0. Avsluta");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Rensa scanner buffer

            switch (choice) {
                case 1:
                    createTodo();
                    break;
                case 2:
                    System.out.print("Ange TODO-id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Rensa scanner buffer
                    readTodoById(id);
                    break;
                case 3:
                    listTodos();
                    break;
                case 4:
                    System.out.print("Ange TODO-id: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Rensa scanner buffer
                    updateTodoById(updateId);
                    break;
                case 5:
                    System.out.print("Ange TODO-id: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Rensa scanner buffer
                    deleteTodoById(deleteId);
                    break;
                case 0:
                    System.out.println("Avslutar programmet...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
                    break;
            }
        }
    }

    /**
     * Skapar en ny TODO baserat på användarens inmatning och lägger till den i databasen.
     */
    private void createTodo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange uppgift: ");
        String task = scanner.nextLine();

        System.out.print("Ange beskrivning: ");
        String description = scanner.nextLine();

        // Skapa en ny instans av Todo och sätt uppgifter och beskrivning
        Todo todo = new Todo();
        todo.setTask(task);
        todo.setDescription(description);

        // Anropa createTodoItem-metoden i databasen och kontrollera resultatet
        if (database.createTodoItem(todo)) {
            System.out.println("TODO skapad!");
        } else {
            System.out.println("Kunde inte skapa TODO.");
        }
    }

    /**
     * Hämtar och visar information om en specifik TODO baserat på dess ID.
     */
    private void readTodoById(int id) {
        // Anropa getTodoItemById-metoden i databasen för att hämta TODO med det angivna ID:et
        Todo todo = database.getTodoItemById(id);

        if (todo != null) {
            System.out.println("TODO-id: " + todo.getId());
            System.out.println("Uppgift: " + todo.getTask());
            System.out.println("Beskrivning: " + todo.getDescription());
        } else {
            System.out.println("Kunde inte hitta TODO med id: " + id);
        }
    }

    /**
     * Hämtar och listar alla TODOs som finns i databasen.
     */
    private void listTodos() {
        // Anropa getAllTodoItems-metoden i databasen för att hämta en lista med alla TODOs
        List<Todo> todos = database.getAllTodoItems();

        if (todos.isEmpty()) {
            System.out.println("Inga TODO hittades.");
        } else {
            System.out.println("Alla TODO:");
            for (Todo todo : todos) {
                System.out.println(todo);
            }
        }
    }

    /**
     * Uppdaterar en specifik TODO baserat på dess ID.
     */
    private void updateTodoById(int id) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ange ny uppgift: ");
        String newTask = scanner.nextLine();

        System.out.print("Ange ny beskrivning: ");
        String newDescription = scanner.nextLine();

        // Skapa en ny instans av Todo med det angivna ID:et och de nya uppgifterna
        Todo todo = new Todo();
        todo.setId(id);
        todo.setTask(newTask);
        todo.setDescription(newDescription);

        // Anropa updateTodoItem-metoden i databasen och kontrollera resultatet
        if (database.updateTodoItem(todo)) {
            System.out.println("TODO med id " + id + " har uppdaterats.");
        } else {
            System.out.println("Kunde inte hitta TODO med id: " + id);
        }
    }

    /**
     * Raderar en specifik TODO baserat på dess ID.
     */
    private void deleteTodoById(int id) {
        // Anropa deleteTodoItem-metoden i databasen och kontrollera resultatet
        if (database.deleteTodoItem(id)) {
            System.out.println("TODO med id " + id + " har raderats.");
        } else {
            System.out.println("Kunde inte hitta TODO med id: " + id);
        }
    }
}
