package task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wopqw on 29.08.16.
 */
public class Task2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите количество элментов n:");
        int number = Integer.parseInt(reader.readLine());

        System.out.println("Введите условие: е");
        double e = Double.parseDouble(reader.readLine());

        List<Double> list = Stream.iterate(1d, n -> 1/Math.pow(n+1,2)).limit(number).collect(Collectors.toList());
        int i = list.indexOf(list.stream().filter(aDouble -> aDouble<e).findFirst().get());

        System.out.println("Наименьший номер элемента последовательности уд. условию: "+ i +"\nВся последовательность:");

        list.forEach(System.out::println);
    }

}
