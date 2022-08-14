package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.appUser.AppRole;
import se.lexicon.appUser.AppUser;
import se.lexicon.appUser.AppUserDAO;
import se.lexicon.appUser.AppUserDAOCollection;

import java.util.ArrayList;
import java.util.Collection;

public class AppUserDAOTest {
    private AppUserDAO appUserDAOTest;
    private Collection<AppUser> appUsers;
    @BeforeEach
    void init(){
        appUsers = new ArrayList<>();
        AppUser appUser1 = new AppUser("thienly", "135246", AppRole.ROLE_APP_ADMIN);
        AppUser appUser2 = new AppUser("Loanluong", "123456", AppRole.ROLE_APP_USER);
        appUsers.add(appUser1);
        appUsers.add(appUser2);
        appUserDAOTest = new AppUserDAOCollection(appUsers);
    }
    @Test
    void test_persist_successfully(){
        AppUser appUser3 = new AppUser("SarahEr", "112233", AppRole.ROLE_APP_USER);
        Assertions.assertEquals(appUser3,appUserDAOTest.persist(appUser3));
    }
    @Test
    void test_persist_return_null(){
        AppUser appUser2 = new AppUser("Loanluong", "123456", AppRole.ROLE_APP_USER);
        Assertions.assertEquals(null, appUserDAOTest.persist(appUser2));
    }
    @Test
    void test_find_by_useName_successfully(){
        AppUser appUser2 = new AppUser("Loanluong", "123456", AppRole.ROLE_APP_USER);
        Assertions.assertEquals(appUser2, appUserDAOTest.findByUserName("Loanluong"));
    }
    @Test
    void test_find_by_useName_return_null(){
        Assertions.assertEquals(null, appUserDAOTest.findByUserName("aaa"));
    }
    @Test
    void test_find_all(){
        Assertions.assertEquals(appUsers,appUserDAOTest.findAll());
    }
    @Test
    void test_remove_successfully(){
        AppUser appUser2 = new AppUser("Loanluong", "123456", AppRole.ROLE_APP_USER);
        appUserDAOTest.remove("thienly");
        Collection<AppUser> appUsers1 = new ArrayList<>();
        appUsers1.add(appUser2);
        Assertions.assertEquals(appUsers,appUsers1);
    }
    @Test
    void test_remove_return_not_found(){
        AppUser appUser1 = new AppUser("thienly", "135246", AppRole.ROLE_APP_ADMIN);
        AppUser appUser2 = new AppUser("Loanluong", "123456", AppRole.ROLE_APP_USER);
        Collection<AppUser> appUsers1 = new ArrayList<>();
        //appUsers1.addAll(appUsers);
        appUsers1.add(appUser1);
        appUsers1.add(appUser2);
        appUserDAOTest.remove("thienly1");
        Assertions.assertEquals(appUsers,appUsers1);
    }



}
