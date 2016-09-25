package task03;

import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * Created by wopqw on 17.09.16.
 */

@Value
@AllArgsConstructor
abstract class Stationers {
    private String producer;
    private String color;
    private double price;
}
