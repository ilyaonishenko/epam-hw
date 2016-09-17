package task03;

import lombok.Data;

/**
 * Created by wopqw on 17.09.16.
 */
@Data
public abstract class OfficeMaterials extends Stationers {

    private String producer;
    private String color;
    private String codeNumber;

    public OfficeMaterials(String producer, String color, String codeNumber) {

        super(producer, color);
        this.codeNumber = codeNumber;
    }
}
