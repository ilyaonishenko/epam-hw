package task03;

import lombok.Data;

/**
 * Created by wopqw on 17.09.16.
 */
@Data
public abstract class PaperMaterials extends Stationers {

    private String producer;
    private String color;
    private int numberOfPages;

    public PaperMaterials(String producer, String color, int numberOfPages){

        super(producer, color);
        this.numberOfPages = numberOfPages;
    }

}
