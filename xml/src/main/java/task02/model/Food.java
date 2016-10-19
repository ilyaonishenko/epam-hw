package task02.model;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by wopqw on 19.10.16.
 */

@Data
@ToString(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "name", "price", "description", "calories" })
public class Food {

    private int id;
    private String name;
    private String price;
    private String description;
    private int calories;
}
