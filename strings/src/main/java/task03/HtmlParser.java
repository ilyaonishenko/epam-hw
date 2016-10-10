package task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
//    final static private String outputFile2 = "strings/src/main/resources/output2.txt";

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
//
//        textList.forEach(System.out::println);

        textList.forEach(HtmlParser::divideToSentences);
//        System.out.println(sentencesList.get(0));
        System.out.println(checkIsSuccessively());


//        try(BufferedWriter bWriter = new BufferedWriter(
//                new OutputStreamWriter(
//                        new FileOutputStream(outputFile2)
//                )
//        )){
//            for (String s :
//                    sentencesList) {
//                bWriter.write(s+"\n");
//                bWriter.newLine();
//            }
//        }

//        String text = "Предлагаю учёным изучить неоспоримые доказательства рождения новой физики, в статье дано описание структуры ядер атомов, атомов и, конкректно ядер атомов &nbsp;углерода (12С) в структурах графита, фуллерена, алмаза, графена, в неорганических и органических молекулах. Изучите описание неэлектростатических зарядов (спина) в силовой структуре чешуек графита, магнетонные силы притяжения между чешйками графита в структуре алмаза, истинную структуру нанотрубок и трубок фуллерена. Предлагаю учёным, научным коллективам активно участвовать в дальнейшей разработке новой единой концепции физического мироустройства. Новое описание истинной структуры ядра атома углерода основано на универсальных свойствах коллапсаров-нуклонов в силовых структурах трёх альф, расположенных в ядерной трубке атома углерода с взаимным относительным смещением на 60 (рис. 8).";
//        divideToSentences(text);
//        System.out.println(sentencesList.size());

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
//        System.out.println("text len: "+text.length());
        int st = 0;
        int en = 0;
        while(m.find()){
            st = m.start();
//            System.out.println("st: "+st);
            en = m.end();
//            System.out.println("en: "+en);
            String stringToAdd = text.substring(st,en);
            Matcher m1 = Pattern.compile("[Рр]ис[.у]").matcher(stringToAdd);
            if(m1.find()){
                sentencesList.add(stringToAdd);
            }

        }
        st = en+1;
        en = text.length();
        String stringToAdd = text.substring(st,en);
        Matcher m1 = Pattern.compile("[Рр]ис[.у]").matcher(stringToAdd);
        if(m1.find()){
            sentencesList.add(stringToAdd);
        }
    }

    static boolean checkIsSuccessively(){

        Matcher m;
        int tmp = 0;
        for (String s :
                sentencesList) {
//            System.out.println(s);
            m = Pattern.compile("([Рр]ис[.у].*\\s)(\\d)").matcher(s);
            if(m.find()){
                if (tmp == 0)
                    tmp = Integer.parseInt(m.group(2));
                else {
                    if (tmp > Integer.parseInt(m.group(2)))
                        return false;
                }

            }
        }
//        m = Pattern.compile("([Рр]ис[.у].*\\s)(\\d)").matcher(s);
//        if (m.find()){
//        }
        return true;
    }
//    static String deleteTegs(String text){
//        Matcher m = Pattern.compile("^<[a-z]*>").matcher(text);
//        text.replaceAll()
//    }


//    ((.*\.)(?=.*[Рр]ис[.у].*?\.))
//    (^[(<[a-z]+>)\(]*)[Рр]ис[.у].*?\.

    static void getAllSentences(String text){
//        [^.]*([Рр]ис.+?\.)
//        [Рр]ис.+?\.\s
//1145\\1154
//        [Рр]ис[.у].*?\.\s[А-Я]
//        [Рр]ис[.у].*?\.(?=\s[А-Я])
//        [Рр]ис[.у].*?\.(?=[<(\sА-Я)])
//        [Рр]ис[.у].*?\.(?=[<\s][/a-zА-я])
//        [\s(][Рр]ис[.у].*?\.(?=[<\s][/a-zА-я])
//        (^<)*[a-z]>.*[Рр]ис[.у].*?\.(?=[<\s][/a-zА-я])
//        ((?=^<)*[a-z]>.*)[\s(<][Рр]ис[.у].*?\.(?=[<\s][/a-zА-я])

//        (^[(<[a-z]+>)А-Я]).*[Рр]ис[.у].*?\.
//        List<String> allMatches = new ArrayList<String>();
////        Pattern p = Pattern.compile("(^[(<[a-z]+>)А-Я]).*[Рр]ис[.у].*?\\.");
////        Matcher m = p.matcher(text);
////        System.out.println(text);
//        Matcher m = Pattern.compile("(^[(<[a-z]+>)А-Я]).*[Рр]ис[.у].*?\\.").matcher(text);
//        m.group();
//
//        while (m.find())
//            allMatches.add(m.group());
////
//        System.out.println(allMatches);
        String regex = "(^[(<[a-z]+>)А-Я]).*[Рр]ис[.у].*?\\.";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        List<String> matches = new ArrayList<>();
        while(m.find()){
            matches.add(m.group());
        }
        System.out.println(matches.get(1));
    }


}
