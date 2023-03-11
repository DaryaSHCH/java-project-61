package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.StaticVariables;

import static hexlet.code.Engine.getRandomNumber;

public class CalculatorGame extends Game {
    static final String[] OPERATORS = {"+", "-", "*"};
    public CalculatorGame(String userName) {
        super(userName);
    }

    @Override
    protected String getStartMessage() {
        return "What is the result of the expression?";
    }

    @Override
    protected GameTryResult processUserTry() {
        String[] roundsData = generateRoundData();
        String userAnswer = Engine.getUserStringAnswer(StaticVariables.QUESTION + roundsData[0]);
        System.out.println(StaticVariables.ANSWER + userAnswer);
        String correctAnswer = roundsData[1];

        return new GameTryResult(
                correctAnswer,
                userAnswer
        );
    }
    public static String[] generateRoundData() {

        int firstNumberForUserTask = getRandomNumber(StaticVariables.MIN_VALUE_FOR_RANDOM,
                StaticVariables.MAX_VALUE_FOR_RANDOM_TO_HUNDRED);
        int secondNumberForUserTask = getRandomNumber(StaticVariables.MIN_VALUE_FOR_RANDOM,
                StaticVariables.MAX_VALUE_FOR_RANDOM_TO_HUNDRED);
        int randomIndexForMathExample = Engine.getRandomNumber(0, OPERATORS.length - 1);
        String chosenOperator = OPERATORS[randomIndexForMathExample];
        String question = firstNumberForUserTask + " " + chosenOperator + " " + secondNumberForUserTask;
        String answer = Integer.toString(getCalculatedResult(chosenOperator, firstNumberForUserTask,
                secondNumberForUserTask));

        return new String[] {question, answer};
    }
    public static int getCalculatedResult(String signMathOperation, int firstOperand, int secondOperand) {
        int calculatedResult;
        switch (signMathOperation) {
            case "+" -> {
                calculatedResult = firstOperand + secondOperand;
                return calculatedResult;
            }
            case "-" -> {
                calculatedResult = firstOperand - secondOperand;
                return calculatedResult;
            }
            case "*" -> {
                calculatedResult = firstOperand * secondOperand;
                return calculatedResult;
            }
            default -> {
                calculatedResult = 0;
                return calculatedResult;
            }
        }
    }
}
