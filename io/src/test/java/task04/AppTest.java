package task04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 12.10.16.
 */
public class AppTest {

    String filePath = "src/test/resources/serializeCollection.txt";


    Movie[] movies = new Movie[]{
            new Movie("Movie1","Director1",
                    new ArrayList<>(Arrays.asList(
                            new Actor[]{
                                    new Actor("firstName1", "lastName1")}))),
            new Movie("Movie2","Director2",
                    new ArrayList<>(Arrays.asList(
                            new Actor[]{
                                    new Actor("firstName2", "lastName2"),
                                    new Actor("firstName3", "lastName3")})))};

    App app = new App(movies);

    @Test
    public void serializeTest() throws Exception {

        app.serializeCollection(filePath);
    }

    @Test
    public void deserializeTest(){

        app.deserialize(filePath);
        assertThat(app.moviesCollectionSize(),is(2));
        assertThat(app.containsMovie(movies[0]),is(true));
    }

    @Test
    public void addingTest(){

        app.addMovie(new Movie("Movie3","Director3",
                new ArrayList<>(Arrays.asList(
                    new Actor[]{
                        new Actor("firstName4", "lastName4")}))));
        assertThat(app.moviesCollectionSize(),is(3));
    }

}