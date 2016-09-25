package task03;

import lombok.Value;

/**
 * Created by wopqw on 17.09.16.
 */

@Value
public class Notebook extends PaperMaterials {

    private boolean pictureOnFrontPage;

    public Notebook(String producer, String color, double price, int numberOfPages, boolean pictureOnFrontPage){

        super(producer,color, price, numberOfPages);
        this.pictureOnFrontPage = pictureOnFrontPage;
    }
}
