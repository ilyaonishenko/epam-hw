package task03;

import lombok.Data;

/**
 * Created by wopqw on 17.09.16.
 */
@Data
public class Protractor extends SchemeTools {

    private String producer;
    private String color;
    private String unit;
    private double angle;

    public Protractor(String producer, String color, String unit, double angle){

        super(producer, color, unit);
        this.angle = angle;
    }
}
