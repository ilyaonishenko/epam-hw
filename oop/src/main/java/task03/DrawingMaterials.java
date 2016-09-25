package task03;

import lombok.Getter;

/**
 * Created by wopqw on 17.09.16.
 */
@Getter
abstract class DrawingMaterials extends Stationers {

    DrawingMaterials(String producer, String color, double price){
        super(producer, color, price);
    }
}
