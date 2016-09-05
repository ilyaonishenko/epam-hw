package task05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by wopqw on 30.08.16.
 */
public class Task5 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите размерность матрицы");
        int n = Integer.parseInt(reader.readLine());

        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i + j == n-1 || i - j == 0){
                    array[i][j] = 1;

                } else {
                    array[i][j] = 0;
                }
            }
        }

        System.out.println(Arrays.deepToString(array));
    }
}
