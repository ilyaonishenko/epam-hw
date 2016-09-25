package task02;

import lombok.AllArgsConstructor;
import lombok.Value;
import task03.Stationers;

/**
 * Created by wopqw on 25.09.16.
 */

@Value
@AllArgsConstructor
public class Employee {

    private String firstName;

    private String lastName;

    private Cubicle<Stationers> cubicle;

    public double cost(){
        return cost(this);
    }

    public static double cost(Employee employee){

        return employee.cubicle.stream()
                .mapToDouble(Stationers::getPrice)
                .sum();
    }
}
