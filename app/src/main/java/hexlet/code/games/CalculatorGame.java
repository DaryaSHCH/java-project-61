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
        int counterCorrectAnswer = 0;
        final int determinantFirstOperation = 5;
        final int firstDeterminantSecondOperation = 10;
        final int secondDeterminantSecondOperation = 5;
        int firstNumberForUserTask;
        int secondNumberForUserTask;
        int randomNumberForMathExample;
        int userAnswer;
        String result;
        for (int i = 0; i < StaticVariables.TRIES; i++) {
            firstNumberForUserTask = getRandomNumberToTen();
            secondNumberForUserTask = getRandomNumberToTen();
            randomNumberForMathExample = getRandomNumberToTen();
            if (randomNumberForMathExample < determinantFirstOperation) {
                System.out.println(StaticVariables.QUESTION + firstNumberForUserTask + " + "
                        + secondNumberForUserTask);
                userAnswer = Engine.getUserIntegerAnswer(StaticVariables.QUESTION + firstNumberForUserTask + " + "
                        + secondNumberForUserTask);
                System.out.println(StaticVariables.ANSWER + userAnswer);
                correctAnswer = firstNumberForUserTask + secondNumberForUserTask;
                result = getResult(userAnswer,correctAnswer);
                if (!result.equals(StaticVariables.CORRECT_RESULT)){
                    System.out.println(result);
                    break;
                } else {
                    System.out.println(result);
                    counterCorrectAnswer++;
                }
            } else if (randomNumberForMathExample <= firstDeterminantSecondOperation
                    && randomNumberForMathExample > secondDeterminantSecondOperation) {
                System.out.println(StaticVariables.QUESTION + firstNumberForUserTask + " * "
                        + secondNumberForUserTask);
                userAnswer = Engine.getUserIntegerAnswer(StaticVariables.QUESTION + firstNumberForUserTask + " * "
                        + secondNumberForUserTask);
                System.out.println(StaticVariables.ANSWER + userAnswer);
                correctAnswer = firstNumberForUserTask * secondNumberForUserTask;
                result = getResult(userAnswer, correctAnswer);
                if (!result.equals(StaticVariables.CORRECT_RESULT)){
                    System.out.println(result);
                    break;
                } else {
                    System.out.println(result);
                    counterCorrectAnswer++;
                }
            } else {
                System.out.println(StaticVariables.QUESTION + firstNumberForUserTask + " - "
                        + secondNumberForUserTask);
                userAnswer = Engine.getUserIntegerAnswer(StaticVariables.QUESTION + firstNumberForUserTask + " - "
                        + secondNumberForUserTask);
                System.out.println(StaticVariables.ANSWER + userAnswer);
                correctAnswer = firstNumberForUserTask - secondNumberForUserTask;
                result = getResult(userAnswer,correctAnswer);
                if (!result.equals(StaticVariables.CORRECT_RESULT)){
                    System.out.println(result);
                    break;
                } else {
                    System.out.println(result);
                    counterCorrectAnswer++;
                }
            }
        }
        if (counterCorrectAnswer >= StaticVariables.TRIES) {
            System.out.println("Congratulations, " + App.getUserName() + "!");
        }
    }
    private static String getResult(int userAnswer, int correctAnswer) {
        if (isCorrect(correctAnswer, userAnswer)) {
            return StaticVariables.CORRECT_RESULT;
        } else {
            return "'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was '"
                    + correctAnswer + "'.\nLet's try again, " + App.getUserName() + "!";
        }
    }

    public static boolean isCorrect(int correctAnswer, int userAnswer) {
        return correctAnswer == userAnswer;
    }
}
