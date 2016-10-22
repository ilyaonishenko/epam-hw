package task02;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.junit.Before;
import org.junit.Test;
import task02.common.ConnectionPool;
import task02.dao.h2.H2BookDAO;
import task02.model.Book;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 20.10.16.
 */

@Log
public class LibraryAppTest {

    private static final String PATH_TO_CONFIG = "src/test/resources/db.properties";
    private static final String PATH_TO_INIT = "src/test/resources/init_library.sql";

    private Book b1;

    private H2BookDAO bookDAO;

    @Before
    @SneakyThrows
    public void initDB(){

        log.info(()->"init db");

        ConnectionPool connectionPool = ConnectionPool.create(PATH_TO_CONFIG);

        try(Connection connection = connectionPool.getConnection()) {

            Statement statement = connection.createStatement();

            Arrays.stream(
                    Files.lines(Paths.get(PATH_TO_INIT))
                            .collect(Collectors.joining())
                            .split(";"))
                    .forEachOrdered(sql -> {
                        try {
                            statement.addBatch(sql);
                        } catch (SQLException e) {
                            throw new RuntimeException();
                        }
                    });
            statement.executeBatch();
        }
        log.info(()->"batch executed");

        b1 = new Book(0,"Lord of the Flies","William Gerald Golding","AST");

        bookDAO = new H2BookDAO(connectionPool);
    }

    @Test
    @SneakyThrows
    public void testInsertion(){

        assertThat(bookDAO.getAll().size(),is(3));

        bookDAO.insert(b1);

        assertThat(bookDAO.getAll().size(),is(4));
    }

    @Test
    @SneakyThrows
    public void testDelete(){

        assertThat(bookDAO.getAll().size(),is(3));
        bookDAO.insert(b1);
        assertThat(bookDAO.getAll().size(),is(4));
        bookDAO.delete(b1.getId());

        assertThat(
                bookDAO.getAll().stream().
                filter(b -> b.getName().equals(b1.getName()))
                .findAny().isPresent(),
                is(false));
    }

    @Test
    @SneakyThrows
    public void testUpdate(){

        assertThat(bookDAO.getAll().size(),is(3));
        bookDAO.insert(b1);
        assertThat(bookDAO.getAll().size(),is(4));
        Book b2 = new Book(b1.getId(),"Lord of The Rings","Tolkien","i really don't know");
        bookDAO.update(b2);

        assertThat(bookDAO.getAll().stream()
                .filter(b -> b.getId()==b1.getId())
                .findAny().orElseThrow(IllegalArgumentException::new)
                .getName().equals(b2.getName()),
                is(true));
    }
}
