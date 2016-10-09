package task02;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Created by wopqw on 08.10.16.
 * Convert UTF-8 file to ISO-8859-1
 * native2ascii -encoding UTF-8 QuestionBundle_ru_RU.properties QuestionBundle_ru_RU.properties
 */
public class App {

    private ResourceBundle resourceBundle;

    private Locale locale;

    private ArrayList<String> questionList;

    private HashMap<Integer, String> questionMap;


    public App(Language language) {

        switch (language) {
            case EN:
                locale = new Locale("en", "US");
                break;
            case RU:
                locale = new Locale("ru", "RU");
                break;
        }

        resourceBundle = ResourceBundle.getBundle("QuestionBundle", locale);
        createQuestionList();
    }

    @SneakyThrows
    private void createQuestionList(){

        String valRU =  new String(resourceBundle.keySet().toString().getBytes("ISO-8859-1"), "UTF-8");
        questionList = new ArrayList<>(Arrays.asList(StringUtils.strip(valRU,"[,]").split(", ")));
        questionMap = new HashMap<>();
        for (String s :
                questionList) {
            questionMap.put(questionList.indexOf(s),s);
        }
    }

    public void printQuestions(){

        for (Map.Entry<Integer, String> e :
                questionMap.entrySet()) {
            System.out.println(e.getKey()+")"+e.getValue());
        }
    }

    @SneakyThrows
    public String answerTheQuestion(int number){

        return new String(resourceBundle.getString(
                new String(questionMap.get(number).getBytes("UTF-8"),"ISO-8859-1"))
                .getBytes("ISO-8859-1"),"UTF-8");
    }
}
