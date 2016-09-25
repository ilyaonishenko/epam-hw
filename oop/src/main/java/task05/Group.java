package task05;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wopqw on 26.09.16.
 */
public class Group {

    @Getter
    private int number;

    @Getter
    private HashMap<Student,ArrayList<Number>> studentMap;

    @Getter
    private Discipline discipline;

    public Group(int number,Discipline discipline){
        this.number = number;
        this.discipline = discipline;
        studentMap = new HashMap<>();
    }

    public void addStudent(Student student, ArrayList<Number> studentMarks){
        studentMap.put(student,studentMarks);
    }

//    public static void addStudent(HashMap<Student,ArrayList<Number>> studentMap,
//                                  Student student, ArrayList<Number> studentMarks){
//        studentMap.put(student,studentMarks);
//    }

    public Double getAverageMark(Student student){

        if (Discipline.markIsInt(getDiscipline())){
            return studentMap.get(student).stream()
                    .mapToInt(Number::intValue).average().orElse(0);
        } else {
            return studentMap.get(student).stream()
                    .mapToDouble(Number::doubleValue).average().orElse(0);
        }
    }

    public boolean checkStudent(Student student){
        return studentMap.containsKey(student);
    }
}
