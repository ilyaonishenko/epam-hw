package task03;

import lombok.Value;

/**
 * Created by wopqw on 17.09.16.
 */
@Value
public class Clip extends OfficeMaterials {

    private String material;

    public Clip(String producer, String color, double price, String codeNumber, String material){

        super(producer, color, price, codeNumber);
        this.material = material;
    }
}
