package se.lexicon.person;

import se.lexicon.person.Person;

import java.util.Collection;

public interface PersonDAO<T>{

    T persist (Person person);
    T findById(int id);
    T findByEmail(String email);
    Collection<T> findAll();
    void remove( int id);
}
