package task01;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wopqw on 17.10.16.
 */

@RequiredArgsConstructor
public class ConcurrentAccount implements Account {

    private final int id;

    private double credit;

    private Lock lock = new ReentrantLock();

    public ConcurrentAccount(int id, double credit){
        this.id = id;
        this.credit = credit;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getBalance() {
        return credit;
    }

    @Override
    public void recharge(double credit) {

        proceed(credit);
    }

    @Override
    public void withdraw(double credit) {

        proceed(-credit);
    }

    public void proceed(double credit){

        lock.lock();
        this.credit+= credit;
        lock.unlock();

    }
}
