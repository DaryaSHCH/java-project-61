package hexlet.code.games;

public class CalculatorGame {
    public static void start(){

        System.out.println("What is the result of the expression?");
        getCalculatorGame();

    }
    public static void getCalculatorGame(){
        int correctAnswer;
        int counterRightAnswer = 0;

        for (int i = 0; i < StaticVariables.TRIES; i++) {
            int firstNumberForUserTask = getRandomNumberToTen();
            int secondNumberForUserTask = getRandomNumberToTen();
            int randomNumberForMathExample = getRandomNumberToTen();
            int userAnswer;
            if (randomNumberForMathExample < 5) {
                System.out.println (StaticVariables.QUESTION + firstNumberForUserTask + " + "
                        + secondNumberForUserTask + "\nYour answer: ");
                userAnswer = Engine.getUserIntegerAnswer(StaticVariables.QUESTION + firstNumberForUserTask + " + "
                        + secondNumberForUserTask + "\nYour answer: ");
                correctAnswer = firstNumberForUserTask + secondNumberForUserTask;
                if (isCorrect(correctAnswer, userAnswer)) {
                    counterRightAnswer++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("'" + userAnswer + "'" + "is wrong answer ;(. Correct answer was '" +
                            correctAnswer + "'.\nLet's try again, " + App.USER_NAME +"!");
                }
            } else if (randomNumberForMathExample <= 10 && randomNumberForMathExample > 5) {
                System.out.println(StaticVariables.QUESTION + firstNumberForUserTask + " * "
                        + secondNumberForUserTask + "\nYour answer: ");
                userAnswer = Engine.getUserIntegerAnswer(StaticVariables.QUESTION + firstNumberForUserTask + " * "
                        + secondNumberForUserTask + "\nYour answer: ");
                correctAnswer = firstNumberForUserTask * secondNumberForUserTask;
                if (isCorrect(correctAnswer, userAnswer)) {
                    counterRightAnswer++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("'" + userAnswer + "'" + "is wrong answer ;(. Correct answer was '" +
                            correctAnswer + "'.\nLet's try again, " + App.USER_NAME +"!");
                }
            } else {
                System.out.println(StaticVariables.QUESTION + firstNumberForUserTask + " - "
                        + secondNumberForUserTask + "\nYour answer: ");
                userAnswer = Engine.getUserIntegerAnswer(StaticVariables.QUESTION + firstNumberForUserTask + " - "
                        + secondNumberForUserTask + "\nYour answer: ");
                correctAnswer = firstNumberForUserTask - secondNumberForUserTask;
                if (isCorrect(correctAnswer, userAnswer)) {
                    counterRightAnswer++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("'" + userAnswer + "'" + "is wrong answer ;(. Correct answer was '" +
                            correctAnswer + "'.\nLet's try again, " + App.USER_NAME +"!");
                }
            }
        }
        if (counterRightAnswer >= StaticVariables.TRIES) {
            System.out.println("Congratulations, " + App.USER_NAME + "!");
            App.main(null);
        } else {
            System.out.println("Quantity correct answers: " + counterRightAnswer + "\nGAME OVER");
        }
    }
    public static boolean isCorrect(int correctAnswer, int userAnswer) {
        if (correctAnswer == userAnswer) {
            return true;
        } else {
            return false;
        }
    }
}
