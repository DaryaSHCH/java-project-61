package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public class ArithmeticProgression {
    static final int determinantFirstOperation = 3;
    static final int firstDeterminantSecondOperation = 10;
    static final int secondDeterminantSecondOperation = 5;
    static final int intervalFirstProgression = 2;
    static final int intervalSecondProgression = 3;
    static final int intervalThirdProgression = 5;
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
            if (randomNumbForInterval <= determinantFirstOperation) {
                int[] firstProgression = getProgression(intervalFirstProgression);
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
                            + correctAnswer + "'.\nLet's try again, " + App.userName + "!");
                    break;
                }
            } else if (randomNumbForInterval <= firstDeterminantSecondOperation
                    && randomNumbForInterval > secondDeterminantSecondOperation) {
                int[] secondProgression = getProgression(intervalSecondProgression);
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
                            + correctAnswer + "'.\nLet's try again, " + App.userName + "!");
                    break;
                }
            } else {
                int[] thirdProgression = getProgression(intervalThirdProgression);
                int indexMissingElementThirdProgression = getIndexMissingElement(Engine.getRandomNumberToTen());
                System.out.println(StaticVariables.QUESTION + getStringProgression(thirdProgression, indexMissingElementThirdProgression));
                userAnswer = Engine.getUserIntegerAnswer(StaticVariables.QUESTION + getStringProgression(thirdProgression, indexMissingElementThirdProgression));
                System.out.println(StaticVariables.ANSWER + userAnswer);
                correctAnswer = thirdProgression[indexMissingElementThirdProgression];
                if (isCorrect(correctAnswer, userAnswer)) {
                    counterRightAnswer++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was '"
                            + correctAnswer + "'.\nLet's try again, " + App.userName + "!");
                }
            }
        }
        if (counterRightAnswer >= StaticVariables.TRIES) {
            System.out.println("Congratulations, " + App.userName + "!");
        }
    }

    public static int[] getProgression(int intervalBetweenNumbers) {
        int[] progression = new int[10];
        int firstElement = Engine.getRandomNumberToHundred();
        progression[0] = firstElement;

        for (int i = 0; i < progression.length; i++) {

            progression[i] = firstElement++;
        }
        int[] progression1 = new int[10];

        for (int i = 0; i < progression.length; i++) {
            if (intervalBetweenNumbers == 2) {
                firstElement++;
                progression1[i] = firstElement++;
            } else if (intervalBetweenNumbers == 3) {
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
