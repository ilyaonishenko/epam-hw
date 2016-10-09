package task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by wopqw on 09.10.16.
 */
public class AppContext {

    static App app;

    public static void main(String[] args) throws IOException {

        System.out.println("Choose your language (en/ru)");

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String answer = reader.readLine().toLowerCase();
            switch (answer){
                case("en"):
                    app = new App(Language.EN);
                    break;
                case("ru"):
                    app = new App(Language.RU);
                    break;
            }
            boolean turnOn = true;
            while (turnOn) {
                app.printQuestions();
                System.out.println("\nChoose your question");
                int questionNum = Integer.parseInt(reader.readLine());
                System.out.println(app.answerTheQuestion(questionNum));
                System.out.println("\nDo you want another question?(yes/no)");
                if(reader.readLine().toLowerCase().equals("no")){
                    turnOn = false;
                    System.out.println("bye!");
                }
            }

        }

    }
}
