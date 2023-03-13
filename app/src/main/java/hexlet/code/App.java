package hexlet.code;

import hexlet.code.games.CalculatorGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GreatestCommonDivisorGame;
import hexlet.code.games.PrimeNumberGame;
import hexlet.code.games.ArithmeticProgression;

import static hexlet.code.Cli.greetUser;
import static hexlet.code.Engine.closeSCAN;

public class App {
    private static String userName;

    public static void main(String[] args) {
        System.out.println(StaticVariables.USER_CHOICE);
        int numberUserChoice;
        do {
            numberUserChoice = Engine.inputChoiceNumber();
        } while (numberUserChoice > StaticVariables.USER_CHOICE_FOR_PRIME);

        if (numberUserChoice == StaticVariables.USER_CHOICE_FOR_GREETING) {
            greetUser();
        } else if (numberUserChoice == StaticVariables.USER_CHOICE_FOR_START_EVEN_GAME) {
            System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_START_EVEN_GAME);
            greetUser();
            new EvenGame(App.getUserName()).start();
        } else if (numberUserChoice == StaticVariables.USER_CHOICE_FOR_CALCULATOR) {
            System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_CALCULATOR);
            greetUser();
            new CalculatorGame(App.getUserName()).start();
        } else if (numberUserChoice == StaticVariables.USER_CHOICE_FOR_GCD) {
            System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_GCD);
            greetUser();
            new GreatestCommonDivisorGame(App.getUserName()).start();
        } else if (numberUserChoice == StaticVariables.USER_CHOICE_FOR_PROGRESSION) {
            System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_PROGRESSION);
            greetUser();
            new ArithmeticProgression(App.getUserName()).start();
        } else if (numberUserChoice == StaticVariables.USER_CHOICE_FOR_PRIME) {
            System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_PRIME);
            greetUser();
            new PrimeNumberGame(App.getUserName()).start();
        } else {
            System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_EXIT + "\nGoodbye");
        }

        closeSCAN();
    }
    public static void setUserName(String name) {
        App.userName = name;
    }
    public static String getUserName() {
        return userName;
    }
}
