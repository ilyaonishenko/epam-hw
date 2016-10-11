package task04;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * Created by wopqw on 12.10.16.
 */

@Value
@AllArgsConstructor
public class Actor implements Serializable {

    private String firstName;

    private String lastName;
}
