package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.StaticVariables;

import static hexlet.code.Engine.getRandomNumberToTen;

public class CalculatorGame {

    static final String[] OPERATORS = {"+", "-", "*"};
    public static void start() {

        System.out.println("What is the result of the expression?");
        getCalculatorGame();

    }

    public static void getCalculatorGame() {
        String correctAnswer;
        int counterCorrectAnswer = 0;
        String userAnswer;
        String result;
        for (int i = 0; i < StaticVariables.TRIES; i++) {
            String[] roundsData = generateRoundData();
            userAnswer = Engine.getUserStringAnswer(StaticVariables.QUESTION + roundsData[0]);
            System.out.println(StaticVariables.ANSWER + userAnswer);
            correctAnswer = roundsData[1];
            Engine.printResult(userAnswer, correctAnswer);
        }
            System.out.println("Congratulations, " + App.getUserName() + "!");
    }

    public static String[] generateRoundData() {

        int firstNumberForUserTask = getRandomNumberToTen();
        int secondNumberForUserTask = getRandomNumberToTen();
        int randomIndexForMathExample = Engine.generateRandomNumber(OPERATORS.length);
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
