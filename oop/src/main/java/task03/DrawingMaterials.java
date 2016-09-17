package task03;

import lombok.Data;

/**
 * Created by wopqw on 17.09.16.
 */
@Data
public abstract class DrawingMaterials extends Stationers {

    private String producer;
    private String color;

    public DrawingMaterials(String producer, String color){

        super(producer, color);
    }
}
