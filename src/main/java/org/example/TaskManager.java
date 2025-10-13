package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {


    private static class Task {
        String name;
        boolean completed;

        Task(String name) {
            this.name = name;
            this.completed = false;
        }
    }

    ArrayList<Task> taskList = new ArrayList<>();

    public void addTask(String taskName){


        Task newTask = new Task(taskName);
        taskList.add(newTask);
        System.out.println("Task '" + taskName + "' added successfully! (Status: incomplete)");


    }

    // ***************************************************************************

    public void viewTasks(){
        System.out.println("Your Tasks are : ");
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            System.out.println((i + 1) + ". " + task.name + " - Status: " + (task.completed ? "Done" : "Incomplete"));
        }
    }

    public void updateTaskStatus(){
        if (taskList.isEmpty()) {
            System.out.println("No tasks to update.");
            return;
        }

        System.out.println("Current tasks:");
        viewTasks();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the task to update (1-" + taskList.size() + "): ");

        try {
            int taskNumber = Integer.parseInt(scanner.nextLine());
            if (taskNumber >= 1 && taskNumber <= taskList.size()) {
                Task task = taskList.get(taskNumber - 1);
                task.completed = !task.completed;
                System.out.println("Task '" + task.name + "' status updated to: " + (task.completed ? "Complete" : "Incomplete"));
            } else {
                System.out.println("Invalid task number. Please enter a number between 1 and " + taskList.size());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    public void deleteTask(){
        if (taskList.isEmpty()) {
            System.out.println("No tasks to delete.");
            return;
        }

        System.out.println("Current tasks:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i).name);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the task to delete (1-" + taskList.size() + "): ");

        try {
            int taskNumber = Integer.parseInt(scanner.nextLine());
            if (taskNumber >= 1 && taskNumber <= taskList.size()) {
                Task removedTask = taskList.remove(taskNumber - 1);
                System.out.println("Task '" + removedTask.name + "' has been deleted.");
            } else {
                System.out.println("Invalid task number. Please enter a number between 1 and " + taskList.size());
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    // ***************************************************************************
    // Display menu options and handle user input
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Loop until the user selects the "Exit" option
        while (choice != 5) {
            System.out.println("\n=== Task Manager Menu ===");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Update Task Status");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");


            try {
                // Take input from the user
                choice = Integer.parseInt(scanner.nextLine());

                // Process the selected option
                switch (choice) {
                    case 1:
                        System.out.println("Option 1: Add Task selected.");
                        // Call method to add a task (you can implement this later)
                        System.out.println("Enter  your task title: ");
                        addTask(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Option 2: View All Tasks selected.");
                        // Call method to view tasks
                        viewTasks();
                        break;
                    case 3:
                        System.out.println("Option 3: Update Task Status selected.");
                        updateTaskStatus();
                        // Call method to update task status
                        break;
                    case 4:
                        System.out.println("Option 4: Delete Task selected.");
                        // Call method to delete a task
                        deleteTask();
                        break;

                    case 5:
                        System.out.println("Exiting Task Manager. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
            }
        }
        scanner.close();
    }
}
