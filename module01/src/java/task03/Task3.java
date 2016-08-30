package task03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wopqw on 30.08.16.
 */
public class Task3 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите начало отрезка:");
        double a = Double.parseDouble(reader.readLine());

        System.out.println("Введите конец отрезка:");
        double b = Double.parseDouble(reader.readLine());

        System.out.println("Введите шаг:");
        double h = Double.parseDouble(reader.readLine());

        Map<Double,Double> map = Stream.iterate(a, n -> n+h).limit((long) ((b-a)/h)).collect(Collectors.toMap(i->i, Task3::func));

        for(Map.Entry entry: map.entrySet()){
            System.out.println(entry.getKey()+" -- "+entry.getValue());
        }
    }

    private static double func(double x){
        return (Math.tan(2*x)-3);
    }
}
