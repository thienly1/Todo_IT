package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.appUser.AppRole;
import se.lexicon.appUser.AppUser;
import se.lexicon.person.Person;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    public Person personTest;

    @BeforeEach
    public void init(){
        personTest = new Person();

    }

    @Test
    void setFirstName_successfully(){
        String name = "A";
        personTest.setFirstName(name);
        assertEquals(name, personTest.getFirstName());
    }
    @Test
    void setFirstName_throw_IllegalArgumentException(){
        assertThrows(IllegalArgumentException.class,
                () -> personTest.setFirstName(null));
    }
    @Test
    void set_email_successfully(){
        personTest.setEmail("ly@mail.com");
        assertEquals(personTest.getEmail(), "ly@mail.com");
    }
    @Test
    void set_email_throw_IllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, ()->personTest.setEmail(null));
    }
    @Test
    void set_credential_successfully(){
        AppUser appUser = new AppUser("ly", "135246", AppRole.ROLE_APP_ADMIN);
        personTest.setCredentials(appUser);
        Assertions.assertEquals(personTest.getCredentials(), appUser);
    }


}