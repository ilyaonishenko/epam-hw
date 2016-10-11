package task03;

import lombok.SneakyThrows;
import task01.IOStream;

import java.io.FileOutputStream;
import java.io.FileReader;

/**
 * Created by wopqw on 11.10.16.
 */
public class ByteSymbIOStream implements IOStream {

    @Override
    @SneakyThrows
    public String readFromFile(String filePath) {

        StringBuilder sBuilder = new StringBuilder();

        int data;

        try(FileReader fReader =
                    new FileReader(filePath)){

            while ((data = fReader.read()) != -1){
                sBuilder.append((char) data);
            }
        }
        return sBuilder.toString();
    }

    @Override
    @SneakyThrows
    public void writeToFile(String text, String filePath) {

        try(FileOutputStream fos =
                    new FileOutputStream(filePath)){

            fos.write(text.getBytes("UTF-16"));
        }
    }
}
