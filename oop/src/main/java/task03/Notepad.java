package task03;

import lombok.Data;

/**
 * Created by wopqw on 17.09.16.
 */
@Data
public class Notepad extends PaperMaterials {

    private String producer;
    private String color;
    private int numberOfPages;
    private String format;

    public Notepad(String producer, String color, int numberOfPages, String format){

        super(producer, color, numberOfPages);
        this.format = format;
    }
}
