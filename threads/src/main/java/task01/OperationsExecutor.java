package task01;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Created by wopqw on 17.10.16.
 */
public class OperationsExecutor {

    private final String PATH;

    private Bank bank;

    private List<String> operations;

    public OperationsExecutor(Bank bank, String filePath){

        PATH = filePath;
        this.bank = bank;
        operations = new ArrayList<>();
    }

    @SneakyThrows
    private List<String> readFile(){

        try(BufferedReader reader = new BufferedReader(
                new FileReader(PATH))){

            return reader.lines()
                    .collect(Collectors.toList());
        }
    }

    @SneakyThrows
    public void execute(){

        ExecutorService executor = Executors.newFixedThreadPool(5);

        operations = readFile();

        operations.stream()
                .parallel()
                .forEach(line ->{
                    String[] params = line.split(" ");
                    executor.execute(
                            new AccountOperator(
                                    bank.getAccount(Integer.parseInt(params[0])),
                                    bank.getAccount(Integer.parseInt(params[1])),
                                    Double.parseDouble(params[2])));
                });
        executor.shutdown();
    }
}
