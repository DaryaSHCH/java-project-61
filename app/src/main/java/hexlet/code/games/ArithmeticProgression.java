package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public class ArithmeticProgression {
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
            if (randomNumbForInterval <= 3) {
                int[] firstProgression = getProgression(2);
                int indexMissingElementFirstProgression = getIndexMissingElement(Engine.getRandomNumberToTen());
                System.out.println(StaticVariables.QUESTION + getStringProgression(firstProgression, indexMissingElementFirstProgression));
                userAnswer = Engine.getUserIntegerAnswer(StaticVariables.QUESTION + getStringProgression(firstProgression, indexMissingElementFirstProgression));
                System.out.println(StaticVariables.ANSWER + userAnswer);
                correctAnswer = firstProgression[indexMissingElementFirstProgression];
                if (isCorrect(correctAnswer, userAnswer)) {
                    counterRightAnswer++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was '" +
                            correctAnswer + "'.\nLet's try again, " + App.USER_NAME + "!");
                    break;
                }
            } else if (randomNumbForInterval <= 10 && randomNumbForInterval > 5) {
                int[] secondProgression = getProgression(3);
                int indexMissingElementSecondProgression = getIndexMissingElement(Engine.getRandomNumberToTen());
                System.out.println(StaticVariables.QUESTION + getStringProgression(secondProgression, indexMissingElementSecondProgression));
                userAnswer = Engine.getUserIntegerAnswer(StaticVariables.QUESTION + getStringProgression(secondProgression, indexMissingElementSecondProgression));
                System.out.println(StaticVariables.ANSWER + userAnswer);
                correctAnswer = secondProgression[indexMissingElementSecondProgression];
                if (isCorrect(correctAnswer, userAnswer)) {
                    counterRightAnswer++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was '" +
                            correctAnswer + "'.\nLet's try again, " + App.USER_NAME + "!");
                    break;
                }
            } else {
                int[] thirdProgression = getProgression(5);
                int indexMissingElementThirdProgression = getIndexMissingElement(Engine.getRandomNumberToTen());
                System.out.println(StaticVariables.QUESTION + getStringProgression(thirdProgression, indexMissingElementThirdProgression));
                userAnswer = Engine.getUserIntegerAnswer(StaticVariables.QUESTION + getStringProgression(thirdProgression, indexMissingElementThirdProgression));
                System.out.println(StaticVariables.ANSWER + userAnswer);
                correctAnswer = thirdProgression[indexMissingElementThirdProgression];
                if (isCorrect(correctAnswer, userAnswer)) {
                    counterRightAnswer++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was '" +
                            correctAnswer + "'.\nLet's try again, " + App.USER_NAME + "!");
                }
            }
        }
        if (counterRightAnswer >= StaticVariables.TRIES) {
            System.out.println("Congratulations, " + App.USER_NAME + "!");
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
        if (index == 1) {
            return 0;
        } else if (index == 10) {
            return 9;
        } else {
            return index;
        }
    }

    public static boolean isCorrect(int correctAnswer, int userAnswer) {
        return correctAnswer == userAnswer;
    }
}
