package task03;

import lombok.Value;

/**
 * Created by wopqw on 17.09.16.
 */
@Value
public class Protractor extends SchemeTools {

    private double angle;

    public Protractor(String producer, String color, String unit, double price, double angle){

        super(producer, color, unit, price);
        this.angle = angle;
    }
}
