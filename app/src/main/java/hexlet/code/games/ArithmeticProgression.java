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

    public static String[][] generateAndGetQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.TRIES][QUESTION_AND_ANSWER_LENGTH];
        for (int i = 0; i < Engine.TRIES; i++) {
            int startValue = Utils.getRandomNumber(MIN_VALUE_FOR_RANDOM, MAX_VALUE_FOR_RANDOM_TO_HUNDRED);
            int intervalBetweenNumbers = Utils.getRandomNumber(0, INTERVALS.length - 1);
            int indexHiddenElement = Utils.getRandomNumber(0, PROGRESSION_LENGTH - 1);

            String[] progression = makeProgression(startValue,
                    INTERVALS[intervalBetweenNumbers]);
            questionsAndAnswers[i][1] = progression[indexHiddenElement];
            progression[indexHiddenElement] = "..";
            questionsAndAnswers[i][0] = String.join(" ", progression);
        }
        return questionsAndAnswers;
    }
    private static String[] makeProgression(int firstElement, int interval) {
        String[] progression = new String[ArithmeticProgression.PROGRESSION_LENGTH];

        for (int i = 0; i < ArithmeticProgression.PROGRESSION_LENGTH; i += 1) {
            progression[i] = Integer.toString(firstElement + i * interval);
        }

        return progression;
    }
}
