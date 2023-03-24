package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public final class GreatestCommonDivisorGame {
    static String[] PAIRS = new String[StaticVariables.TRIES];
    static String[] CORRECT_ANSWERS_FOR_GCD = new String[StaticVariables.TRIES];
    public static void startGCD() {
        String mainQuestion = "Find the greatest common divisor of given numbers.";

        int[] firstNumbers = getRandomNumbers();
        int[] secondNumbers = getRandomNumbers();
        fillQuestionsAndAnswers(firstNumbers, secondNumbers);
        Engine.startGame(mainQuestion, PAIRS, CORRECT_ANSWERS_FOR_GCD);
    }
    private static int[] getRandomNumbers() {
        int[] numbers = new int[StaticVariables.TRIES];
        for (int i = 0; i < numbers.length; i++) {
            int randomNumber= Engine.getRandomNumber(
                    StaticVariables.MIN_VALUE_FOR_RANDOM,
                    StaticVariables.MAX_VALUE_FOR_RANDOM_TO_HUNDRED);
            numbers[i] = randomNumber;
        }
        return numbers;
    }

    public static void fillQuestionsAndAnswers(int[] firstNumbers, int[] secondNumbers) {
        for (int i = 0; i < PAIRS.length; i++) {
            PAIRS[i] = firstNumbers[i] + " " + secondNumbers[i];
            CORRECT_ANSWERS_FOR_GCD[i] = Integer.toString(getGCD(firstNumbers[i],
                    secondNumbers[i]));
        }
    }
    public static int getGCD(int firstNumber, int secondNumber) {
        if (firstNumber == 0) {
            return secondNumber;
        }

        return getGCD(secondNumber % firstNumber, firstNumber);
    }
}
