package org.example;

public class Main {
    static void main(String[] args) {
        System.out.println("Welcome to the Task Manager!");
        System.out.println("----------------------------");
        // Create an instance of TaskManager
        TaskManager taskManager = new TaskManager();

        // Call the displayMenu method to start the task manager
        taskManager.displayMenu();
        
    }
}
