package task03;

import lombok.Value;

/**
 * Created by wopqw on 17.09.16.
 */

@Value
public class Marker extends WritingMaterials {

    private boolean isFull;

    public Marker(String producer, String color,  double price, String inkColor, boolean isFull){

        super(producer, color, price, inkColor);
        this.isFull = isFull;
    }
}
