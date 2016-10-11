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

    ByteIOStream byteStream = new ByteIOStream();

    @Test
    public void readFromFileTest() throws Exception {

        assertThat(byteStream.readFromFile(filePath1),is("Привет мир!"));
    }

    @Test
    public void writeToFileTest() throws Exception {

        String text = "I wrote it in the file\nIn two lines";
        byteStream.writeToFile(text,filePath2);
        assertThat(byteStream.readFromFile(filePath2),is(text));
    }

    @Test
    public void countKeywordAppereance(){

        String fileInString = byteStream.readFromFile(filePath3);
        HashMap<String, Integer> map = byteStream.processString(fileInString);
        assertThat(map.get("new"),is(4));
    }

    @Test
    public void replacementTest(){

        String bigString = "It is\nnew String\nand it will\nkeeewwwqqee ewqwe";
        assertThat(bigString.replaceAll("\n"," "),
                is("It is new String and it will keeewwwqqee ewqwe"));
    }

    @Test
    public void readWriteProcessTest(){

        byteStream.taskExample(filePath3,"src/test/resources/byteOutput.txt");

    }

}