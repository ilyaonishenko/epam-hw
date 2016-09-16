package task01;

/**
 * Created by wopqw on 17.09.16.
 *
 * Класс представляет собой реализацию объекта task01.Pen, который имеет такие параметры как {@code name}, {@code color}, {@code type}
 * В этом классе переопределены методы {@code toString()}, {@code equals()} и {@code hashCode()}
 */
public class Pen {

    /**
     * Название ручки.
     */
    private String name;

    /**
     * Цвет ручки.
     */
    private String color;

    /**
     * Содержит в себе информацию, является ли ручка гелевой.
     */
    private boolean type;

    public Pen(String name, String color,boolean type ){

        this.name = name;
        this.color = color;
        this.type = type;
    }


    public String getName() {

        return name;
    }

    public String getColor() {

        return color;
    }

    public boolean isGel() {

        return type;
    }

    /**
     * Переопределенный метод toString()
     * @return
     */
    @Override
    public String toString(){

        return ("task01.Pen[Name: " + this.name) +
                ", Color: " + this.color +
                ", Gel: " + this.type +
                "]";
    }

    /**
     * Переопределенный метод equals
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Pen pen = (Pen) obj;

        if (type != pen.type) {
            return false;
        }
        if (!name.equals(pen.name)) {
            return false;
        }
        return color.equals(pen.color);

    }

    /**
     * Переопределенный метод equals
     * @return int
     */
    @Override
    public int hashCode() {

        int result = name.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + (type ? 1 : 0);
        return result;
    }
}
