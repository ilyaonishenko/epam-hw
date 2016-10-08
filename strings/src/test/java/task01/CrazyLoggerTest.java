package task01;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 08.10.16.
 */
public class CrazyLoggerTest {

    CrazyLogger crazyLogger = new CrazyLogger();

    @Test
    public void containsText() throws Exception {

        String message = "Hello worlds!";
        String message2 = "New Hello World!";
        crazyLogger.log(message);
        crazyLogger.log(message2);

        assertThat(crazyLogger.contains(message),is(true));
    }

    @Test
    public void testTest(){

        String message = "HELLO WORLD";
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-YYYY:hh-mm--");

        sb.append(sdf.format(new Date())).append(message);

        String text = sb.toString();

        assertThat(text.contains(message),is(true));
    }

    @Test
    public void containsDate(){

        String message = "Hey you!";
        crazyLogger.log(message);
        Date date = new Date();

        assertThat(crazyLogger.contains(date),is(true));
    }

}