package task03;

/**
 * Created by wopqw on 17.09.16.
 */
public class WritingPencil extends WritingMaterials {

    private String producer;
    private String color;
    private String inkColor;
    private boolean eraser;

    public WritingPencil(String producer, String color, String inkColor, boolean eraser){

        super(producer, color, inkColor);
        this.eraser = eraser;
    }

    @Override
    public String getProducer() {
        return producer;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getInkColor() {
        return inkColor;
    }

    public boolean hasEraser() {
        return eraser;
    }
}
