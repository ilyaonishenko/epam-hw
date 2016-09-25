package task03;

import lombok.Value;

/**
 * Created by wopqw on 17.09.16.
 */

@Value
public class Pen extends WritingMaterials {

    private boolean isGel;

    public Pen(String producer, String color, double price, String inkColor, boolean isGel){

        super(producer, color, price, inkColor);
        this.isGel = isGel;
    }
}
