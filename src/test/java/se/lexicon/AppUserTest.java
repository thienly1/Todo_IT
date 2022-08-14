package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.appUser.AppRole;
import se.lexicon.appUser.AppUser;

public class AppUserTest {
    private AppUser appUserTest;
    @BeforeEach
    void init(){
        appUserTest = new AppUser("thienly", "135246", AppRole.ROLE_APP_ADMIN);
    }
    @Test
    void test_set_useName_successfully(){
        Assertions.assertEquals("thienly", appUserTest.getUseName());
    }
    @Test
    void test_set_userName_throw_IllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->appUserTest.setUseName(""));
    }
    @Test
    void test_set_passWord_successfully(){
        Assertions.assertEquals("135246", appUserTest.getPassword());
    }
    @Test
    void test_set_passWord_throw_IllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> appUserTest.setPassword(null));
    }
    @Test
    void test_set_role_successfully(){
        Assertions.assertEquals(AppRole.ROLE_APP_ADMIN, appUserTest.getRole());
    }
    @Test
    void test_set_role_throw_IllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> appUserTest.setRole(null));
    }

}
