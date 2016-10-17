package task02;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * Created by wopqw on 13.10.16.
 */
public class PropertyReader implements AutoCloseable{

    @Getter
    public String path;

    @Getter
    private Map<String, String> map = null;

    private Lock lock = new ReentrantLock();

    public PropertyReader(String path){

        this.path = path;
    }

    private void readPropFile(String path) {

        lock.lock();

        try(BufferedReader bReader = new BufferedReader(
                new FileReader(path))){

            map =  bReader.lines()
                    .filter(line -> line.trim().charAt(0)!='#')
                    .collect(Collectors.toConcurrentMap(
                            l -> l.split("=")[0].trim(),
                            l -> l.split("=")[1].trim()
                    ));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        lock.unlock();
    }

    @Override
    public void close() throws Exception {
        map = null;
    }

    public String readProperty(String propName) throws NoSuchPropertyException {

        if (map == null)
            readPropFile(path);

        if (!map.containsKey(propName))
            throw new NoSuchPropertyException("No such property in this file!");
        else return map.get(propName);

    }
}
