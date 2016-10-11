package task01;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;


/**
 * Created by wopqw on 11.10.16.
 */
public class ByteIOStream implements IOStream {

    @Override
    @SneakyThrows
    public String readFromFile(String filePath){

        StringBuilder sBuilder = new StringBuilder();

        int data;

        try (FileInputStream fis = new FileInputStream(filePath)){

            while ((data = fis.read()) != -1) {
                sBuilder.append(( char ) data);
            }
            return new String(sBuilder.toString().getBytes("ISO-8859-1"),"UTF-8");
        }
    }


    @Override
    @SneakyThrows
    public void writeToFile(String text, String filePath){

        try(FileOutputStream fos =
                    new FileOutputStream(filePath)){

            fos.write(text.getBytes("ISO-8859-1"));
        }
    }
}
