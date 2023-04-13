package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class CalculatorGame {
    private static final String MAIN_CALC_QUESTION = "What is the result of the expression?";
    private static final String[] OPERATORS = {"+", "-", "*"};
    private static final int MIN_VALUE_FOR_RANDOM = 1;
    private static final int MAX_VALUE_FOR_RANDOM_TO_TEN = 10;

    private static final int QUESTION_AND_ANSWER_LENGTH = 2;

    public static void startCalc() {
        Engine.startGame(MAIN_CALC_QUESTION, generateAndGetQuestionsAndAnswers());
    }

    public static String[][] generateAndGetQuestionsAndAnswers() {
        String[][] questionAndAnswer = new String[Engine.TRIES][QUESTION_AND_ANSWER_LENGTH];

        for (int i = 0; i < Engine.TRIES; i++) {
            int firstOperand = Utils.getRandomNumber(MIN_VALUE_FOR_RANDOM, MAX_VALUE_FOR_RANDOM_TO_TEN);
            int secondOperand = Utils.getRandomNumber(MIN_VALUE_FOR_RANDOM, MAX_VALUE_FOR_RANDOM_TO_TEN);
            int sign = Utils.getRandomNumber(0, OPERATORS.length - 1);

            questionAndAnswer[i][0] = getStringMathExpression(firstOperand, sign, secondOperand);
            questionAndAnswer[i][1] = Integer.toString(getCalculatedResult(OPERATORS[sign],
                    firstOperand, secondOperand));
        }
        return questionAndAnswer;
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
                throw new RuntimeException("Unknown input: " + signMathOperation);
            }
        }
    }
    public static String getStringMathExpression(int firstOperand, int sign, int secondOperand) {
        return Integer.toString(firstOperand) + " " + OPERATORS[sign] + " " + Integer.toString(secondOperand);
    }
}
