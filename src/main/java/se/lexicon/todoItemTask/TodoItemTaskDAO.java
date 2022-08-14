package se.lexicon.todoItemTask;

import se.lexicon.todoItemTask.TodoItemTask;

import java.util.Collection;

public interface TodoItemTaskDAO<T> {

    T persist(TodoItemTask todoItemTask);
    T findById(int id);
    Collection<T> findAll();
    Collection<T> findByAssignedStatus(boolean status);
    Collection<T> findByPersonId(int personId);
    void remove(int id);

}
