package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class ArithmeticProgression {

    private static final String MAIN_PROGRESSION_QUESTION = "What number is missing in the progression?";
    private static final int MAX_VALUE_FOR_RANDOM_TO_HUNDRED = 100;
    private static final int MIN_VALUE_FOR_RANDOM = 1;
    private static final int QUESTION_AND_ANSWER_LENGTH = 2;
    private static final int INTERVAL_FIRST_PROGRESSION = 2;
    private static final int INTERVAL_SECOND_PROGRESSION = 3;
    private static final int INTERVAL_THIRD_PROGRESSION = 5;

    private static final int[] INTERVALS = {
            INTERVAL_FIRST_PROGRESSION,
            INTERVAL_SECOND_PROGRESSION,
            INTERVAL_THIRD_PROGRESSION
    };
    private static final int PROGRESSION_LENGTH = 10;

    public static void startProgressionGame() {
        Engine.startGame(MAIN_PROGRESSION_QUESTION, generateAndGetQuestionsAndAnswers());
    }

    public static String[][] generateAndGetQuestionsAndAnswers(){
        String[][] questionsAndAnswers = new String[Engine.TRIES][QUESTION_AND_ANSWER_LENGTH];
        for (int i = 0; i < Engine.TRIES; i++) {
            int startValue = Utils.getRandomNumber(MIN_VALUE_FOR_RANDOM, MAX_VALUE_FOR_RANDOM_TO_HUNDRED);
            int intervalBetweenNumbers = Utils.getRandomNumber(0, INTERVALS.length - 1);
            int indexHiddenElement = Utils.getRandomNumber(0, PROGRESSION_LENGTH - 1);

            String[] progression = getFullStringProgression(getFullProgression(startValue, INTERVALS[intervalBetweenNumbers]));
            progression[indexHiddenElement] = "..";
            questionsAndAnswers[i][0] = String.join(" ", progression);
            questionsAndAnswers[i][1] = Integer.toString(startValue + INTERVALS[intervalBetweenNumbers] * indexHiddenElement);
        }
        return questionsAndAnswers;
    }

    private static int[] getFullProgression(int startValue, int intervalIdx) {
        int interval = intervalIdx;
        int[] sequence = new int[PROGRESSION_LENGTH];
        sequence[0] = startValue;

        for (int i = 1; i < sequence.length; i++) {
            sequence[i] = sequence[i - 1] + interval;
        }
        return sequence;
    }
    private static String[] getFullStringProgression(int[] progression) {
        String[] sequence = new String[PROGRESSION_LENGTH];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = String.valueOf(progression[i]);
        }
        return sequence;
    }
}
