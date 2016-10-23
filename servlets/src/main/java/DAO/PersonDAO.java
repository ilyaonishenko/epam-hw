package DAO;

import model.Person;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by wopqw on 23.10.16.
 */
public interface PersonDAO {

    Collection<Person> getAll();

    @SuppressWarnings("unused")
    default Optional<Person> getById(long id){
        return getAll().stream()
                .filter(p -> p.getId() == id)
                .findAny();
    }
}
