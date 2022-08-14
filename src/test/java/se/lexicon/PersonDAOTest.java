package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.appUser.AppRole;
import se.lexicon.appUser.AppUser;
import se.lexicon.person.Person;
import se.lexicon.person.PersonDAO;
import se.lexicon.person.PersonDAOCollection;

import java.util.ArrayList;
import java.util.Collection;

public class PersonDAOTest {
    private PersonDAO test;
    private Collection<Person> people;
    private Person person1;

    @BeforeEach
    void init(){
        people = new ArrayList<>();
        AppUser appUser1 = new AppUser("thienly", "135246", AppRole.ROLE_APP_ADMIN);
        AppUser appUser2 = new AppUser("Loanluong", "123456", AppRole.ROLE_APP_USER);
        person1 = new Person("Ly", "Ta", "ly@mail.com",appUser1);
        Person person2= new Person("loan", "luong", "loan@mail.com", appUser2);
        people.add(person1);
        people.add(person2);
        test= new PersonDAOCollection(people);
    }
    @Test
    void test_persist_successfully(){
        AppUser appUser3 = new AppUser("SarahEr", "112233", AppRole.ROLE_APP_USER);
        Person person3 = new Person("Sarah", "Er", "sarah@mail.com", appUser3);
        Assertions.assertEquals(test.persist(person3),person3);
    }
    @Test
    void test_persist_return_null(){
        Assertions.assertEquals(test.persist(person1),null);
    }
    @Test
    void test_find_by_id_successfully(){
        Assertions.assertEquals(person1, test.findById(1));
    }
    @Test
    void test_find_by_id_return_null(){
        Assertions.assertEquals(null, test.findById(5));
    }
    @Test
    void test_find_by_email_successfully(){
        Assertions.assertEquals(person1, test.findByEmail("ly@mail.com"));
    }
    @Test
    void test_find_by_email_return_null(){
        Assertions.assertEquals(null, test.findByEmail("ly1@mail.com"));
    }
    @Test
    void test_find_all_successfully(){
        Assertions.assertEquals(people, test.findAll());
    }
    @Test
    void test_remove_successfully(){
        Collection<Person> people1= new ArrayList<>();
        people1.add(person1);
        test.remove(2);
        Assertions.assertEquals(people,people1);
    }
    @Test
    void test_remove_unsuccessfully(){
        Collection<Person> people1= new ArrayList<>();
        people1.addAll(people);
        test.remove(6);
        Assertions.assertEquals(people,people1);
    }
}
