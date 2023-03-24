package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public final class EvenGame  {
    public static void startEvenGame() {
        String mainQuestion = "Answer 'yes' if number even otherwise answer 'no'.";
        int[] randNumbersForEven = getQuestions();
        String[] randomStringNumbersForEven = getStringArrayFromInteger(randNumbersForEven);
        String[] correctAnswers = getCorrectAnswers(randNumbersForEven);
        Engine.startGame(mainQuestion, randomStringNumbersForEven, correctAnswers);
    }
    private static int[] getQuestions() {
        int[] roundsData = new int[3];
        for (int i = 0; i < roundsData.length; i++) {
            int randomNumberForEven = Engine.getRandomNumber(
                    StaticVariables.MIN_VALUE_FOR_RANDOM,
                    StaticVariables.MAX_VALUE_FOR_RANDOM_TO_TEN);
            roundsData[i] = randomNumberForEven;
            }
        return roundsData;
    }
    private static String[] getCorrectAnswers(int[] randomNumbersForEven) {
        String[] correctAnswers  = new String[3];
        for (int i = 0; i < correctAnswers.length; i++) {
            correctAnswers[i] = getCorrectAnswerForEven(randomNumbersForEven[i]);
        }
        return correctAnswers;
    }

    private static String[] getStringArrayFromInteger(int[] numbers) {
        String[] stringNumbers = new String[numbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            stringNumbers[i] = Integer.toString(numbers[i]);
        }
        return stringNumbers;
    }
    private static String getCorrectAnswerForEven(int randomNumberForEven) {
        return isEven(randomNumberForEven) ? "yes" : "no";
    }

    public static boolean isEven(int randomNumb) {
        return randomNumb % 2 == 0;
    }
}

