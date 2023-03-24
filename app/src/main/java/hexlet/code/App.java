package hexlet.code;

import hexlet.code.games.ArithmeticProgression;
import hexlet.code.games.CalculatorGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GreatestCommonDivisorGame;

import hexlet.code.games.PrimeNumberGame;

import static hexlet.code.Cli.greetUserAndGetName;
import static hexlet.code.Engine.closeSCAN;

public class App {
    public static void main(String[] args) {
        System.out.println(StaticVariables.USER_CHOICE);
        int numberUserChoice;
        do {
            numberUserChoice = Engine.inputChoiceNumber();
        } while (numberUserChoice > StaticVariables.USER_CHOICE_FOR_PRIME);

        switch (numberUserChoice) {
            case StaticVariables.USER_CHOICE_FOR_GREETING -> {
                System.out.println(greetUserAndGetName());
            }
            case StaticVariables.USER_CHOICE_FOR_START_EVEN_GAME -> {
                System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_START_EVEN_GAME);
                EvenGame.startEvenGame();
            }
            case StaticVariables.USER_CHOICE_FOR_CALCULATOR -> {
                System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_CALCULATOR);
                CalculatorGame.startCalc();
            }
            case StaticVariables.USER_CHOICE_FOR_GCD -> {
                System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_GCD);
                GreatestCommonDivisorGame.startGCD();
            }
            case StaticVariables.USER_CHOICE_FOR_PROGRESSION -> {
                System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_PROGRESSION);
                ArithmeticProgression.startProgression();
            }
            case StaticVariables.USER_CHOICE_FOR_PRIME -> {
                System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_PRIME);
                PrimeNumberGame.startPrime();
            }
            case StaticVariables.USER_CHOICE_FOR_EXIT -> {
                System.out.println("Your choice: " + StaticVariables.USER_CHOICE_FOR_EXIT + "\nGoodbye");
            }
            default -> {
                throw new RuntimeException("Unknown input: " + numberUserChoice);
            }
        }

        closeSCAN();
    }
}
