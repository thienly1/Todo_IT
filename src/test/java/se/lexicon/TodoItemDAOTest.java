package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.appUser.AppRole;
import se.lexicon.appUser.AppUser;
import se.lexicon.person.Person;
import se.lexicon.todoItem.TodoItem;
import se.lexicon.todoItem.TodoItemDAO;
import se.lexicon.todoItem.TodoItemDaoCollection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class TodoItemDAOTest {
    private TodoItemDAO todoItemDAO;
    private Collection<TodoItem> todoItems;
    private TodoItem todoItem2;
    private TodoItem todoItem1;

    @BeforeEach
    void init(){
        AppUser appUser1 = new AppUser("thienly", "135246", AppRole.ROLE_APP_ADMIN);
        AppUser appUser2 = new AppUser("Loanluong", "123456", AppRole.ROLE_APP_USER);
        Person person1 = new Person("Ly", "Ta", "ly@mail.com",appUser1);
        Person person2= new Person("loan", "luong", "loan@mail.com", appUser2);
        todoItem1 = new TodoItem("Java Stream", "work with JavaStream",
                LocalDate.of(2022,10,24), false, person1);
        todoItem2 = new TodoItem("Json","work with Json", LocalDate.of(2022,9,25),
                false,person2 );
        todoItems  = new ArrayList<>();
        todoItems.add(todoItem1);
        todoItemDAO = new TodoItemDaoCollection(todoItems);
    }
    @Test
    void test_persist_successfully(){
        Assertions.assertEquals(todoItemDAO.persist(todoItem2), todoItem2);
    }
    @Test
    void test_persist_return_null(){
        Assertions.assertEquals(todoItemDAO.persist(todoItem1), null);
    }
    @Test
    void test_find_by_id_successfully(){
        Assertions.assertEquals(todoItemDAO.findById(1), todoItem1);
    }
    @Test
    void test_find_by_id_return_null(){
        Assertions.assertEquals(todoItemDAO.findById(5), null);
    }
    @Test
    void test_find_by_done_status(){
        Assertions.assertEquals(todoItemDAO.findAllByDoneStatus(false), todoItems);
    }
    @Test
    void test_find_by_tittle_contain_successfully(){
        Collection<TodoItem> matchTitleContains = new ArrayList<>();
        matchTitleContains.add(todoItem2);
        todoItems.add(todoItem2);
        Assertions.assertEquals(todoItemDAO.findByTitleContains("Json"), matchTitleContains);
    }
    @Test
    void test_find_by_tittle_contain_return_empty_collection(){
        Collection<TodoItem> matchTitleContains = new ArrayList<>();
        todoItems.add(todoItem2);
        Assertions.assertEquals(todoItemDAO.findByTitleContains("ason"), matchTitleContains);
    }
    @Test
    void test_find_by_person_id_successfully(){
        Collection<TodoItem> matchpersonIdContains = new ArrayList<>();
        matchpersonIdContains.add(todoItem2);
        todoItems.add(todoItem2);
        Assertions.assertEquals(todoItemDAO.findByPersonId(2), matchpersonIdContains);
    }
    @Test
    void test_find_by_person_id_return_null(){
        Collection<TodoItem> matchpersonIdContains = new ArrayList<>();
        todoItems.add(todoItem2);
        Assertions.assertEquals(todoItemDAO.findByPersonId(5), matchpersonIdContains);
    }
    @Test
    void test_remove_successfully(){
        Collection<TodoItem> todoItems1 = new ArrayList<>();
        todoItems1.add(todoItem1);
        todoItems.add(todoItem2);
        todoItemDAO.remove(2);
        Assertions.assertEquals(todoItems,todoItems1 );
    }

}
