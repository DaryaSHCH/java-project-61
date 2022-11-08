package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.StaticVariables;

import static hexlet.code.Engine.getRandomNumberToTen;

public class CalculatorGame {
    public static void start() {

        System.out.println("What is the result of the expression?");
        getCalculatorGame();

    }

    public static void getCalculatorGame() {
        int correctAnswer;
        int counterRightAnswer = 0;

        for (int i = 0; i < StaticVariables.TRIES; i++) {
            int firstNumberForUserTask = getRandomNumberToTen();
            int secondNumberForUserTask = getRandomNumberToTen();
            int randomNumberForMathExample = getRandomNumberToTen();
            int userAnswer;
            if (randomNumberForMathExample < 5) {
                System.out.println(StaticVariables.QUESTION + firstNumberForUserTask + " + "
                        + secondNumberForUserTask);
                userAnswer = Engine.getUserIntegerAnswer(StaticVariables.QUESTION + firstNumberForUserTask + " + "
                        + secondNumberForUserTask);
                System.out.println(StaticVariables.ANSWER + userAnswer);
                correctAnswer = firstNumberForUserTask + secondNumberForUserTask;
                if (isCorrect(correctAnswer, userAnswer)) {
                    counterRightAnswer++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("'" + userAnswer + "'" + "is wrong answer ;(. Correct answer was '" +
                            correctAnswer + "'.\nLet's try again, " + App.USER_NAME + "!");
                    break;
                }
            } else if (randomNumberForMathExample <= 10 && randomNumberForMathExample > 5) {
                System.out.println(StaticVariables.QUESTION + firstNumberForUserTask + " * "
                        + secondNumberForUserTask);
                userAnswer = Engine.getUserIntegerAnswer(StaticVariables.QUESTION + firstNumberForUserTask + " * "
                        + secondNumberForUserTask);
                System.out.println(StaticVariables.ANSWER + userAnswer);
                correctAnswer = firstNumberForUserTask * secondNumberForUserTask;
                if (isCorrect(correctAnswer, userAnswer)) {
                    counterRightAnswer++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("'" + userAnswer + "'" + "is wrong answer ;(. Correct answer was '" +
                            correctAnswer + "'.\nLet's try again, " + App.USER_NAME + "!");
                    break;
                }
            } else {
                System.out.println(StaticVariables.QUESTION + firstNumberForUserTask + " - "
                        + secondNumberForUserTask);
                userAnswer = Engine.getUserIntegerAnswer(StaticVariables.QUESTION + firstNumberForUserTask + " - "
                        + secondNumberForUserTask);
                System.out.println(StaticVariables.ANSWER + userAnswer);
                correctAnswer = firstNumberForUserTask - secondNumberForUserTask;
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

    public static boolean isCorrect(int correctAnswer, int userAnswer) {
        return correctAnswer == userAnswer;
    }
}
