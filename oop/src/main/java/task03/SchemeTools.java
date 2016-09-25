package task03;

import lombok.Getter;

/**
 * Created by wopqw on 17.09.16.
 */
@Getter
public abstract class SchemeTools extends DrawingMaterials {

    private String unit;

    public SchemeTools(String producer, String color, String unit, double price){

        super(producer, color, price);
        this.unit = unit;
    }
}
