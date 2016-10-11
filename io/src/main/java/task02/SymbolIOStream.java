package task02;

import lombok.SneakyThrows;
import task01.JavaKeywords;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

/**
 * Created by wopqw on 11.10.16.
 */
public interface SymbolIOStream {

    @SneakyThrows
    static String readFromFile(String filePath){

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

    static void taskExample(String inputFile, String outputFile){

        String inputText = readFromFile(inputFile);
        writeToFile(processString(inputText).toString(),outputFile);
    }
}
