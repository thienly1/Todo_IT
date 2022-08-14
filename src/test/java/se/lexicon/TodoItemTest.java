package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.todoItem.TodoItem;

import java.time.LocalDate;

public class TodoItemTest {
    private TodoItem todoItemTest;
    @BeforeEach
    void init(){
        todoItemTest= new TodoItem();
    }
    @Test
    void test_set_tittle_successfully(){
        todoItemTest.setTitle("Java assignment");
        Assertions.assertEquals(todoItemTest.getTitle(), "Java assignment");
    }
    @Test
    void test_set_tittle_throw_IllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->todoItemTest.setTitle(""));
    }
    @Test
    void test_isOverDue_successfully(){
        todoItemTest.setDeadLine(LocalDate.of(2022,8,10));
        Assertions.assertTrue(todoItemTest.isOverdue());
    }
    @Test
    void test_isOverDue_return_false(){
        todoItemTest.setDeadLine(LocalDate.of(2022,8,20));
        Assertions.assertFalse(todoItemTest.isOverdue());
    }


}
