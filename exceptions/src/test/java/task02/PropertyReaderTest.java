package task02;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 16.10.16.
 */
public class PropertyReaderTest {

    public static final String PATH = "src/test/resources/someThings.properties";

    @Test
    public void readPropFile() throws Exception {

        try(PropertyReader pReader = new PropertyReader(PATH)){

            assertThat(pReader.readProperty("firstName"),is("Ivan"));
            assertThat(pReader.readProperty("lastName"),is("Ivanov"));
            assertThat(pReader.readProperty("age"),is("18"));
        }
    }

    @Test
    public void testExceptionThrow() throws FileNotFoundException, IOException{

        try(PropertyReader pReader = new PropertyReader(PATH)){
            assertThat(pReader.readProperty("ages"),is("18"));
        } catch (NoSuchPropertyException e){
            assertThat(e.getMessage(),is("No such property in this file!"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}