package se.lexicon;

public class TodoItemTask {

    private int todoItemTaskId;
    private boolean assigned; //set to true if assignee is not null
    private TodoItem todoItem;//represent the details what assignee should do before deadline. Not null
    private Person assignee;

    public TodoItemTask (){
        this.todoItemTaskId = 0;
        this.assignee = null;
        this.assigned = false;
        this.todoItem = new TodoItem();
    }
    public TodoItemTask(boolean assigned, TodoItem todoItem, Person assignee){
        this.assigned = assigned;
        this.todoItem = todoItem;
        this.assignee = assignee;
    }

    public int getId() {
        return todoItemTaskId;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        if(assignee != null) {
            this.assigned = assigned;
        }
        this.assigned = false;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
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
}
