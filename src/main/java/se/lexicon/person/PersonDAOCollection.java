package se.lexicon.person;

import se.lexicon.person.Person;
import se.lexicon.person.PersonDAO;

import java.util.Collection;

public class PersonDAOCollection implements PersonDAO {

    Collection<Person> people;

    public PersonDAOCollection(Collection<Person> people) {
        this.people = people;
    }

    @Override
    public Person persist(Person person) {
        if (!people.contains(person)) {
            people.add(person);
            return person;
        }
            return null;
    }

    @Override
    public Person findById(int id) {
        for(Person p: people){
            if(p.getId()== id){
                return p;
            }
        }
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        for(Person p: people){
            if(p.getEmail().equals(email)){
                return p;
            }
        }
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return people;
    }

    @Override
    public void remove(int id) {
        people.remove(findById(id));
        System.out.println(people);
    }
}
