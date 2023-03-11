package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public class PrimeNumberGame extends Game {
    public PrimeNumberGame(String userName) {
        super(userName);
    }

    @Override
    protected String getStartMessage() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    @Override
    protected GameTryResult processUserTry() {
        String[] roundsData = generateRoundData();
        String userAnswer = Engine.getUserStringAnswer(StaticVariables.QUESTION + roundsData[0]);
        System.out.println(StaticVariables.ANSWER + userAnswer);
        String correctAnswer = roundsData[1];
        return new GameTryResult(correctAnswer, userAnswer);
    }
    private static String[] generateRoundData() {
        int number = Engine.getRandomNumber(StaticVariables.MIN_VALUE_FOR_RANDOM,
                StaticVariables.MAX_VALUE_FOR_RANDOM_TO_HUNDRED);

        String questionNumber = String.valueOf(number);

        String[] roundsData = new String[2];
        roundsData[0] = questionNumber;
        roundsData[1] = getCorrectAnswer(number);


        return roundsData;
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
}
