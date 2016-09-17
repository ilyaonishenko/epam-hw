package task03;

import lombok.Data;

/**
 * Created by wopqw on 17.09.16.
 */

@Data
public class Pen extends WritingMaterials {

    private String producer;
    private String color;
    private String inkColor;
    private boolean isGel;

    public Pen(String producer, String color, String inkColor, boolean isGel){

        super(producer, color, inkColor);
        this.isGel = isGel;
    }
}
