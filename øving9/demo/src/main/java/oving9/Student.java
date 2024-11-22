package oving9;

public class Student {
    private String name;
    private int taskAmt;
    
    public Student(String name, int taskAmt) {
        this.name = name;
        this.taskAmt = taskAmt;
    }

    public String getName() {
        return name;
    }

    public int getTaskAmt() {
        return taskAmt;
    }

    public void increaseTaskAmt(int amount) {
        taskAmt += amount;
    }

    @Override
    public String toString() {
        return "Student " + name + ": " + taskAmt + " task(s) completed";
    }
}
