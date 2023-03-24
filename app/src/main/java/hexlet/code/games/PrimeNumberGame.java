package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public final class PrimeNumberGame {
    public static void startPrime() {
        String mainQuestion = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        int[] randNumbersForPrime = generateRoundsQuestion();
        String[] randStrNumbersForPrime = getStringArrayFromInteger(randNumbersForPrime);
        String[] correctAnswers = generateRoundsCorrectAnswer(randNumbersForPrime);
        Engine.startGame(mainQuestion, randStrNumbersForPrime, correctAnswers);
    }
    private static int[] generateRoundsQuestion() {
        int[] roundsData = new int[3];
        for (int i = 0; i < roundsData.length; i++) {
            int randomNumberForPrime = Engine.getRandomNumber(
                    StaticVariables.MIN_VALUE_FOR_RANDOM,
                    StaticVariables.MAX_VALUE_FOR_RANDOM_TO_HUNDRED);
            roundsData[i] = randomNumberForPrime;
        }
        return roundsData;
    }
    private static String[] getStringArrayFromInteger(int[] array) {
        String[] arrayString = new String[array.length];
        for (int i = 0; i < arrayString.length; i++) {
            arrayString[i] = Integer.toString(array[i]);
        }
        return arrayString;
    }
    private static String[] generateRoundsCorrectAnswer(int[] randomNumbersForEven) {
        String[] correctAnswers  = new String[StaticVariables.TRIES];
        for (int i = 0; i < correctAnswers.length; i++) {
            correctAnswers[i] = getCorrectAnswerForPrime(randomNumbersForEven[i]);
        }
        return correctAnswers;
    }
    private static String getCorrectAnswerForPrime(int randomNumberForPrime) {
        return isPrime(randomNumberForPrime) ? "yes" : "no";
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
