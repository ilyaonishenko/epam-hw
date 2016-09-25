package task02;

import lombok.Value;
import task03.StarterKit;
import task03.Stationers;

/**
 * Created by wopqw on 25.09.16.
 */
@Value
class Cubicle extends StarterKit {

    Cubicle(Stationers... args){
        super(args);
    }

    Cubicle(Stationers stationers){
        super(stationers);
    }

}
