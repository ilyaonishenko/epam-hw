package task03;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by wopqw on 17.09.16.
 */

@Getter
@AllArgsConstructor
abstract class Stationers {
    private String producer;
    private String color;
    private double price;
}
