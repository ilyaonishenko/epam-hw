package task02.DOM;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 20.10.16.
 */
public class DOMReaderTest {


    @SuppressWarnings("WeakerAccess")
    public static final String PATH = "/Users/woqpw/GitHub/java/epam-hw/xml/src/test/resources/test.xml";

    @Test
    public void parse() throws Exception {

        DOMReader reader = new DOMReader(PATH);

        assertThat(reader.parse().size(),is(5));
    }

}