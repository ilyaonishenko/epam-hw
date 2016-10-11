package task02;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by wopqw on 11.10.16.
 */
public class SymbolIOStreamTest {

    private static final String filePath1 = "src/test/resources/hello.txt";
    private static final String filePath2 = "src/test/resources/writeHello2";
    private static final String filePath3 = "src/main/java/task01/ByteIOStream.java";


    @Test
    public void readFromFile() throws Exception {
        assertThat(SymbolIOStream.readFromFile(filePath1),is("Привет мир!"));
    }

    @Test
    public void writeToFile() throws Exception {

        String text = "I wrote it in the file again\nIn three lines\nnow";
        SymbolIOStream.writeToFile(text,filePath2);
        assertThat(SymbolIOStream.readFromFile(filePath2),is(text));

    }

    @Test
    public void countKeywordAppereance(){

        String fileInString = SymbolIOStream.readFromFile(filePath3);
        HashMap<String, Integer> map = SymbolIOStream.processString(fileInString);
        assertThat(map.get("static"),is(3));
    }

    @Test
    public void replacementTest(){

        String bigString = "It is\nnew String\nand it will\nkeeewwwqqee ewqwe";
        assertThat(bigString.replaceAll("\n"," "),
                is("It is new String and it will keeewwwqqee ewqwe"));
    }

    @Test
    public void readWriteProcessTest(){

        SymbolIOStream.taskExample(filePath3,"src/test/resources/symbolOutput.txt");

    }
}