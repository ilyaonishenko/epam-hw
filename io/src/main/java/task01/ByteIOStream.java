package task01;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

        try (FileInputStream fis = new FileInputStream(filePath)){

            while ((data = fis.read()) != -1) {
                sBuilder.append(( char ) data);
            }
            return new String(sBuilder.toString().getBytes("ISO-8859-1"),"UTF-8");
        }
    }


    @SneakyThrows
    static void writeToFile(String text, String filePath){

        try(FileOutputStream fos =
                    new FileOutputStream(filePath)){

            fos.write(text.getBytes("ISO-8859-1"));
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

    static void taskExample(String inputFile, String outputFile){

        String inputText = readFromFile(inputFile);
        writeToFile(processString(inputText).toString(),outputFile);
    }

}
