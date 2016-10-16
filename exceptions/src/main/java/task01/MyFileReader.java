package task01;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by wopqw on 16.10.16.
 */
public class MyFileReader implements AutoCloseable {

    @Getter
    @Setter
    private String path;

    public MyFileReader(String path){

        this.path = path;
    }

    public Optional<String> readFile(){

        try(BufferedReader bReader = new BufferedReader(
                new FileReader(path))){

            return bReader.lines().reduce((x,y) -> x+y);


        }catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void writeFile(String text){

        try(BufferedWriter bWriter = new BufferedWriter(
                new FileWriter(path))) {

            bWriter.write(text);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteFile(String path) throws FileNotFoundException {

        File f = new File(path);
        if (!f.exists())
            throw new FileNotFoundException("Such file does not exist");
        return f.delete();
    }

    public List<String> allFilesInDir() throws  FileNotFoundException{

        File folder = new File(path);
        if (!folder.exists())
            throw new FileNotFoundException("No such directory");
        System.out.println(Arrays.asList(folder.list()));
        return Arrays.asList(folder.list());
    }

    public void createFile(String path){

        File f = new File(path);
        try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void close() throws Exception {

        path = null;
    }
}
