package oving9;

import java.util.ArrayList;

public class Tasks {
    private ArrayList<Student> students;

    public Tasks() {
        students = new ArrayList<>();
    }

    public int getStudentCount() {
        return students.size();
    }

    public int studentTaskAmount(String name) {
        return students.stream().filter(student -> student.getName().equals(name))
                        // mapper streamen til mengden oppgaver
                        .map(Student::getTaskAmt)
                        // returnerer første match
                        .findFirst()
                        .orElse(-1);
    }

    public void createStudent(String name, int amount) {
        // sjekker om det finnes noen matcher til navnet gitt 
        boolean exists = students.stream().anyMatch(student -> student.getName().equals(name));
        
        if (exists) {
            System.out.println("This student is already registered.");
        }
        else {
            Student student = new Student(name, amount);
            students.add(student);
            System.out.println("Student " + name + " was successfully registered with " + amount + " tasks completed.");
        }
    }

    public void increaseTasksByName(String name, int amount) {
        students.stream().filter(student -> student.getName().equals(name))
        .findFirst().ifPresent(student -> student.increaseTaskAmt(amount));
    }

    public void initDummys() {
        createStudent("Alice", 5);
        createStudent("Bob", 8);
        createStudent("Charlie", 3);
        createStudent("Diana", 7);
        createStudent("Evan", 2);
        createStudent("Fiona", 6);
        createStudent("George", 9);
        createStudent("Hannah", 4);
        createStudent("Ian", 10);
        createStudent("Julia", 1); 
    }
    

    @Override
    public String toString() {
        return "Registered students and their completed tasks: " +
            students.stream()
                .map(student -> "\nName: " + student.getName() + ", Tasks completed: " + student.getTaskAmt())
                .reduce((s1, s2) -> s1 + "\n" + s2)
                .orElse("No students registered.");
    }
}