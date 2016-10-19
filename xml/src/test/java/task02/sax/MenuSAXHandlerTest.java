package task02.sax;

import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import task02.model.Food;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 19.10.16.
 */
public class MenuSAXHandlerTest {

    @Test
    public void parse() throws SAXException, IOException {

        XMLReader reader = XMLReaderFactory.createXMLReader();
        MenuSAXHandler handler = new MenuSAXHandler();
        reader.setContentHandler(handler);
        reader.parse(new InputSource("src/test/resources/test.xml"));

        List<Food> menu = handler.getFoods();

        assertThat(menu.size(), is(5));
    }

}