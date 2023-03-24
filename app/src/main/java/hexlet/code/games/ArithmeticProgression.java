package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public final class ArithmeticProgression {
    private static final String[] PROGRESSIONS_FOR_TASK = new String[StaticVariables.TRIES];
    private static final String[] CORRECT_ANSWERS_FOR_PROGRESSIONS = new String[StaticVariables.TRIES];
    private static final int INTERVAL_FIRST_PROGRESSION = 2;
    private static final int INTERVAL_SECOND_PROGRESSION = 3;
    private static final int INTERVAL_THIRD_PROGRESSION = 5;

    private static final int[] INTERVALS = {
            INTERVAL_FIRST_PROGRESSION,
            INTERVAL_SECOND_PROGRESSION,
            INTERVAL_THIRD_PROGRESSION
    };
    private static final int PROGRESSION_LENGTH = 10;

    public static void startProgression() {
        String mainQuestion = "What number is missing in the progression?";

        for (int i = 0; i < StaticVariables.TRIES; i++) {
            int intervalIndex = Engine.getRandomNumber(0, INTERVALS.length - 1);
            int startValue = Engine.getRandomNumber(
                    StaticVariables.MIN_VALUE_FOR_RANDOM,
                    StaticVariables.MAX_VALUE_FOR_RANDOM_TO_HUNDRED);
            int[] fullProgression = getIntegerFullProgression(intervalIndex, startValue);
            int indexMissingElement = Engine.getRandomNumber(0, fullProgression.length - 1);
            CORRECT_ANSWERS_FOR_PROGRESSIONS[i] = String.valueOf(fullProgression[indexMissingElement]);
            PROGRESSIONS_FOR_TASK[i] = getProgressionWithEmptyIndex(fullProgression, indexMissingElement);
        }
        Engine.startGame(mainQuestion, PROGRESSIONS_FOR_TASK, CORRECT_ANSWERS_FOR_PROGRESSIONS);


    }
    private static int[] getIntegerFullProgression(int intervalIdx, int startValue) {
        int interval = INTERVALS[intervalIdx];
        int[] sequence = new int[PROGRESSION_LENGTH];
        sequence[0] = startValue;

        for (int i = 1; i < sequence.length; i++) {
            sequence[i] = sequence[i - 1] + interval;
        }
        return sequence;
    }

    public static String getProgressionWithEmptyIndex(int[] progression, int indexMissingElement) {
        StringBuilder progressionString = new StringBuilder("");
        for (int i = 0; i < progression.length; i++) {
            if (i == indexMissingElement) {
                progressionString.append(".. ");
            } else {
                progressionString.append(progression[i]).append(" ");
            }
        }
        return progressionString.toString();
    }
}
