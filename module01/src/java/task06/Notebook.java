package task06;

import java.util.Arrays;

/**
 * Класс представляет собой реализацию Блокнота.
 */
public class Notebook {

    /**
     * Поле представляющее название блокнота.
     */
    private String name;

    /**
     * Поле представляющее массив записей в этом блокноте.
     */
    private Note[] notes;

    /**
     * Конструктор для инициализации объектов класса.
     * @param name Название блокнота
     */
    public Notebook(String name){

        this.name = name;
        notes = new Note[0];
    }

    /**
     * Метод для добавления новой записи в блокнот
     * @param note объект класса Note для добавления в Блокнот.
     */
    public void addNote(Note note){

        Note[] newNotes = new Note[notes.length+1];
        System.arraycopy(notes,0,newNotes,0,notes.length);
        notes = newNotes;
        notes[notes.length-1] = note;
    }

    /**
     * Метод возвращающий количество записей в блокноте.
     * @return количество записей в блокноте
     */
    public int size(){
        return notes.length;
    }

    /**
     * Метод позволяющий удалить одну из имеющихся записей по её заголовку
     * @param title заголовок записи, которую нужно удалить
     */
    public void deleteNote(String title){

        notes = Arrays.stream(notes).filter(n -> !title.equals(n.getTitle())).toArray(Note[]::new);
    }

    /**
     * Метод изменения записи.
     * @param title Заголовок записи, которую нужно изменить
     * @param text Новый текст записи.
     */
    public void changeNote(String title,String text){

        notes = Arrays.stream(notes).filter(n -> !title.equals(n.getTitle())).toArray(Note[]::new);
        Note n = new Note(title,text);
        addNote(n);
    }

    /**
     * Отображает объект класса в String.
     * @return отображение объекта в String
     */
    public String toString(){
        return ("Notebook name: " + name)
                .concat(" size: "+notes.length)
                .concat(" notes: "+ Arrays.toString(notes));
    }
}
