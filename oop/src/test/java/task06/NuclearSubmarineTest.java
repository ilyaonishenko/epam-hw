package task06;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 25.09.16.
 * task 06
 */
public class NuclearSubmarineTest {

    NuclearSubmarine submarine;

    @Test
    public void testSubmarineMoving(){
        submarine = new NuclearSubmarine("Terror",123,100,
                new NuclearSubmarine.EngineForNuclearSubmarine(
                        "PWERQW",1000
                ));
        submarine.turnOn();
        assertThat(submarine.isMoving(),is(true));
    }

}