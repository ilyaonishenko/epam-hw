package task01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wopqw on 17.10.16.
 */
public class Bank {

    private Map<Integer, Account> map;

    public Bank() {
        map = new HashMap<>();
    }

    public Bank(List<Account> list) {

        map = list.stream()
                .collect(Collectors.toMap(
                        Account::getId,
                        a -> a
                ));
    }

    public Account getAccount(int accountId) {
        return map.get(accountId);
    }

    public void addAccount(Account account) {
        map.put(account.getId(), account);
    }

}
