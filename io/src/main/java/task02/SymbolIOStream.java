package task02;

import lombok.SneakyThrows;
import task01.IOStream;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

/**
 * Created by wopqw on 11.10.16.
 */
public class SymbolIOStream implements IOStream {

    @Override
    @SneakyThrows
    public String readFromFile(String filePath){

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
    public void writeToFile(String text, String filePath){

        try(OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream(filePath))){

            osw.write(text);
        }
    }
}
