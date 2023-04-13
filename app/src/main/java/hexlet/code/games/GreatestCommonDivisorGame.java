package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class GreatestCommonDivisorGame {
    private static final String MAIN_GCD_QUESTION = "Find the greatest common divisor of given numbers.";
    private static final int MIN_VALUE_FOR_RANDOM = 1;
    private static final int MAX_VALUE_FOR_RANDOM_TO_HUNDRED = 100;
    private static final int QUESTION_AND_ANSWER_LENGTH = 2;
    public static void startGCD() {
        Engine.startGame(MAIN_GCD_QUESTION, generateAndGetQuestionsAndAnswers());
    }

    public static String[][] generateAndGetQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.TRIES][QUESTION_AND_ANSWER_LENGTH];
        for (int i = 0; i < Engine.TRIES; i++) {
            int firstNumber = Utils.getRandomNumber(MIN_VALUE_FOR_RANDOM, MAX_VALUE_FOR_RANDOM_TO_HUNDRED);
            int secondNumber = Utils.getRandomNumber(MIN_VALUE_FOR_RANDOM, MAX_VALUE_FOR_RANDOM_TO_HUNDRED);
            questionsAndAnswers[i][0] = firstNumber + " " + secondNumber;
            questionsAndAnswers[i][1] = Integer.toString(getGCD(firstNumber, secondNumber));
        }
        return questionsAndAnswers;
    }


    public static int getGCD(int firstNumber, int secondNumber) {
        if (firstNumber == 0) {
            return secondNumber;
        }

        return getGCD(secondNumber % firstNumber, firstNumber);
    }
}
