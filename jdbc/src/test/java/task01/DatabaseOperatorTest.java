package task01;

import org.junit.Test;
import task01.model.Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 18.10.16.
 */

@SuppressWarnings("WeakerAccess")
public class DatabaseOperatorTest {


    public static final String PATH_TO_CONFIG = "src/test/resources/db.properties";
    public static final String PATH_TO_INIT = "/Users/woqpw/GitHub/java/epam-hw/jdbc/src/test/resources/init.sql";
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.US);

    Customer customer =  new Customer(1,"Chris","Schaefer", LocalDate.parse("1981-05-03",formatter));

//TODO fix Optional.get()
//    TODO DAO objects?

    @Test
    public void getAllLines() throws Exception {


        try(DatabaseOperator dOperator = new DatabaseOperator(PATH_TO_CONFIG,PATH_TO_INIT)){

            ArrayList<Customer> customers = dOperator.getAllLines();
            assertThat(customers.stream().
                    filter(
                            c -> c.getFirstName().equals("Chris")
                                    &&c.getLastName().equals("Schaefer"))
                    .findAny().orElseThrow(IllegalArgumentException::new),is(customer));
        }
    }

    @Test
    public void updateLine() throws Exception {

        Customer customerIvanov = new Customer(1, "Chris","Ivanov", LocalDate.parse("1981-05-03",formatter));

        try(DatabaseOperator dOperator = new DatabaseOperator(PATH_TO_CONFIG,PATH_TO_INIT)){

            ArrayList<Customer> customers = dOperator.getAllLines();
            assertThat(customers.stream().
                    filter(
                            c -> c.getFirstName().equals("Chris")
                                    &&c.getLastName().equals("Schaefer"))
                    .findAny().orElseThrow(IllegalArgumentException::new),is(customer));

            dOperator.updateLine(customerIvanov);

            assertThat(dOperator.findLine(1),is(customerIvanov));
        }

    }

    @Test
    public void insertNewLine() throws Exception {

        try(DatabaseOperator dOperator = new DatabaseOperator(PATH_TO_CONFIG,PATH_TO_INIT)) {

            Customer petrov = new Customer(5, "Petr","Petrov",LocalDate.parse("2016-12-12",formatter));

            dOperator.insertNewLine(petrov);

            assertThat(dOperator.findLine(5),is(petrov));
        }

    }

    @Test
    public void findLine() throws Exception {
//        alredy twice tested
    }

    @Test
    public void deleteLine() throws Exception {

        try(DatabaseOperator dOperator = new DatabaseOperator(PATH_TO_CONFIG,PATH_TO_INIT)) {

            Customer petrov = new Customer(5,"Petr","Petrov",LocalDate.parse("2016-12-12",formatter));

            dOperator.insertNewLine(petrov);

            ArrayList<Customer> customers = dOperator.getAllLines();

            assertThat(customers.size(),is(5));

            dOperator.deleteLine(5);

            customers = dOperator.getAllLines();

            assertThat(customers.size(),is(4));
        }
    }

}