package oving9;

import java.util.Scanner;


public class App 
{
    public static void main( String[] args ) {
        boolean running = true;
        Tasks tasks = new Tasks();
        tasks.initDummys();
        do {
        System.out.println("""
                Do you want to:
                1) Find total students registered
                2) Check total tasks completed by a student
                3) Register new student
                4) Increase tasks completed by a student
                5) Quit
                """);
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice) {
            case 1 -> System.out.println(tasks);
            case 2,3,4 -> choiceMethod(choice, scanner, tasks);
            case 5 -> running = false;
            default -> System.out.println("invalid choice :(");

        
        }
    } while (running);
} 
    public static void choiceMethod(int choice, Scanner scanner, Tasks tasks) 
    {
        if (choice == 2) {
            System.out.println("What student do you want to check for?");
            String name = scanner.nextLine();
            int taskAmt = tasks.studentTaskAmount(name);
            if (taskAmt != -1) {
                System.out.println("Total tasks complete by " + name + ": " + taskAmt);
            }
            else {
                System.out.println("Student not found.");
            }
        }

        else if (choice == 3) {
            System.out.println("What is the name and tasks of the student you want to add? (Name: task amount)");
            String answer = scanner.nextLine();
            String answers[] = answer.split(": ");
            String name = answers[0];
            int amount = Integer.parseInt(answers[1]);

            tasks.createStudent(name, amount);
        }

        else {
            System.out.println("What is the students name and how many tasks did they complete? (name: task amount)");
            String answer = scanner.nextLine();
            String answers[] = answer.split(": ");
            String name = answers[0];
            int amount = Integer.parseInt(answers[1]);

            tasks.increaseTasksByName(name, amount);
        } 
    }
} 