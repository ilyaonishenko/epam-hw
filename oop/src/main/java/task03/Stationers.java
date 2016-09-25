package task03;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;

/**
 * Created by wopqw on 17.09.16.
 */

@Getter
@AllArgsConstructor
public abstract class Stationers{

    private String producer;
    private String color;
    private double price;

    public static Comparator<Stationers> stationersProducerComparator
            = new Comparator<Stationers>() {
        @Override
        public int compare(Stationers o1, Stationers o2) {

            String firstName = o1.getProducer().toLowerCase();
            String secondName = o2.getProducer().toLowerCase();

            return firstName.compareTo(secondName);
        }
    };

    public static Comparator<Stationers> stationersPriceComparator
            = new Comparator<Stationers>() {
        @Override
        public int compare(Stationers o1, Stationers o2) {
            double firstPrice = o1.getPrice();
            double secondPrice = o2.getPrice();

            double answer = firstPrice - secondPrice;
            return choice(answer);
        }
    };

    public static Comparator<Stationers> stationersPriceProdComparator
            = new Comparator<Stationers>() {
        @Override
        public int compare(Stationers o1, Stationers o2) {

            String firstProd = o1.getProducer();
            String secondProd = o2.getProducer();

            double firstPrice = o1.getPrice();
            double secondPrice = o2.getPrice();

            int a = firstProd.compareTo(secondProd);

            if(a==0){
                double answer = firstPrice - secondPrice;
                return choice(answer);
            } else {
                return a;
            }
        }
    };
    static int choice(double answer){
        if (answer>0){
            return 1;
        } else if (answer<0){
            return -1;
        } else return 0;
    }
}
