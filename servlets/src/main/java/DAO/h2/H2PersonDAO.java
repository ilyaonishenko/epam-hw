package DAO.h2;

import DAO.PersonDAO;
import DAO.common.ConnectionPool;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import model.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by wopqw on 23.10.16.
 */

@AllArgsConstructor
public class H2PersonDAO implements PersonDAO {

//    private static final String PATH = "/Users/woqpw/GitHub/java/epam-hw/servlets/src/main/resources/";

    private ConnectionPool connectionPool;

    @Override
    @SneakyThrows
    public Collection<Person> getAll() {

        Collection<Person> persons = new HashSet<>();

        try(Connection connection = connectionPool.getConnection()){

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, first_name, last_name, email, password FROM Person");
            Person.PersonBuilder bookBuilder = Person.builder();
            while (rs.next()){
                persons.add(
                        bookBuilder
                                .id(rs.getInt("id"))
                                .firstName(rs.getString("first_name"))
                                .lastName(rs.getString("last_name"))
                                .email(rs.getString("email"))
                                .password(rs.getString("password"))
                                .build());
            }

        }
        return persons;
    }
}
