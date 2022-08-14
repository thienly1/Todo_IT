package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.appUser.AppRole;
import se.lexicon.appUser.AppUser;
import se.lexicon.person.Person;
import se.lexicon.todoItem.TodoItem;
import se.lexicon.todoItem.TodoItemDaoCollection;
import se.lexicon.todoItemTask.TodoItemTask;
import se.lexicon.todoItemTask.TodoItemTaskDAO;
import se.lexicon.todoItemTask.TodoItemTaskDAOCollection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class TodoItemTaskDAOTest {
    private TodoItemTaskDAO test;
    private Collection<TodoItemTask> todoItemTasks;
    private TodoItemTask todoItemTask1;
    private TodoItemTask todoItemTask2;

    @BeforeEach
    void init(){
        todoItemTasks = new ArrayList<>();
        AppUser appUser1 = new AppUser("thienly", "135246", AppRole.ROLE_APP_ADMIN);
        AppUser appUser2 = new AppUser("Loanluong", "123456", AppRole.ROLE_APP_USER);
        Person person1 = new Person("Ly", "Ta", "ly@mail.com",appUser1);
        Person person2= new Person("loan", "luong", "loan@mail.com", appUser2);
        TodoItem todoItem1 = new TodoItem("Java Stream", "work with JavaStream",
                LocalDate.of(2022,10,24), false, person1);
        todoItemTask1 = new TodoItemTask(todoItem1, person1);
        todoItemTask2 = new TodoItemTask(todoItem1, person2);
        todoItemTasks.add(todoItemTask1);
        test= new TodoItemTaskDAOCollection(todoItemTasks);
    }
    @Test
    void test_persist_successfully(){
        Assertions.assertEquals(todoItemTask2, test.persist(todoItemTask2));
    }
    @Test
    void test_persist_return_null(){
        Assertions.assertEquals(null, test.persist(todoItemTask1));
    }
    @Test
    void test_find_by_id_successfully(){
        Assertions.assertEquals(todoItemTask1, test.findById(1));
    }
    @Test
    void test_find_by_id_return_null(){
        Assertions.assertEquals(null, test.findById(3));
    }
    @Test
    void test_find_all_successfully(){
        Assertions.assertEquals(todoItemTasks, test.findAll());
    }
    @Test
    void test_find_by_Assigned_Status_successfully(){
        todoItemTasks.add(todoItemTask2);
        Assertions.assertEquals(todoItemTasks, test.findByAssignedStatus(true));
    }
    @Test
    void test_find_by_person_id_successfully(){
        Collection<TodoItemTask> todoItemTasks1= new ArrayList<>();
        todoItemTasks1.add(todoItemTask1);
        todoItemTasks.add(todoItemTask2);
        Assertions.assertEquals(todoItemTasks1, test.findByPersonId(1));
    }
    @Test
    void test_remove_successfully(){
        Collection<TodoItemTask> todoItemTasks1= new ArrayList<>();
        todoItemTasks1.add(todoItemTask1);
        todoItemTasks.add(todoItemTask2);
        test.remove(2);
        Assertions.assertEquals(todoItemTasks, todoItemTasks1);
    }
    @Test
    void test_remove_unsuccessfully(){
        Collection<TodoItemTask> todoItemTasks1= new ArrayList<>();
        todoItemTasks1.add(todoItemTask1);
        test.remove(5);
        Assertions.assertEquals(todoItemTasks, todoItemTasks1);
    }



}
