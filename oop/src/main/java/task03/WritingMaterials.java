package task03;

import lombok.Getter;

/**
 * Created by wopqw on 17.09.16.
 */

@Getter
abstract class WritingMaterials extends Stationers {

    private String inkColor;

    WritingMaterials(String producer, String color,double price, String inkColor){

        super(producer, color, price);
        this.inkColor = inkColor;
    }

}
