package task05;

import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * Created by wopqw on 25.09.16.
 */
@Value
@AllArgsConstructor
public class Student {

    private String firstName;
    private String secondName;
    private int age;
}
