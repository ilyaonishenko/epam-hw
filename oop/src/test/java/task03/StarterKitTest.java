package task03;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by wopqw on 25.09.16.
 */
public class StarterKitTest {

    StarterKit starterKit;

    @Test
    public void testCollectionSize(){

        starterKit = new StarterKit();
        starterKit.add(new Pen("Pilot","blue",215.23,"blue",false));
        assertThat(starterKit.size(),is(1));
    }

    @Test
    public void testCollectionContain(){

        starterKit = new StarterKit();
        Pen pen = new Pen("Pilot","blue",215.23,"blue",false);
        Notebook notebook = new Notebook("aTauras","green",231,300,false);
        starterKit.add(pen);
        starterKit.add(new Notebook("Pilot","blue",215.23,300,false));
        assertThat(starterKit.get(0),is(new Pen("Pilot","blue",215.23,"blue",false)));
        assertThat(starterKit.get(1),is(notebook));
    }
}