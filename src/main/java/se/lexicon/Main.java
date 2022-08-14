package se.lexicon;

import se.lexicon.appUser.AppRole;
import se.lexicon.appUser.AppUser;
import se.lexicon.appUser.AppUserDAO;
import se.lexicon.appUser.AppUserDAOCollection;
import se.lexicon.person.Person;
import se.lexicon.person.PersonDAO;
import se.lexicon.person.PersonDAOCollection;
import se.lexicon.todoItem.TodoItem;
import se.lexicon.todoItem.TodoItemDAO;
import se.lexicon.todoItem.TodoItemDaoCollection;
import se.lexicon.todoItemTask.TodoItemTask;
import se.lexicon.todoItemTask.TodoItemTaskDAO;
import se.lexicon.todoItemTask.TodoItemTaskDAOCollection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    private static Collection<AppUser> appUsers;
    private static Collection<Person> people;
    private static Collection<TodoItem> todoItems;
    private static Collection<TodoItemTask> todoItemTasks;
    public static void initialize(){

        appUsers = new ArrayList<>();
        people = new ArrayList<>();
        todoItems  = new ArrayList<>();
        todoItemTasks = new ArrayList<>();
    }
    public static void main(String[] args) {
        initialize();
        AppUser appUser1 = new AppUser("thienly", "135246", AppRole.ROLE_APP_ADMIN);
        AppUser appUser2 = new AppUser("Loanluong", "123456", AppRole.ROLE_APP_USER);
        AppUser appUser3 = new AppUser("SarahEr", "112233", AppRole.ROLE_APP_USER);
        AppUserDAO appUserDAO = new AppUserDAOCollection(appUsers);
        appUserDAO.persist(appUser1);
        appUserDAO.persist(appUser2);
        appUserDAO.persist(appUser3);
        System.out.println(appUserDAO.findByUserName("thienly"));
        System.out.println(appUserDAO.findAll());
        //appUserDAO.remove("thienly");
        appUserDAO.remove("aa");

        Person person1 = new Person("Ly", "Ta", "ly@mail.com",appUser1);
        Person person2= new Person("loan", "luong", "loan@mail.com", appUser2);
        Person person3 = new Person("Sarah", "Er", "sarah@mail.com", appUser3);
        PersonDAO personDAO = new PersonDAOCollection(people);
        personDAO.persist(person1);
        personDAO.persist(person2);
        personDAO.persist(person3);
        System.out.println(personDAO.findAll());
        System.out.println(personDAO.findById(1));
        System.out.println(personDAO.findById(5));
        System.out.println(personDAO.findByEmail("loan@mail.com"));
        System.out.println(personDAO.findByEmail("ghj@mail.com"));
        //personDAO.remove(1);
        personDAO.remove(6);

        TodoItem todoItem1 = new TodoItem("Java Stream", "work with JavaStream",
                LocalDate.of(2022,10,24), false, person1);
        TodoItem todoItem2 = new TodoItem("Json","work with Json", LocalDate.of(2022,9,25),
                false,person2 );
        TodoItemDAO todoItemDAO = new TodoItemDaoCollection(todoItems);
        todoItemDAO.persist(todoItem1);
        todoItemDAO.persist(todoItem2);
        System.out.println(todoItemDAO.findAll());
        System.out.println(todoItemDAO.findAllByDoneStatus(true));
        System.out.println(todoItemDAO.findAllByDoneStatus(false));
        System.out.println(todoItemDAO.findByDeadlineAfter(LocalDate.of(2022,9,30)));
        System.out.println(todoItemDAO.findByPersonId(1));
        System.out.println(todoItemDAO.findByPersonId(2));
        System.out.println(todoItemDAO.findById(1));
        System.out.println(todoItemDAO.findByDeadlineBefore(LocalDate.of(2022,12,20)));
        System.out.println(todoItemDAO.findByTitleContains("Json"));
        System.out.println(todoItemDAO.findByTitleContains("c++"));
        todoItemDAO.remove(4);

        TodoItemTask todoItemTask = new TodoItemTask(todoItem1, person2);
        TodoItemTask todoItemTask1 = new TodoItemTask(todoItem2, person3);
        TodoItemTaskDAO todoItemTaskDAO = new TodoItemTaskDAOCollection(todoItemTasks);
        todoItemTaskDAO.persist(todoItemTask);
        todoItemTaskDAO.persist(todoItemTask1);
        System.out.println(todoItemTaskDAO.findAll());
        System.out.println(todoItemTaskDAO.findByAssignedStatus(true));
        System.out.println(todoItemTaskDAO.findById(1));
        System.out.println(todoItemTaskDAO.findByPersonId(1));
        System.out.println(todoItemTaskDAO.findByPersonId(3));
        todoItemTaskDAO.remove(1);
    }
}