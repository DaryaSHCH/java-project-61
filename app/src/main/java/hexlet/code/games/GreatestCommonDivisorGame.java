package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public class GreatestCommonDivisorGame {
    static final String QUESTION = "Question: ";

    public static void start(){
        System.out.println("Find the greatest common divisor of given numbers.");
        getGCDGame();
    }
    public static void getGCDGame(){
        int counterCorrectAnswer = 0;
        int correctAnswer;
        for (int i = 0; i < StaticVariables.TRIES; i++) {
            int firstNumberForUserTask = Engine.getRandomNumberToHundred();
            int secondNumberForUserTask  = Engine.getRandomNumberToHundred();
            int userAnswer;
            System.out.println(QUESTION +"\n" + firstNumberForUserTask + " " + secondNumberForUserTask + "\nYour answer: ");
            userAnswer = Engine.getUserIntegerAnswer(QUESTION + firstNumberForUserTask + " "
                    + secondNumberForUserTask + "\nYour answer: ");
            correctAnswer = getGCD(firstNumberForUserTask, secondNumberForUserTask);
            if (isCorrect(correctAnswer, userAnswer)) {
                counterCorrectAnswer++;
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "'" + "is wrong answer ;(. Correct answer was '" +
                        correctAnswer + "'.\n" +
                        "Let's try again, " + App.USER_NAME +"!");
            }
        }
        if (counterCorrectAnswer >= StaticVariables.TRIES) {
            System.out.println("Congratulations, " + App.USER_NAME + "!");
        } else {
            System.out.println("Quantity of correct answers: " + counterCorrectAnswer + "\nGAME OVER");
        }
    }
    public static int getGCD(int firstNumber, int secondNumber){
        if (firstNumber == 0)
            return secondNumber;

        return getGCD(secondNumber % firstNumber, firstNumber);
    }
    public static boolean isCorrect(int correctAnswer, int userAnswer) {
        if (correctAnswer == userAnswer) {
            return true;
        } else {
            return false;
        }
    }
}
