package task03;

import lombok.Data;

/**
 * Created by wopqw on 17.09.16.
 */
@Data
public class Eraser extends DrawingMaterials {

    private String producer;
    private String color;
    private String shape;

    public Eraser(String producer, String color, String shape){

        super(producer, color);
        this.shape = shape;
    }
}
