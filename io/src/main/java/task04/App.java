package task04;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wopqw on 12.10.16.
 */
public class App {

    private ArrayList<Movie> moviesCollection;

    public App(Movie... movies){

        moviesCollection = new ArrayList<>(Arrays.asList(movies));
    }

    @SneakyThrows
    public void serializeCollection(String filePath) {

        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filePath))) {

            oos.writeObject(moviesCollection);
        }
    }

    @SneakyThrows
    public void deserialize(String filePath) {

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filePath))) {

            moviesCollection = (ArrayList<Movie>) ois.readObject();
        }
    }

    public int moviesCollectionSize(){

        return moviesCollection.size();
    }

    public boolean containsMovie(Movie movie){

        return moviesCollection.contains(movie);
    }

    public void addMovie(Movie movie){

        moviesCollection.add(movie);
    }
}
