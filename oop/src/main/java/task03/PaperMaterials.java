package task03;

import lombok.Getter;

/**
 * Created by wopqw on 17.09.16.
 */
@Getter
abstract class PaperMaterials extends Stationers {

    private int numberOfPages;

    PaperMaterials(String producer, String color, double price, int numberOfPages){

        super(producer, color, price);
        this.numberOfPages = numberOfPages;
    }

}
