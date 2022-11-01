package hexlet.code;

import hexlet.code.games.*;

import static hexlet.code.Cli.greetUser;
import static hexlet.code.Engine.closeSCAN;

public class App {
    public static String USER_NAME;
    static String USER_CHOICE = """
            Please enter the game number and press Enter\s
            1 - Greet
            2 - Even\s
            3 - Calc\s
            4 - GCD\s
            5 - Progression\s
            6 - Prime\s
            0 - Exit""";


    public static void main(String[] args) {
        System.out.println(App.USER_CHOICE);
        int numberUserChoice;
        do {
            numberUserChoice = Engine.inputChoiceNumber();
        } while (numberUserChoice > 6);

        if(numberUserChoice == StaticVariables.USER_CHOICE_FOR_GREETING) {
            greetUser();
        } else if(numberUserChoice == StaticVariables.USER_CHOICE_FOR_START_EVEN_GAME) {
            System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_START_EVEN_GAME);
            greetUser();
            EvenGame.start();
        } else if (numberUserChoice == StaticVariables.USER_CHOICE_FOR_CALCULATOR){
            System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_CALCULATOR);
            greetUser();
            CalculatorGame.start();
        } else if (numberUserChoice == StaticVariables.USER_CHOICE_FOR_GCD) {
            System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_GCD);
            greetUser();
            GreatestCommonDivisorGame.start();
        } else if (numberUserChoice == StaticVariables.USER_CHOICE_FOR_PROGRESSION) {
            System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_PROGRESSION);
            greetUser();
            ArithmeticProgression.start();
        } else if (numberUserChoice == StaticVariables.USER_CHOICE_FOR_PRIME) {
            System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_PRIME);
            greetUser();
            PrimeNumberGame.start();
        } else {
            System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_EXIT + "\nGoodbye");
        }
        closeSCAN();
    }
}
