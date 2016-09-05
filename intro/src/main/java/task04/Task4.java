package task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;

/**
 * Created by wopqw on 30.08.16.
 */
public class Task4 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите n");
        int n = Integer.parseInt(reader.readLine());
        int size = 2*n;

        double[] array = DoubleStream.iterate(1d, s-> generateRandomDouble(0,10)).limit(size).toArray();

        System.out.println("Максимум: "+findMax(array));

    }

    private static double generateRandomDouble(double min, double max){

        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }

    private static double findMax(double[] array){

        int N = array.length;
        int n = N/2;
        double[] newArray = new double[n];

        for(int i = 0; i < n; i++){
            newArray[i] = array[i]+array[N-1-i];
        }

        return Arrays.stream(newArray).max().getAsDouble();
    }

}
