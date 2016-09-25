package task03;

import lombok.Value;

/**
 * Created by wopqw on 17.09.16.
 */
@Value
public class WritingPencil extends WritingMaterials {

    private boolean eraser;

    public WritingPencil(String producer, String color, double price, String inkColor, boolean eraser){

        super(producer, color, price, inkColor);
        this.eraser = eraser;
    }
}
