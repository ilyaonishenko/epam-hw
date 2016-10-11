package task03;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 12.10.16.
 */
public class ByteSymbIOStreamTest {

    private static final String filePath1 = "src/test/resources/hello.txt";
    private static final String filePath2 = "src/test/resources/writeHello3";
    private static final String filePath3 = "src/main/java/task01/ByteIOStream.java";

    ByteSymbIOStream bsStream = new ByteSymbIOStream();

    @Test
    public void readFileTest(){
        assertThat(bsStream.readFromFile(filePath1),is("Привет мир!"));
    }

    @Test
    public void writeFileTest(){
        bsStream.writeToFile("Кодировка -- хрупкая вещь.",filePath2);
        assertThat(bsStream.readFromFile(filePath2),not("Кодировка -- хрупкая вещь."));
    }

}