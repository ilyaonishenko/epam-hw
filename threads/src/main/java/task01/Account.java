package task01;

/**
 * Created by wopqw on 17.10.16.
 */

public interface Account {

    int getId();
    double getBalance();
    void recharge(double credit);
    void withdraw(double credit);
}
