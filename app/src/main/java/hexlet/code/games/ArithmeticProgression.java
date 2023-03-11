package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public class ArithmeticProgression extends Game {

    private static final int INTERVAL_FIRST_PROGRESSION = 2;
    private static final int INTERVAL_SECOND_PROGRESSION = 3;
    private static final int INTERVAL_THIRD_PROGRESSION = 5;

    private static final int[] INTERVALS = {INTERVAL_FIRST_PROGRESSION, INTERVAL_SECOND_PROGRESSION, INTERVAL_THIRD_PROGRESSION};
    private static final int PROGRESSION_LENGTH = 10;

    public ArithmeticProgression(String userName) {
        super(userName);
    }

    @Override
    protected String getStartMessage() {
        return "What number is missing in the progression?";
    }

    @Override
    protected GameTryResult processUserTry() {
        int intervalIndex = Engine.getRandomNumber(0, INTERVALS.length - 1);
        int interval = INTERVALS[intervalIndex];
        int startValue = Engine.getRandomNumber(1, 100);

        int[] sequence = new int[PROGRESSION_LENGTH];
        sequence[0] = startValue;

        for (int i = 1; i < sequence.length; i++) {
            sequence[i] = sequence[i - 1] + interval;
        }

        int hiddenElementIndex = Engine.getRandomNumber(0, sequence.length - 1);
        String sequenceWithHiddenValue = getProgressionWithEmptyIndex(sequence, hiddenElementIndex);

        String correctAnswer = String.valueOf(sequence[hiddenElementIndex]);
        String userAnswer = Engine.getUserStringAnswer(StaticVariables.QUESTION + sequenceWithHiddenValue);

        return new GameTryResult(
                correctAnswer,
                userAnswer
        );
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
