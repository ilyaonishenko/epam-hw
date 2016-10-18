package task01;

import lombok.SneakyThrows;
import task01.model.Customer;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Created by wopqw on 18.10.16.
 */

public class DatabaseOperator implements AutoCloseable {

    private Connection connection;

    private Statement statement;

    private PreparedStatement preparedStatement;

    private ResultSet resultSet;


    @SneakyThrows
    public DatabaseOperator(String pathToConfig, String pathToInit){

        Properties properties = new Properties();
        properties.load(new FileInputStream(pathToConfig));

        Class.forName(getValueAndRemoveKey(properties, "driver"));
        connection = DriverManager.getConnection(
                getValueAndRemoveKey(properties, "url"));
        statement = connection.createStatement();

        Arrays.stream(
                Files.lines(Paths.get(pathToInit))
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

    static String getValueAndRemoveKey(Properties properties, String key){

        return (String)properties.remove(key);
    }


    @Override
    public void close() throws Exception {

    }

    @SneakyThrows
    public ArrayList<Customer> getAllLines(){

        ArrayList<Customer> customers = new ArrayList<>();

        resultSet = statement.executeQuery("SELECT * FROM Customer");

        while (resultSet.next()){
            customers.add(new Customer(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getDate("birth_date").toLocalDate()));
        }

        return customers;
    }

    @SneakyThrows
    public void updateLine(Customer updatedCustomer){

        String sql = "UPDATE Customer "+
                "SET first_name = ?,"+
                "last_name = ?,"+
                "birth_date = ?"+
                "WHERE id = ?";

        preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1,updatedCustomer.getFirstName());
        preparedStatement.setString(2,updatedCustomer.getLastName());
        preparedStatement.setDate(3,Date.valueOf(updatedCustomer.getDob()));
        preparedStatement.setInt(4,updatedCustomer.getId());

        System.out.println(preparedStatement.execute());
    }

    @SneakyThrows
    public void insertNewLine(Customer newCustomer){

        String sql = "INSERT INTO Customer (id,first_name,last_name,birth_date) VALUES (?,?,?,?)";

        preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,newCustomer.getId());
        preparedStatement.setString(2,newCustomer.getFirstName());
        preparedStatement.setString(3,newCustomer.getLastName());
        preparedStatement.setDate(4,Date.valueOf(newCustomer.getDob()));

        preparedStatement.execute();
    }

    @SneakyThrows
    public Customer findLine(int id){

        String sql = "SELECT * FROM Customer WHERE id = ?";

        preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,id);

        resultSet = preparedStatement.executeQuery();

        if(resultSet.next()) {
            return new Customer(
                    resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getDate("birth_date").toLocalDate());
        }
        return new Customer(0,"","",null);
    }

    @SneakyThrows
    public void deleteLine(int id){

        String sql = "DELETE FROM Customer WHERE id =?";

        preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,id);

        preparedStatement.execute();
    }
}
