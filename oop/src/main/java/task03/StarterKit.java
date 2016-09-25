package task03;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by wopqw on 25.09.16.
 */

public class StarterKit {

    public ArrayList<Stationers> stationersList;

    public StarterKit(Stationers... args){
        stationersList = new ArrayList<>(Arrays.asList(args));
    }

    public void add(Stationers stationer){
        stationersList.add(stationer);
    }

    void add(Stationers... stationers){
        stationersList.addAll(Arrays.asList(stationers));
    }

    int size(){
        return stationersList.size();
    }

    Stationers get(int i){
        return stationersList.get(i);
    }

    Stationers remove(int i){
        return stationersList.remove(i);
    }

    boolean remove(Stationers stationersToRemove){
        return stationersList.remove(stationersToRemove);
    }

//    Stationers bluePen = new Pen("Pilot","Blue",121.23,"Blue",false);
//
//    Stationers officeNotepda = new Notebook("EMCS","White",100,96,false);
//
//    Stationers someClips = new Clip("Nowhere","Black",30,"WHAS","Plastic");
}
