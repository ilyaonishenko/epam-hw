package task03;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by wopqw on 25.09.16.
 */
public class StarterKitTest {

    private StarterKit<Stationers> starterKit;

    private Pen pen = new Pen("Pilot", "blue", 215.23, "blue", false);
    private Notebook notebook = new Notebook("aTauras", "green", 231, 300, false);
    private Stickers stickers = new Stickers("ZCOMP","red",10,"SDKAWD","GOOD");
    private Notebook notebook1 = new Notebook("aTauras", "green", 500, 200, true);



    @Test
    public void testCollectionSize(){

        starterKit = new StarterKit<>();
        starterKit.add(pen);
        assertThat(starterKit.size(),is(1));
    }

    @Test
    public void testCollectionContain(){

        starterKit = new StarterKit<>();
        starterKit.add(pen);
        starterKit.add(notebook);
        assertThat(starterKit.get(0),is(pen));
        assertThat(starterKit.get(1),is(notebook));
    }

    @Test
    public void testProducerSorting(){

        starterKit = new StarterKit<>(pen,notebook,stickers,notebook1);
        starterKit.sort(Stationers.stationersProducerComparator);
        System.out.println(starterKit);

        assertThat(starterKit.get(0),is(notebook));
        assertThat(starterKit.get(3),is(stickers));

    }

    @Test
    public void testPriceSorting(){

        starterKit = new StarterKit<>(pen,notebook,stickers,notebook1);
        starterKit.sort(Stationers.stationersPriceComparator);
        System.out.println(starterKit);

        assertThat(starterKit.get(0),is(stickers));
        assertThat(starterKit.get(3),is(notebook1));
    }

    @Test
    public void testPriceAndProducerSorting(){

        starterKit = new StarterKit<>(pen,notebook,stickers,notebook1);
        starterKit.sort(Stationers.stationersPriceProdComparator);
        System.out.println(starterKit);

        assertThat(starterKit.get(0),is(notebook));
        assertThat(starterKit.get(3),is(stickers));
    }
}