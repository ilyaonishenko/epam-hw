package task03;

import lombok.Data;

/**
 * Created by wopqw on 17.09.16.
 */
@Data
public abstract class SchemeTools extends DrawingMaterials {

    private String producer;
    private String color;
    private String unit;

    public SchemeTools(String producer, String color, String unit){

        super(producer, color);
        this.unit = unit;
    }
}
