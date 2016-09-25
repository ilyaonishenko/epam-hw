package task05;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by wopqw on 26.09.16.
 */
public class SchedulerTest {

    Student student1 = new Student("Ivan","Ivanov",20);
    Student student2 = new Student("Petr","Petrov",21);
    Student student3 = new Student("Ivan","Petuhov",22);

    ArrayList<Number> marks1 = new ArrayList<>(Arrays.asList(5,5,5,5,5));
    ArrayList<Number> marks2 = new ArrayList<>(Arrays.asList(4.5,5,3.5,5,4.3));
    ArrayList<Number> marks3 = new ArrayList<>(Arrays.asList(4.5,5,3.5,5,4.3));

    static ArrayList<Group> groupsList;
    static HashMap<Discipline,Double> hashMap;

    @BeforeClass
    public static void init(){

        groupsList = new ArrayList<>();
        hashMap = new HashMap<>();

        groupsList.add(new Group(1, Discipline.HISTORY));
        groupsList.add(new Group(2, Discipline.MATH));
        groupsList.add(new Group(3, Discipline.PHYSICS));
        groupsList.add(new Group(4, Discipline.ECONOMY));

        hashMap.put(Discipline.HISTORY,5.0);
        hashMap.put(Discipline.PHYSICS,5.0);
    }

    @Test
    public void addingTest(){

        Scheduler.addStudent(student1,marks1,Discipline.HISTORY,groupsList);
        Scheduler.addStudent(student1,marks2,Discipline.ECONOMY,groupsList);

        assertThat(groupsList.size(),is(4));
        assertThat(groupsList.stream()
                .filter(g -> g.getDiscipline().equals(Discipline.HISTORY))
                .collect(Collectors.toSet()).size(),
                is(1));
    }

    @Test
    public void testAverage(){

        Scheduler.addStudent(student1,marks1,Discipline.HISTORY,groupsList);

        assertThat(Scheduler.getAverage(student1,Discipline.HISTORY,groupsList),is(5.0));
    }

    @Test
    public void testAllAverages(){

        Scheduler.addStudent(student1,marks1,Discipline.HISTORY,groupsList);
        Scheduler.addStudent(student1,marks1,Discipline.PHYSICS,groupsList);

//        Scheduler.addStudent(student2,marks3,Discipline.ECONOMY,groupsList);
//        Scheduler.addStudent(student2,marks1,Discipline.MATH,groupsList);

        assertThat(Scheduler.getAllAverages(student1,groupsList),
                is(hashMap));
    }


//    @Test
//    public void anotherAddingTest(){
//
//        Scheduler.addStudent(student1,marks1,Discipline.HISTORY,groupsList);
//        Scheduler.addStudent(student2,marks2,Discipline.HISTORY,groupsList);
//
//        assertThat(groupsList.stream()
//                        .filter(g -> g.getDiscipline().equals(Discipline.HISTORY))
//                        .map(Group::getStudentMap)
//                        .collect(Collectors.toSet())
//                is(2L));
//    }


}