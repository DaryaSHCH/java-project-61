package hexlet.code;

import hexlet.code.games.*;

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
        } else {
            System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_EXIT + "\nGoodbye");
        }
        System.out.println("Your choice: " + numberUserChoice);
        Game game = getGameByUserChoice(numberUserChoice);
        game.start();
        closeSCAN();
    }
    public static void setUserName(String name) {
        App.userName = name;
    }
    public static String getUserName() {
        return userName;
    }

    public static Game getGameByUserChoice(int userChoice) {
        switch (userChoice) {
            case  StaticVariables.USER_CHOICE_FOR_PRIME ->  {
                return new PrimeNumberGame(App.getUserName());
            }
            case StaticVariables.USER_CHOICE_FOR_START_EVEN_GAME -> {
                return new EvenGame(App.getUserName());
            }
            case StaticVariables.USER_CHOICE_FOR_CALCULATOR -> {
                return new CalculatorGame(App.getUserName());
            }
            case StaticVariables.USER_CHOICE_FOR_GCD -> {
                return new GreatestCommonDivisorGame(App.getUserName());
            }
            case StaticVariables.USER_CHOICE_FOR_PROGRESSION -> {
                return new ArithmeticProgression(App.getUserName());
            }
            default -> {
                return null;
            }
        }

    }
}
