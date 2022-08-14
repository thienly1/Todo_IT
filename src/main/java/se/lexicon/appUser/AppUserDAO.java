package se.lexicon.appUser;

import java.util.Collection;

public interface AppUserDAO<T> {

    T persist(AppUser appUser);
    T findByUserName(String useName);
    Collection<T> findAll();
    void remove(String useName);
}
