package task03;

import lombok.Data;

/**
 * Created by wopqw on 17.09.16.
 */
@Data
public class Ruler extends SchemeTools {

    private String producer;
    private String color;
    private String unit;
    private int length;

    public Ruler(String producer, String color, String unit, int length){

        super(producer, color, unit);
        this.length = length;
    }
}
