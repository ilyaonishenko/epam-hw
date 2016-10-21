package task02.dao.interfaces;

import task02.model.Book;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by wopqw on 20.10.16.
 */
public interface BookDAO {

    Collection<Book> getAll();

    default Optional<Book> getBookById(long id){

        return getAll().stream()
                .filter(b -> b.getId()==id)
                .findAny();
    }

    void update(Book book);

    void delete(long id);

    void insert(Book book);
}
