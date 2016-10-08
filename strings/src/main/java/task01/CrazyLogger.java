package task01;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by wopqw on 08.10.16.
 */
public class CrazyLogger {

    private StringBuilder memory;

    private String pattern = "dd-mm-YYYY:hh-mm--";

    public CrazyLogger(){

        memory = new StringBuilder();
    }

    private String printDateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(new Date());
    }

    public void log(String message){

        memory.append(printDateTime()).append(message).append("\n");
    }

    public String printLog(){

        return memory.toString();
    }

    public String[] search(String message){

        return Arrays.stream(memory.toString().split("\n"))
                .filter(s -> s.contains(message))
                .toArray(String[]::new);
    }

    public boolean contains(String message){

        return Arrays.stream(memory.toString().split("\n"))
                .filter(s -> s.contains(message))
                .toArray(String[]::new)
                .length !=0;
    }

    public String[] search(Date date){

        return search(new SimpleDateFormat(pattern).format(date));
    }

    public boolean contains(Date date){
        return contains(new SimpleDateFormat(pattern).format(date));
    }
}
