package task06;

import lombok.Data;
import task07.CustomAnnotation;

/**
 * Created by wopqw on 25.09.16.
 */
@Data
@CustomAnnotation(info = "NuclearSubmarineClass")
public class NuclearSubmarine {

    private String name;

    private int rocketNumber;

    private int squadSize;

    private boolean isMoving = false;

    private EngineForNuclearSubmarine engine;

    public NuclearSubmarine(String name, int rocketNumber, int squadSize, EngineForNuclearSubmarine engine){
        this.name = name;
        this.rocketNumber = rocketNumber;
        this.squadSize = squadSize;
        this.engine = engine;

    }

    public void turnOn(){
        engine.turnOn();
        this.isMoving = true;
        System.out.println("The nuclear submarine is moving!!");
    }


    static class EngineForNuclearSubmarine{

        private String producer;

        private int power;

        public EngineForNuclearSubmarine(String producer, int power){
            this.producer = producer;
            this.power = power;
        }

        public void turnOn(){
            System.out.println("The engine is turn on!");
        }

    }

}
