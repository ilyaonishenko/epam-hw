package task02.dao.h2;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import task02.dao.interfaces.BookDAO;
import task02.model.Book;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Created by wopqw on 21.10.16.
 */
@AllArgsConstructor
public class H2BookDAO implements BookDAO {

    private Supplier<Connection> connectionSupplier;

    @Override
    @SneakyThrows
    public Collection<Book> getAll() {

        Collection<Book> books = new HashSet<>();

        try(Connection connection = connectionSupplier.get()){

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, name, author, publisher FROM Book");
            Book.BookBuilder bookBuilder = Book.builder();
            while (rs.next()){
                books.add(
                        bookBuilder
                                .id(rs.getInt("id"))
                                .name(rs.getString("name"))
                                .author(rs.getString("author"))
                                .publisher(rs.getString("publisher"))
                                .build());
            }

        }
        return books;
    }

    @Override
    @SneakyThrows
    public void update(Book book) {

        try(Connection connection = connectionSupplier.get()){

            String sql = "UPDATE Book SET name = ?, author = ?, publisher = ? WHERE id = ?";
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setString(1,book.getName());
            pStatement.setString(2,book.getAuthor());
            pStatement.setString(3,book.getPublisher());
            pStatement.setLong(4,book.getId());

            pStatement.execute();
        }
    }

    @Override
    @SneakyThrows
    public void delete(long id) {

        try(Connection connection = connectionSupplier.get()){
            String sql = "DELETE FROM Customer WHERE id =?";
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1,id);
            pStatement.execute();
        }
    }

    @Override
    @SneakyThrows
    public void insert(Book book) {

        try(Connection connection = connectionSupplier.get()){

            String sql = "INSERT INTO Book (id, name, author, publisher) VALUES (?,?,?,?)";

            PreparedStatement pStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

//            Integer smth = Optional.ofNullable(pStatement.executeUpdate()).orElseThrow(SQLException::new);

            if (Optional.ofNullable(pStatement.executeUpdate()).isPresent()) {

                try (ResultSet rs = pStatement.getGeneratedKeys()) {
                    if (rs.next())
                        book.setId(rs.getLong("id"));
                }

                pStatement.setLong(1, book.getId());
                pStatement.setString(2, book.getName());
                pStatement.setString(3, book.getAuthor());
                pStatement.setString(4, book.getPublisher());

                pStatement.execute();
            } else {
                throw new SQLException("Creating user failed.");
            }

        }

    }
}
