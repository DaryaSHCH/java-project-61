package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public class GreatestCommonDivisorGame {
    static final String QUESTION = "Question: ";

    public static void start() {
        System.out.println("Find the greatest common divisor of given numbers.");
        getGCDGame();
    }

    public static void getGCDGame() {
        int counterCorrectAnswer = 0;
        int correctAnswer;
        for (int i = 0; i < StaticVariables.TRIES; i++) {
            int firstNumberForUserTask = Engine.getRandomNumber(StaticVariables.MIN_VALUE_FOR_RANDOM,
                    StaticVariables.MAX_VALUE_FOR_RANDOM_TO_HUNDRED);
            int secondNumberForUserTask = Engine.getRandomNumber(StaticVariables.MIN_VALUE_FOR_RANDOM,
                    StaticVariables.MAX_VALUE_FOR_RANDOM_TO_HUNDRED);
            int userAnswer;
            System.out.println(QUESTION  + firstNumberForUserTask + " " + secondNumberForUserTask);
            userAnswer = Engine.getUserIntegerAnswer(QUESTION + firstNumberForUserTask + " "
                    + secondNumberForUserTask);
            System.out.println(StaticVariables.ANSWER + userAnswer);
            correctAnswer = getGCD(firstNumberForUserTask, secondNumberForUserTask);
            if (isCorrect(correctAnswer, userAnswer)) {
                counterCorrectAnswer++;
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.\n" + "Let's try again, " + App.getUserName() + "!");
                break;
            }
        }
        if (counterCorrectAnswer >= StaticVariables.TRIES) {
            System.out.println("Congratulations, " + App.getUserName() + "!");
        }
    }

    public static int getGCD(int firstNumber, int secondNumber) {
        if (firstNumber == 0) {
            return secondNumber;
        }

        return getGCD(secondNumber % firstNumber, firstNumber);
    }

    public static boolean isCorrect(int correctAnswer, int userAnswer) {
        return correctAnswer == userAnswer;
    }
}
