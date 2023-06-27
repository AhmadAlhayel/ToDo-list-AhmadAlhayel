package org.campusmolndal;


class Todo {
    private int id; // Unikt ID för TODO
    private String task; // Uppgift för TODO
    private String description; // Beskrivning av TODO

    public Todo() {

    } // Tom konstruktor

    /**
     * Konstruktor som skapar en ny instans av Todo med angivet ID, uppgift och beskrivning.
     */
    public Todo(int id, String task, String description) {
        this.id = id;
        this.task = task;
        this.description = description;
    }

    /**
     * Getter för att hämta TODO:ns ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter för att sätta TODO:ns ID.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter för att hämta TODO:ns uppgift.
     */
    public String getTask() {
        return task;
    }

    /**
     * Setter för att sätta TODO:ns uppgift.
     */
    public void setTask(String task) {
        this.task = task;
    }

    /**
     * Getter för att hämta TODO:ns beskrivning.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter för att sätta TODO:ns beskrivning.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Överskuggar toString-metoden för att returnera en strängrepresentation av TODO-objektet.
     */
    @Override
    public String toString() {
        return "TODO-id: " + id + ", Uppgift: " + task + ", Beskrivning: " + description;
    }
}
