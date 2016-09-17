package task03;

import lombok.Data;

/**
 * Created by wopqw on 17.09.16.
 */
@Data
public class Clip extends OfficeMaterials {

    private String producer;
    private String color;
    private String codeNumber;
    private String material;

    public Clip(String producer, String color, String codeNumber, String material){

        super(producer, color, codeNumber);
        this.material = material;
    }
}
