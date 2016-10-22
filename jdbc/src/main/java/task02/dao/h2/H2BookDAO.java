package task02.dao.h2;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import task02.common.ConnectionPool;
import task02.dao.interfaces.BookDAO;
import task02.model.Book;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by wopqw on 21.10.16.
 */
@SuppressWarnings("SqlResolve")
@Log
@AllArgsConstructor
public class H2BookDAO implements BookDAO {

    private ConnectionPool connectionPool;

    @Override
    @SneakyThrows
    public Collection<Book> getAll() {

        Collection<Book> books = new HashSet<>();

        try(Connection connection = connectionPool.getConnection()){

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

        try(Connection connection = connectionPool.getConnection()){

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

        try(Connection connection = connectionPool.getConnection()){
            String sql = "DELETE FROM Book WHERE id =?";
            PreparedStatement pStatement = connection.prepareStatement(sql);
            pStatement.setLong(1,id);
            pStatement.execute();
        }
    }

    @Override
    @SneakyThrows
    public void insert(Book book) {

        try(Connection connection = connectionPool.getConnection()){

            String sql = "INSERT INTO Book (name, author, publisher) VALUES (?,?,?)";

            PreparedStatement pStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pStatement.setString(1, book.getName());
            pStatement.setString(2, book.getAuthor());
            pStatement.setString(3, book.getPublisher());
//            Integer smth = Optional.ofNullable(pStatement.executeUpdate()).orElseThrow(SQLException::new);

//            if (Optional.ofNullable(pStatement.executeUpdate()).isPresent()) {
            if(pStatement.executeUpdate() != 0){
                try (ResultSet rs = pStatement.getGeneratedKeys()) {
//                    log.info(rs.toString());
                    if (rs.next())
                        book.setId(rs.getLong(1));
                }
                log.info("here must be id: "+String.valueOf(book.getId()));
                pStatement.setLong(1, book.getId());
            } else {
                throw new SQLException("Creating user failed.");
            }

        }

    }
}
