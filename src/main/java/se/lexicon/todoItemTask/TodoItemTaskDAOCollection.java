package se.lexicon.todoItemTask;

import se.lexicon.todoItemTask.TodoItemTask;
import se.lexicon.todoItemTask.TodoItemTaskDAO;

import java.util.ArrayList;
import java.util.Collection;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {

    Collection<TodoItemTask> todoItemTasks;

    public TodoItemTaskDAOCollection(Collection<TodoItemTask> todoItemTasks) {
        this.todoItemTasks = todoItemTasks;
    }

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        if(!todoItemTasks.contains(todoItemTask)){
            todoItemTasks.add(todoItemTask);
            return todoItemTask;
        }
        return null;
    }

    @Override
    public TodoItemTask findById(int id) {
        for(TodoItemTask t: todoItemTasks){
            if(t.getId()== id){
                return t;
            }
        }
        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return todoItemTasks;
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        Collection<TodoItemTask> matchAssignedStatus = new ArrayList<>();
        for(TodoItemTask t: todoItemTasks){
            if(t.isAssigned()== status){
                matchAssignedStatus.add(t);
            }
        }

        return matchAssignedStatus;
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        Collection<TodoItemTask> matchPersonId = new ArrayList<>();
        for(TodoItemTask t: todoItemTasks){
            if(t.getAssignee().getId()== personId){
                matchPersonId.add(t);
            }
        }

        return matchPersonId;
    }

    @Override
    public void remove(int id) {
        todoItemTasks.remove(findById(id));
        System.out.println(todoItemTasks);
    }
}
