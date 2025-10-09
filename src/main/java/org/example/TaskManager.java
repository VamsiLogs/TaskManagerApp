package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {


    ArrayList<String> taskList = new ArrayList<>();

    public void addTask(String taskName){


        //Scanner scanner = new Scanner(System.in);
        // Prompt the user to enter the task name
        //System.out.println("Enter  your task title: ");

        // Read the user input and store it in DB
        //String taskName = scanner.nextLine();


        //ArrayList<String> taskList = new ArrayList<>();
        taskList.add(taskName);

        //taskList.add("Status : Done , undone");
        // Status of default task is into undone state (Status : Done , undone)

        //System.out.print("Your Task added successfully!");
        System.out.print("Your Task" + taskList + " added successfully!");

        //scanner.nextLine();
        //scanner.close();

    }

    // ***************************************************************************

    public void viewTasks(){
        System.out.println("Your Tasks are : ");
        for(String task : taskList){
            System.out.println(task);
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
                        // Call method to update task status
                        break;
                    case 4:
                        System.out.println("Option 4: Delete Task selected.");
                        // Call method to delete a task
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
