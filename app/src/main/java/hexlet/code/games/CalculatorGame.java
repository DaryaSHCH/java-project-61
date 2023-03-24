package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public final class CalculatorGame {
    private static final String[] OPERATORS = {"+", "-", "*"};
    private static final String[] mathExpressions = new String[StaticVariables.TRIES];
    private static final String[] correctAnswerForCalc = new String[StaticVariables.TRIES];

    public static void startCalc() {
        String mainQuestion = "What is the result of the expression?";
        int[] firstOperands = generateRoundsOperand();
        int[] secondOperands = generateRoundsOperand();
        fillQuestionsAndAnswers(firstOperands, secondOperands);
        Engine.startGame(mainQuestion, mathExpressions, correctAnswerForCalc);
    }

    private static int[] generateRoundsOperand() {
        int[] operands = new int[StaticVariables.TRIES];
        for (int i = 0; i < operands.length; i++) {
            int randomNumber = Engine.getRandomNumber(
                    StaticVariables.MIN_VALUE_FOR_RANDOM,
                    StaticVariables.MAX_VALUE_FOR_RANDOM_TO_TEN);
            operands[i] = randomNumber;
        }
        return operands;
    }

    public static void fillQuestionsAndAnswers(int[] firstOperands, int[] secondOperands) {
        for (int i = 0; i < mathExpressions.length; i++) {
            int randomIndex = Engine.getRandomNumber(0, OPERATORS.length - 1);
            String chosenOperator = OPERATORS[randomIndex];
            mathExpressions[i] = firstOperands[i] + " " + chosenOperator + " " + secondOperands[i];
            correctAnswerForCalc[i] = Integer.toString(getCalculatedResult(chosenOperator,
                    firstOperands[i],
                    secondOperands[i]));

        }
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
}
