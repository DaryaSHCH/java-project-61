package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public class PrimeNumberGame {
    public static void start() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        getPrimeNumberGame();
    }

    public static void getPrimeNumberGame() {
        for (int i = 0; i < StaticVariables.TRIES; i++) {
            String[] roundsData = generateRoundData();
            String userAnswer = Engine.getUserStringAnswer(StaticVariables.QUESTION + roundsData[0]);
            System.out.println(StaticVariables.ANSWER + userAnswer);
            String correctAnswer = roundsData[1];
            Engine.printResult(userAnswer, correctAnswer);
        }
            System.out.println("Congratulations, " + App.getUserName() + "!");
    }
    private static String[] generateRoundData() {
        int number = Engine.getRandomNumber(StaticVariables.MIN_VALUE_FOR_RANDOM, StaticVariables.MAX_VALUE_FOR_RANDOM_TO_HUNDRED);

        String questionNumber = String.valueOf(number);

        String[] roundsData = new String[2];
        roundsData[0] = questionNumber;
        roundsData[1] = getCorrectAnswer(number);


        return roundsData;
    }

    public static boolean isPrime(int number) {
            int numberForCheck = 1;
            if (number <= numberForCheck) {
                return false;
            }
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
    }

    private static String getCorrectAnswer(int randomNumb) {
        String correctAnswer;
        if (isPrime(randomNumb)) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }
        return correctAnswer;
    }
}
