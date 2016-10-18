package task01.model;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDate;

/**
 * Created by wopqw on 18.10.16.
 */
@Value
@AllArgsConstructor
public class Customer {

    private int id;

    private String firstName;

    private String lastName;

    private LocalDate dob;

}
