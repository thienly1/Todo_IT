package se.lexicon;

import java.time.LocalDate;

public class TodoItem {

    private int todoItemId;
    String title; // not allow to be null or empty.
    String taskDescription;
    LocalDate deadLine; //TodoItem is overdue if current date > deadline. Not allowed to be null
    boolean done;
    boolean overdue;
    Person creator;

    public TodoItem(){
        this.todoItemId = 0;
        this.title = "NOT_ SPECIFIED";
        this.taskDescription = "empty";
        this.deadLine = LocalDate.MIN;
        this.done = false;
    }

    public TodoItem(int todoItemId, String title, String taskDescription, LocalDate deadLine, Person creator) {
        this.todoItemId = todoItemId;
        this.title = title;
        this.taskDescription = taskDescription;
        this.deadLine = deadLine;
        this.creator = creator;
    }

    public int getId() {
        return todoItemId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }


    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    //isOverdue() should return true if current date has passed deadLine.
    public boolean isOverdue() {
        LocalDate currentDate = LocalDate.now();
        if ( currentDate.isAfter(deadLine)) {
            return true;
        }
        return false;
    }
    public void getSummary(){
        System.out.println("todoItem ID: " + todoItemId+ " Title: "+ " Deadline " + deadLine);
    }
}
