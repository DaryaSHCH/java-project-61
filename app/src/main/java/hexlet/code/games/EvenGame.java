package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class EvenGame  {
    public static final String MAIN_EVEN_QUESTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MIN_VALUE_FOR_RANDOM = 1;
    private static final int MAX_VALUE_FOR_RANDOM_TO_TEN = 10;

    private static final int QUESTION_AND_ANSWER_LENGTH = 2;
    public static void startEvenGame() {
        Engine.startGame(MAIN_EVEN_QUESTION, generateAndGetQuestionsAndAnswers());
    }
    private static String[][] generateAndGetQuestionsAndAnswers() {
        String[][] questionAndAnswer = new String[Engine.TRIES][QUESTION_AND_ANSWER_LENGTH];
        for (int i = 0; i < Engine.TRIES; i++) {
            int number = Utils.getRandomNumber(MIN_VALUE_FOR_RANDOM, MAX_VALUE_FOR_RANDOM_TO_TEN);
            questionAndAnswer[i][1] = getCorrectAnswer(isEven(number));
            questionAndAnswer[i][0] = Integer.toString(number);
        }
        return questionAndAnswer;
    }


    public static boolean isEven(int randomNumb) {
        return randomNumb % 2 == 0;
    }

    public static String getCorrectAnswer(boolean result) {
        return result ? "yes" : "no";
    }
}

