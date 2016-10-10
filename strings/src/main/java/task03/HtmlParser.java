package task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wopqw on 09.10.16.
 *
 * File name:
 * Java.SE.03.Information handling_task_attachment.html
 */
public class HtmlParser {

    final static private String inputFile = "strings/src/main/resources/Java.SE.03.Information handling_task_attachment.html";

    private static ArrayList<String> textList = new ArrayList<>();

    private static ArrayList<String> sentencesList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        try (BufferedReader bReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(inputFile), "windows-1251"))) {

            String sCurr;

            while ((sCurr = bReader.readLine()) != null) {
                String subbed = substring(sCurr);
                if(subbed.length()!=0)
                    textList.add(subbed);
            }
        }

        textList.forEach(HtmlParser::divideToSentences);
        System.out.println(checkIsSuccessively());

    }

    static String substring(String text){

        Matcher m = Pattern.compile("(^[(<[a-z]+>)А-Я]).*[Рр]ис[.у].*?\\.").matcher(text);
        int st = 0;
        int en = 0;
        while(m.find()){
            st = m.start();
            en = m.end();
        }
        return text.substring(st,en).replaceAll("^<[a-z]*>","");
    }

    static void divideToSentences(String text){

        Matcher m = Pattern.compile("[А-Я].*?\\.(?=\\s\\D)").matcher(text);
        int st = 0;
        int en = 0;
        while(m.find()){
            st = m.start();
            en = m.end();
            subStringAndAdd(text,st,en,"[Рр]ис[.у]");
        }
        st = en+1;
        en = text.length();
        subStringAndAdd(text,st,en,"[Рр]ис[.у]");
    }

    static boolean checkIsSuccessively(){

        Matcher m;
        int tmp = 0;
        for (String s : sentencesList) {
            m = Pattern.compile("([Рр]ис[.у].*\\s)(\\d)").matcher(s);
            if (m.find()) {
                if (tmp == 0)
                    tmp = Integer.parseInt(m.group(2));
                else if (tmp > Integer.parseInt(m.group(2))){
                        return false;
                }
            }
        }
        return true;
    }

    private static void subStringAndAdd(String subString,int start, int end, String regex){

        String stringToAdd = subString.substring(start,end);

        Matcher m1 = Pattern.compile(regex).matcher(stringToAdd);

        if(m1.find())
            sentencesList.add(stringToAdd);
    }
}
