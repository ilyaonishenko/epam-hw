package task03;

import lombok.Data;

/**
 * Created by wopqw on 17.09.16.
 */

@Data
public class Marker extends WritingMaterials {

    private String producer;
    private String color;
    private String inkColor;
    private boolean isFull;

    public Marker(String producer, String color, String inkColor, boolean isFull){

        super(producer, color, inkColor);
        this.isFull = isFull;
    }
}
