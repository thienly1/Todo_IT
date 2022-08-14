package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.appUser.AppRole;
import se.lexicon.appUser.AppUser;
import se.lexicon.person.Person;
import se.lexicon.todoItem.TodoItem;
import se.lexicon.todoItemTask.TodoItemTask;

import java.time.LocalDate;

public class TodoItemTaskTest {
    private TodoItemTask test;
    private TodoItem todoItem1;
    private Person person1;
    @BeforeEach
    void init(){
        AppUser appUser1 = new AppUser("thienly", "135246", AppRole.ROLE_APP_ADMIN);
        person1 = new Person("Ly", "Ta", "ly@mail.com",appUser1);
        todoItem1 = new TodoItem("Java Stream", "work with JavaStream",
                LocalDate.of(2022,10,24), false, person1);
        test = new TodoItemTask();

    }
    @Test
    void set_assigned_return_true(){
        test.setAssignee(person1);
        Assertions.assertTrue(test.isAssigned());
    }
    @Test
    void set_assigned_return_false(){
        test.setAssignee(null);
        Assertions.assertFalse(test.isAssigned());
    }
    @Test
    void set_todoItem_null_throw_IllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> test.setTodoItem(null));
    }
    @Test
    void set_todoItem_successfully(){
        test.setTodoItem(todoItem1);
        Assertions.assertEquals(todoItem1, test.getTodoItem());
    }
    @Test
    void set_assignee_successfully(){
        test.setAssignee(person1);
        Assertions.assertEquals(person1, test.getAssignee());
    }


}
