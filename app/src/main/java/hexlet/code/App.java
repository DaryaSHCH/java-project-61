package hexlet.code;


import hexlet.code.games.ArithmeticProgression;
import hexlet.code.games.CalculatorGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GreatestCommonDivisorGame;
import hexlet.code.games.PrimeNumberGame;

import java.util.Scanner;

public class App {
    public static final  String USER_CHOICE = """
            Please enter the game number and press Enter\s
            1 - Greet
            2 - Even\s
            3 - Calc\s
            4 - GCD\s
            5 - Progression\s
            6 - Prime\s
            0 - Exit""";
    static final int USER_CHOICE_FOR_GREETING = 1;
    static final int USER_CHOICE_FOR_START_EVEN_GAME = 2;
    static final int USER_CHOICE_FOR_EXIT = 0;

    static final int USER_CHOICE_FOR_CALCULATOR = 3;
    static final int USER_CHOICE_FOR_GCD = 4;
    static final int USER_CHOICE_FOR_PROGRESSION = 5;
    static final int USER_CHOICE_FOR_PRIME = 6;
    public static void main(String[] args) {
        System.out.println(USER_CHOICE);
        Scanner scan = new Scanner(System.in);
        int numberUserChoice = scan.nextInt();
        switch (numberUserChoice) {
            case USER_CHOICE_FOR_GREETING -> {
                System.out.println("Your choice: " + USER_CHOICE_FOR_GREETING
                        + "\nWelcome to the Brain Games!");
                System.out.println("May I have your name?");
                String userName = scan.next();
                System.out.println("Hello, " + userName + "!");
                scan.close();
            }
            case USER_CHOICE_FOR_START_EVEN_GAME -> {
                System.out.println("Your choice: " + USER_CHOICE_FOR_START_EVEN_GAME);
                EvenGame.startEvenGame();
                scan.close();
            }
            case USER_CHOICE_FOR_CALCULATOR -> {
                System.out.println("Your choice: " + USER_CHOICE_FOR_CALCULATOR);
                CalculatorGame.startCalc();
                scan.close();
            }
            case USER_CHOICE_FOR_GCD -> {
                System.out.println("Your choice: " + USER_CHOICE_FOR_GCD);
                GreatestCommonDivisorGame.startGCD();
                scan.close();
            }
            case USER_CHOICE_FOR_PROGRESSION -> {
                System.out.println("Your choice: " + USER_CHOICE_FOR_PROGRESSION);
                ArithmeticProgression.startProgressionGame();
                scan.close();
            }
            case USER_CHOICE_FOR_PRIME -> {
                System.out.println("Your choice: " + USER_CHOICE_FOR_PRIME);
                PrimeNumberGame.startPrime();
                scan.close();
            }
            case USER_CHOICE_FOR_EXIT -> {
                System.out.println("Your choice: " + USER_CHOICE_FOR_EXIT + "\nGoodbye");
                scan.close();
            }
            default -> throw new RuntimeException("Unknown input: " + numberUserChoice);
        }
    }
}
