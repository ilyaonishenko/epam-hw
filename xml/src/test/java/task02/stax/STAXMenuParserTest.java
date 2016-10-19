package task02.stax;

import org.junit.Test;
import task02.model.Food;

import javax.xml.stream.XMLInputFactory;
import java.io.FileReader;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 20.10.16.
 */
@SuppressWarnings("WeakerAccess")
public class STAXMenuParserTest {

    public static final String FILE_NAME = "/Users/woqpw/GitHub/java/epam-hw/xml/src/test/resources/test.xml";

    @Test
    public void testSTAXMenuParser() throws Exception {

        try(FileReader fileReader = new FileReader(FILE_NAME)){
            ArrayList<Food> foods = STAXMenuParser.process(XMLInputFactory.newInstance().createXMLStreamReader(fileReader));

            assertThat(foods.size(),is(5));
        }
    }

}