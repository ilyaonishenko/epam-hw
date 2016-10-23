package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Created by wopqw on 23.10.16.
 */
@Data
@Builder
@ToString(exclude = "id")
@AllArgsConstructor
public class Person {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
