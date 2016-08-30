package task06;

/**
 * Created by wopqw on 30.08.16.
 */
public class Task6 {

    public static void main(String[] args) {

        Notebook myNotebook = new Notebook("MyNotebook");
        Note myFirstNote = new Note("First","This is my first note");
        Note mySecondNote = new Note("Second","This is my second note");
        Note myThirdNote = new Note("Third","This is my third note");

        myNotebook.addNote(myFirstNote);
        myNotebook.addNote(mySecondNote);
        myNotebook.addNote(myThirdNote);

        System.out.println(myNotebook.size());
        System.out.println(myNotebook);

        myNotebook.deleteNote("Third");
        System.out.println(myNotebook.size());
        System.out.println(myNotebook);

        myNotebook.changeNote("Second", "This is my third note");
        System.out.println(myNotebook);
    }
}
