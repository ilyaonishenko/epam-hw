package task03;

import lombok.Data;

/**
 * Created by wopqw on 17.09.16.
 */
@Data
public class Stickers extends OfficeMaterials {

    private String producer;
    private String color;
    private String codeNumber;
    private String format;

    public Stickers(String producer, String color, String codeNumber, String format){

        super(producer, color, codeNumber);
        this.format = format;
    }
}
