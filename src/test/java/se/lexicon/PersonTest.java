package se.lexicon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    public Person personTest;
    public AppUser test;
    @BeforeEach
    public void init(){
        personTest = new Person(12,"Ly", "Ta", "ly@mail.com");
        test = new AppUser("Ly", "123456",AppRole.ROLE_APP_ADMIN);
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
    void setPassWork_successfully(){
        String a= "234567";
        test.setPassword(a);
        assertEquals(a, test.getPassword());
    }
    @Test
    void setPassWork_throw_IllegalArgumentException(){
        assertThrows(IllegalArgumentException.class,
                () ->test.setPassword(null));
    }
}