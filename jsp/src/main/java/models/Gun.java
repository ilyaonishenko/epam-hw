package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Created by wopqw on 25.10.16.
 */
@Data
@Builder
@ToString(exclude = "id")
@AllArgsConstructor
public class Gun {

    private long id;
    private String name;
    private double caliber;
    private double price;
}
