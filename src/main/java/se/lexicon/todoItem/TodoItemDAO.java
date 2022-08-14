package se.lexicon.todoItem;

import se.lexicon.todoItem.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO<T> {

    T persist (TodoItem todoItem);
    T findById(int id);
    Collection<T> findAll();
    Collection<T> findAllByDoneStatus(boolean done);
    Collection<T> findByTitleContains(String title);
    Collection<T> findByPersonId( int personId);
    Collection<T > findByDeadlineBefore(LocalDate Date);
    Collection<T > findByDeadlineAfter(LocalDate Date);
    void remove( int id);

}
