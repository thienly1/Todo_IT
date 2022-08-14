package se.lexicon.todoItem;

import se.lexicon.person.Person;
import se.lexicon.sequencers.TodoItemIdSequencer;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {

    private int todoItemId;
    private String title; // not allow to be null or empty.
    private String taskDescription;
    private LocalDate deadLine; //TodoItem is overdue if current date > deadline. Not allowed to be null
    boolean done;
    Person creator;

    public TodoItem() {
        todoItemId= TodoItemIdSequencer.nextId();
    }

    public TodoItem(String title, String taskDescription, LocalDate deadLine, boolean done, Person creator) {
        this();
        this.title = title;
        this.taskDescription = taskDescription;
        this.deadLine = deadLine;
        this.creator = creator;
        this.done= done;
        setTitle(title);
        setDeadLine(deadLine);
    }


    public int getId() {
        return todoItemId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.equals(null)|| title.equals("")) throw new IllegalArgumentException("Title is not allowed to be null or empty");
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
        if(deadLine == null)throw new IllegalArgumentException("deadline is not allowed to be null");
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
    @Override
    public String toString() {
        return "TodoItem{" +
                "todoItemId=" + todoItemId +
                ", title='" + title + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", deadLine=" + deadLine +
                ", done=" + done +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItem)) return false;
        TodoItem todoItem = (TodoItem) o;
        return todoItemId == todoItem.todoItemId && isDone() == todoItem.isDone() && isOverdue() == todoItem.isOverdue() && getTitle().equals(todoItem.getTitle()) && getTaskDescription().equals(todoItem.getTaskDescription()) && getDeadLine().equals(todoItem.getDeadLine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(todoItemId, getTitle(), getTaskDescription(), getDeadLine(), isDone(), isOverdue());
    }
}
