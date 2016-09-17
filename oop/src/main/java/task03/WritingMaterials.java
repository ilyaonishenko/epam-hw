package task03;

import lombok.Data;

/**
 * Created by wopqw on 17.09.16.
 */

@Data
public abstract class WritingMaterials extends Stationers {

    private String producer;
    private String color;
    private String inkColor;

    public WritingMaterials(String producer,String color, String inkColor){

        super(producer, color);
        this.inkColor = inkColor;
    }

}
