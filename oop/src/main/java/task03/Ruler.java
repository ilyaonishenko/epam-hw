package task03;

import lombok.Value;

/**
 * Created by wopqw on 17.09.16.
 */
@Value
public class Ruler extends SchemeTools {

    private int length;

    public Ruler(String producer, String color, String unit, double price, int length){

        super(producer, color, unit, price);
        this.length = length;
    }
}
