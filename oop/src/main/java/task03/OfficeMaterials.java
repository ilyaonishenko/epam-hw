package task03;

import lombok.Getter;

/**
 * Created by wopqw on 17.09.16.
 */
@Getter
abstract class OfficeMaterials extends Stationers {

    private String codeNumber;

    OfficeMaterials(String producer, String color, double price, String codeNumber) {

        super(producer, color, price);
        this.codeNumber = codeNumber;
    }
}
