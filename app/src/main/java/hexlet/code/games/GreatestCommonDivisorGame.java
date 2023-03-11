package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public class GreatestCommonDivisorGame extends Game {

    private static final String QUESTION = "Question: ";

    public GreatestCommonDivisorGame(String userName) {
        super(userName);
    }

    @Override
    protected String getStartMessage() {
        return "Find the greatest common divisor of given numbers.";
    }

    @Override
    protected GameTryResult processUserTry() {
        int firstNumberForUserTask = Engine.getRandomNumber(StaticVariables.MIN_VALUE_FOR_RANDOM,
                StaticVariables.MAX_VALUE_FOR_RANDOM_TO_HUNDRED);
        int secondNumberForUserTask = Engine.getRandomNumber(StaticVariables.MIN_VALUE_FOR_RANDOM,
                StaticVariables.MAX_VALUE_FOR_RANDOM_TO_HUNDRED);

        System.out.println(QUESTION  + firstNumberForUserTask + " " + secondNumberForUserTask);

        int userAnswer = Engine.getUserIntegerAnswer(QUESTION + firstNumberForUserTask + " "
                + secondNumberForUserTask);
        int correctAnswer = getGCD(firstNumberForUserTask, secondNumberForUserTask);

        return new GameTryResult(
                String.valueOf(correctAnswer),
                String.valueOf(userAnswer)
        );
    }

    public static int getGCD(int firstNumber, int secondNumber) {
        if (firstNumber == 0) {
            return secondNumber;
        }

        return getGCD(secondNumber % firstNumber, firstNumber);
    }
}
