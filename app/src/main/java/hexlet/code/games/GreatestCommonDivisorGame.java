package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public final class GreatestCommonDivisorGame {
    private static final String[] pairsForGCD = new String[StaticVariables.TRIES];
    private static final String[] correctAnswersForGCD = new String[StaticVariables.TRIES];
    public static void startGCD() {
        String mainQuestion = "Find the greatest common divisor of given numbers.";

        int[] firstNumbers = getRandomNumbers();
        int[] secondNumbers = getRandomNumbers();
        fillQuestionsAndAnswers(firstNumbers, secondNumbers);
        Engine.startGame(mainQuestion, pairsForGCD, correctAnswersForGCD);
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
        for (int i = 0; i < pairsForGCD.length; i++) {
            pairsForGCD[i] = firstNumbers[i] + " " + secondNumbers[i];
            correctAnswersForGCD[i] = Integer.toString(getGCD(firstNumbers[i],
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
