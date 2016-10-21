package task02.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Created by wopqw on 20.10.16.
 */

@Data
@Builder
@ToString(exclude = "id")
@AllArgsConstructor
public class Book {

    private long id;
    private String name;
    private String author;
    private String publisher;
}
