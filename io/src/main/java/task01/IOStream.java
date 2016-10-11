package task01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

/**
 * Created by wopqw on 11.10.16.
 */
public interface IOStream {

    String readFromFile(String filePath);

    void writeToFile(String text, String filePath);

    default HashMap<String,Integer> processString(String text){

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

    default void taskExample(String inputFile, String outputFile){

        String inputText = readFromFile(inputFile);
        writeToFile(processString(inputText).toString(),outputFile);
    }
}
