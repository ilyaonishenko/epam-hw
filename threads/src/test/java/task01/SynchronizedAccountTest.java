package task01;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 17.10.16.
 */

public class SynchronizedAccountTest {

    public static final String FILE_PATH = "/Users/woqpw/GitHub/java/epam-hw/threads/src/test/resources/operations.txt";

    Account account1;
    Account account2;
    Account account3;
    Account account4;

    Bank bank;

    @Test
    public void testSynchronizedAccountOperations(){

        account1 = new SynchronizedAccount(1,200);
        account2 = new SynchronizedAccount(2,200);
        account3 = new SynchronizedAccount(3,200);
        account4 = new SynchronizedAccount(4,200);

        bank = new Bank(Arrays.asList(account1, account2, account3, account4));

        OperationsExecutor operationsExecutor = new OperationsExecutor(bank, FILE_PATH);

        operationsExecutor.execute();

        assertThat(account1.getBalance(),is(0.0));
        assertThat(account3.getBalance(),is(800.0));
    }

    @Test
    public void testConcurrentAccountOperations(){

        account1 = new ConcurrentAccount(1,200);
        account2 = new ConcurrentAccount(2,200);
        account3 = new ConcurrentAccount(3,200);
        account4 = new ConcurrentAccount(4,200);

        bank = new Bank(Arrays.asList(account1, account2, account3, account4));

        OperationsExecutor operationsExecutor = new OperationsExecutor(bank, FILE_PATH);

        operationsExecutor.execute();

        assertThat(account1.getBalance(),is(0.0));
        assertThat(account3.getBalance(),is(800.0));
    }



}