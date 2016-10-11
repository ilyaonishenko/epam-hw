package task01;
import org.junit.Test;
import java.util.HashMap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 11.10.16.
 */
public class ByteIOStreamTest {

    private static final String filePath1 = "src/test/resources/hello.txt";
    private static final String filePath2 = "src/test/resources/writeHello.txt";
    private static final String filePath3 = "src/main/java/task01/ByteIOStream.java";

    @Test
    public void readFromFileTest() throws Exception {

        assertThat(ByteIOStream.readFromFile(filePath1),is("Привет мир!"));
    }

    @Test
    public void writeToFileTest() throws Exception {

        String text = "I wrote it in the file\nIn two lines";
        ByteIOStream.writeToFile(text,filePath2);
        assertThat(ByteIOStream.readFromFile(filePath2),is(text));
    }

    @Test
    public void countKeywordAppereance(){

        String fileInString = ByteIOStream.readFromFile(filePath3);
        HashMap<String, Integer> map = ByteIOStream.processString(fileInString);
        assertThat(map.get("static"),is(3));
    }

    @Test
    public void replacementTest(){

        String bigString = "It is\nnew String\nand it will\nkeeewwwqqee ewqwe";
        assertThat(bigString.replaceAll("\n"," "),
                is("It is new String and it will keeewwwqqee ewqwe"));
    }

}