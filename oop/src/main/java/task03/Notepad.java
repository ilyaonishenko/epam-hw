package task03;

import lombok.Value;

/**
 * Created by wopqw on 17.09.16.
 */
@Value
public class Notepad extends PaperMaterials {

    private String format;

    public Notepad(String producer, String color, double price, int numberOfPages, String format){

        super(producer, color, price, numberOfPages);
        this.format = format;
    }
}
