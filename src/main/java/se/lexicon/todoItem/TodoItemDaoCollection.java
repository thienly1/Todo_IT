package se.lexicon.todoItem;

import se.lexicon.todoItem.TodoItem;
import se.lexicon.todoItem.TodoItemDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class TodoItemDaoCollection implements TodoItemDAO {

    private Collection<TodoItem> todoItems;

    public TodoItemDaoCollection(Collection<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    @Override
    public TodoItem persist(TodoItem todoItem) {
        if(!todoItems.contains(todoItem)){
            todoItems.add(todoItem);
            return todoItem;
        }
        return null;
    }

    @Override
    public TodoItem findById(int id) {
        for(TodoItem t: todoItems){
            if(t.getId()==id){
                return t;
            }
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return todoItems;
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        Collection<TodoItem> matchDoneStatus = new ArrayList<>();
        for(TodoItem t: todoItems){
            if(t.isDone()== done){
                matchDoneStatus.add(t);
            }
        }
        return matchDoneStatus;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        Collection<TodoItem> matchTitleContains = new ArrayList<>();
        for(TodoItem t: todoItems){
            if(t.getTitle().equals(title)){
                matchTitleContains.add(t);
            }
        }
        return matchTitleContains;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        Collection<TodoItem> matchTitleContains = new ArrayList<>();
        for(TodoItem t: todoItems){
            if(t.getCreator().getId()==personId){
                matchTitleContains.add(t);
            }
        }
        return matchTitleContains;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate Date) {
        Collection<TodoItem> beforeDeadlines = new ArrayList<>();
        for(TodoItem t: todoItems){
            if(t.getDeadLine().isBefore(Date)){
                beforeDeadlines.add(t);
            }
        }
        return beforeDeadlines;
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate Date) {
        Collection<TodoItem> afterDeadlines = new ArrayList<>();
        for(TodoItem t: todoItems){
            if(t.getDeadLine().isAfter(Date)){
                afterDeadlines.add(t);
            }
        }
        return afterDeadlines;
    }

    @Override
    public void remove(int id) {
        todoItems.remove(findById(id));
        System.out.println(todoItems);
    }
}
