package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class PrimeNumberGame {
    private static final String MAIN_PRIME_QUESTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_VALUE_FOR_RANDOM = 1;
    private static final int MAX_VALUE_FOR_RANDOM_TO_HUNDRED = 100;
    private static final int QUESTION_AND_ANSWER_LENGTH = 2;
    public static void startPrime() {
        Engine.startGame(MAIN_PRIME_QUESTION, generateAndGetQuestionsAndAnswers());
    }
    public static String[][] generateAndGetQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.TRIES][QUESTION_AND_ANSWER_LENGTH];
        for (int i = 0; i < Engine.TRIES; i++) {
            int number = Utils.getRandomNumber(MIN_VALUE_FOR_RANDOM, MAX_VALUE_FOR_RANDOM_TO_HUNDRED);
            questionsAndAnswers[i][0] = Integer.toString(number);
            questionsAndAnswers[i][1] = Utils.getCorrectAnswer(isPrime(number));
        }
        return questionsAndAnswers;
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
