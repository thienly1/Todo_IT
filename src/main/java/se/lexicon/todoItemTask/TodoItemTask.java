package se.lexicon.todoItemTask;

import se.lexicon.person.Person;
import se.lexicon.sequencers.TodoItemIdTaskSequencer;
import se.lexicon.todoItem.TodoItem;

public class TodoItemTask {

    private int todoItemTaskId;
    private boolean assigned; //set to true if assignee is not null
    private TodoItem todoItem;//represent the details what assignee should do before deadline. Not null
    private Person assignee;

    public TodoItemTask() {
        todoItemTaskId = TodoItemIdTaskSequencer.nextId();
    }

    public TodoItemTask(TodoItem todoItem, Person assignee){
        this();
        this.todoItem = todoItem;
        this.assignee = assignee;
        setTodoItem(todoItem);
        setAssigned(assigned);
    }

    public int getId() {
        return todoItemTaskId;
    }

    public boolean isAssigned() {
        if(assignee==null){
            assigned= false;
            return false;
        }
        assigned= true;
        return true;
    }

    public void setAssigned(boolean assigned) {
        this.assigned= assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        if(todoItem == null) throw new IllegalArgumentException("todoItem is not allowed to be null");
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    public String getSummary(){
        return"{id: " + todoItemTaskId + ", assigned: " + assigned + ", what assignee should do before deadline: " + todoItem + ", assignee: " + assignee+ "}";
    }

    @Override
    public String toString() {
        return "TodoItemTask{" +
                "todoItemTaskId=" + todoItemTaskId +
                ", assigned=" + assigned +
                ", todoItem=" + todoItem +
                ", assignee=" + assignee +
                '}';
    }
}
