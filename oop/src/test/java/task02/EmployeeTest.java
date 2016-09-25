package task02;

import org.junit.Test;
import task03.Notebook;
import task03.Pen;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 25.09.16.
 */
public class EmployeeTest {

    Employee emp = new Employee("Ivan","Ivanov",
            new Cubicle(
                    new Pen("Pilot","blue",215.23,"blue",false),
                    new Notebook("aTauras","green",231,300,false)
            ));

    @Test
    public void empCost() throws Exception {

        assertThat(emp.cost(), is(215.23+231));
    }

}