package task03;

import lombok.Data;

/**
 * Created by wopqw on 17.09.16.
 */

@Data
public class Notebook extends PaperMaterials {

    private String producer;
    private String color;
    private int numberOfPages;
    private boolean pictureOnFrontPage;

    public Notebook(String producer, String color, int numberOfPages, boolean pictureOnFrontPage){

        super(producer,color,numberOfPages);
        this.pictureOnFrontPage = pictureOnFrontPage;
    }
}
