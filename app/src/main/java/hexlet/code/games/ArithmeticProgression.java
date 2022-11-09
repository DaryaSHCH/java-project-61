package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public class ArithmeticProgression {
    static final int DETERMINANT_FIRST_OPERATION = 3;
    static final int FIRST_DETERMINANT_SECOND_OPERATION = 10;
    static final int SECOND_DETERMINANT_SECOND_OPERATION = 5;
    static final int INTERVAL_FIRST_PROGRESSION = 2;
    static final int INTERVAL_SECOND_PROGRESSION = 3;
    static final int INTERVAL_THIRD_PROGRESSION = 5;
    public static void start() {
        System.out.println("What number is missing in the progression?");
        getArithmeticProgressionGame();
    }

    public static void getArithmeticProgressionGame() {
        int correctAnswer;
        int counterRightAnswer = 0;

        for (int i = 0; i < StaticVariables.TRIES; i++) {
            int randomNumbForInterval = Engine.getRandomNumberToTen();
            int userAnswer;
            if (randomNumbForInterval <= DETERMINANT_FIRST_OPERATION) {
                int[] firstProgression = getProgression(INTERVAL_FIRST_PROGRESSION);
                int indexMissingElementFirstProgression = getIndexMissingElement(Engine.getRandomNumberToTen());
                System.out.println(StaticVariables.QUESTION + getStringProgression(firstProgression,
                        indexMissingElementFirstProgression));
                userAnswer = Engine.getUserIntegerAnswer(StaticVariables.QUESTION
                        + getStringProgression(firstProgression, indexMissingElementFirstProgression));
                System.out.println(StaticVariables.ANSWER + userAnswer);
                correctAnswer = firstProgression[indexMissingElementFirstProgression];
                if (isCorrect(correctAnswer, userAnswer)) {
                    counterRightAnswer++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was '"
                            + correctAnswer + "'.\nLet's try again, " + App.getUserName() + "!");
                    break;
                }
            } else if (randomNumbForInterval <= FIRST_DETERMINANT_SECOND_OPERATION
                    && randomNumbForInterval > SECOND_DETERMINANT_SECOND_OPERATION) {
                int[] secondProgression = getProgression(INTERVAL_SECOND_PROGRESSION);
                int indexMissingElementSecondProgression = getIndexMissingElement(Engine.getRandomNumberToTen());
                System.out.println(StaticVariables.QUESTION + getStringProgression(secondProgression,
                        indexMissingElementSecondProgression));
                userAnswer = Engine.getUserIntegerAnswer(StaticVariables.QUESTION
                        + getStringProgression(secondProgression, indexMissingElementSecondProgression));
                System.out.println(StaticVariables.ANSWER + userAnswer);
                correctAnswer = secondProgression[indexMissingElementSecondProgression];
                if (isCorrect(correctAnswer, userAnswer)) {
                    counterRightAnswer++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was '"
                            + correctAnswer + "'.\nLet's try again, " + App.getUserName() + "!");
                    break;
                }
            } else {
                int[] thirdProgression = getProgression(INTERVAL_THIRD_PROGRESSION);
                int indexMissingElementThirdProgression = getIndexMissingElement(Engine.getRandomNumberToTen());
                System.out.println(StaticVariables.QUESTION + getStringProgression(thirdProgression,
                        indexMissingElementThirdProgression));
                userAnswer = Engine.getUserIntegerAnswer(StaticVariables.QUESTION
                        + getStringProgression(thirdProgression, indexMissingElementThirdProgression));
                System.out.println(StaticVariables.ANSWER + userAnswer);
                correctAnswer = thirdProgression[indexMissingElementThirdProgression];
                if (isCorrect(correctAnswer, userAnswer)) {
                    counterRightAnswer++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was '"
                            + correctAnswer + "'.\nLet's try again, " + App.getUserName() + "!");
                    break;
                }
            }
        }
        if (counterRightAnswer >= StaticVariables.TRIES) {
            System.out.println("Congratulations, " + App.getUserName() + "!");
        }
    }

    public static int[] getProgression(int intervalBetweenNumbers) {
        final int progressionLength = 10;
        final int progressionIntervalPattern = 3;
        int[] progression = new int[progressionLength];
        int firstElement = Engine.getRandomNumberToHundred();
        progression[0] = firstElement;

        for (int i = 0; i < progression.length; i++) {

            progression[i] = firstElement++;
        }
        int[] progression1 = new int[progressionLength];

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

    public static String getStringProgression(int[] progression, int indexMissingElement) {
        StringBuilder progressionString = new StringBuilder("");
        for (int i = 0; i < progression.length; i++) {
            if (i == indexMissingElement) {
                progressionString.append(".. ");
            } else {
                progressionString.append(progression[i] + " ");
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
}
