package task06;

/**
 * Класс представляет собой Запись в блокноте.
 *
 */
public class Note {
    /**
     * Поле представляющее заголовок записи.
     */
    private String title;

    /**
     * Поле представляющее содержание записи.
     */
    private String text;

    /**
     * Конструктор для инициализации объектов класса.
     * @param text Содержание записи
     */
    public Note(String text){
        this("NoName", text);
    }

    /**
     * Основной конструктор для инициализации объектов класса.
     * @param title Заголовок записи
     * @param text Содержание записи
     */
    public Note(String title, String text){
        this.title = title;
        this.text = text;
    }

    /**
     * Возвращает заголовок записи.
     * @return Заголовок записи
     */
    public String getTitle() {
        return title;
    }

    /**
     * Возвращает содержание записи.
     * @return содержание записи
     */
    public String getText() {
        return text;
    }

    /**
     * Позволяет заменить старое содержание записи.
     * @param text Новое содержание записи.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Отображает объект класса в String.
     * @return отображение объекта в String
     */
    public String toString(){
        return "NOTE: title: " + title + " text: " + text;
    }
}
