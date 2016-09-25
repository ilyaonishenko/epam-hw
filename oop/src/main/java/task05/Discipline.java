package task05;

/**
 * Created by wopqw on 25.09.16.
 */
public enum Discipline {
    MATH,
    COMPUTER_SCIENCE,
    CHEMISTRY,
    PHYSICS,
    ECONOMY,
    LITERATURE,
    HISTORY,
    PHILOSOPHY;

    public static boolean markIsInt(Discipline disp){

        switch (disp){
            case MATH:
            case COMPUTER_SCIENCE:
            case CHEMISTRY:
            case PHYSICS: return false;
            case ECONOMY:
            case LITERATURE:
            case HISTORY:
            case PHILOSOPHY: return true;
        }
        return true;
    }
}
