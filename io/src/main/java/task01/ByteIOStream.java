package task01;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;


/**
 * Created by wopqw on 11.10.16.
 */
interface ByteIOStream {

    @SneakyThrows
    static String readFromFile(String filePath){

        StringBuilder sBuilder = new StringBuilder();

        int data;

        try (InputStreamReader isr = new InputStreamReader(
                new FileInputStream(filePath))){

            while ((data = isr.read()) != -1) {
                sBuilder.append(( char ) data);
            }
            return sBuilder.toString();
        }
    }


    @SneakyThrows
    static void writeToFile(String text, String filePath){

        try(OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream(filePath))){

            osw.write(text);
        }
    }

    static HashMap<String,Integer> processString(String text){

        HashMap<String, Integer> answerMap = new HashMap();

        String[] keywords = Arrays.stream(text.replaceAll("\n"," ").split(" "))
                .filter(JavaKeywords::contains)
                .toArray(String[]::new);

        Arrays.stream(keywords)
                .forEach(w -> {
                    Integer old = Optional.ofNullable(answerMap.get(w)).orElse(0);
                    answerMap.put(w,old+1);
                });


        return answerMap;
    }

}
