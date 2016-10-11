package task04;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by wopqw on 12.10.16.
 */
@Value
@AllArgsConstructor
public class Movie implements Serializable {

    private String name;

    private String director;

    private ArrayList<Actor> actors;
}
