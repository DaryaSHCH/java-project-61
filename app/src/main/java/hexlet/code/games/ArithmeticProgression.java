package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public class ArithmeticProgression {
    static final int INTERVAL_FIRST_PROGRESSION = 2;
    static final int INTERVAL_SECOND_PROGRESSION = 3;
    static final int INTERVAL_THIRD_PROGRESSION = 5;

    static final int[] INTERVAL = {INTERVAL_FIRST_PROGRESSION, INTERVAL_SECOND_PROGRESSION, INTERVAL_THIRD_PROGRESSION};
    static final int PROGRESSION_LENGTH = 10;
    public static void start() {
        System.out.println("What number is missing in the progression?");
        getArithmeticProgressionGame();
    }

    public static void getArithmeticProgressionGame() {

        for (int i = 0; i < StaticVariables.TRIES; i++) {
            String[] roundsData = generateRoundData();
            int randomNumbForInterval = Engine.getRandomNumber(StaticVariables.MIN_VALUE_FOR_RANDOM,
                    StaticVariables.MAX_VALUE_FOR_RANDOM_TO_TEN);
            String userAnswer = Engine.getUserStringAnswer(StaticVariables.QUESTION + roundsData[0]);
            System.out.println(StaticVariables.ANSWER + userAnswer);
            String correctAnswer = roundsData[1];
            Engine.printResultForProgression(userAnswer, correctAnswer);
        }
        System.out.println("Congratulations, " + App.getUserName() + "!");
    }

    public static int[] getProgression(int intervalBetweenNumbers) {
        final int progressionIntervalPattern = 3;
        int[] progression = new int[PROGRESSION_LENGTH];
        int firstElement = Engine.getRandomNumber(StaticVariables.MIN_VALUE_FOR_RANDOM,
                StaticVariables.MAX_VALUE_FOR_RANDOM_TO_HUNDRED);
        progression[0] = firstElement;

        for (int i = 0; i < progression.length; i++) {

            progression[i] = firstElement++;
        }
        int[] progression1 = new int[PROGRESSION_LENGTH];

        for (int i = 0; i < progression.length; i++) {
            if (intervalBetweenNumbers == 2) {
                firstElement++;
                progression1[i] = firstElement++;
            } else if (intervalBetweenNumbers == progressionIntervalPattern) {
                firstElement++;
                firstElement++;
                progression1[i] = firstElement++;
            } else {
                firstElement++;
                firstElement++;
                firstElement++;
                firstElement++;
                progression1[i] = firstElement++;
            }
        }
        return progression1;
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

    public static int getIndexMissingElement(int index) {
        final int startIndex = 0;
        final int firstIndex = 1;
        final int lastIndex = 10;
        final int preLastIndex = 9;
        if (index == firstIndex) {
            return startIndex;
        } else if (index == lastIndex) {
            return preLastIndex;
        } else {
            return index;
        }
    }

    public static boolean isCorrect(int correctAnswer, int userAnswer) {
        return correctAnswer == userAnswer;
    }

    public static String[] generateRoundData() {

        int randomNumbForInterval = Engine.generateRandomNumber(INTERVAL.length);
        int missingIndex;
        missingIndex = getIndexMissingElement(Engine.generateRandomNumber(PROGRESSION_LENGTH));

        int[] progression = getProgression(randomNumbForInterval);
        String progressionWithMissingInterval = getProgressionWithEmptyIndex(progression, missingIndex);

        String question = String.join(" ", progressionWithMissingInterval);
        String answer = String.valueOf(progression[missingIndex]);

        return new String[] {question, answer};
    }

    public static int[] getPreFinalProgression(int index) {
        switch (index) {
            case 1 -> {
                return getProgression(INTERVAL_SECOND_PROGRESSION);
            }
            case 2 -> {
                return getProgression(INTERVAL_THIRD_PROGRESSION);
            }
            default -> {
                return getProgression(INTERVAL_FIRST_PROGRESSION);
            }
        }
    }
}
