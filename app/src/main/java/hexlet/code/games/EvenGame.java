package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public class EvenGame {
    public static void start() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        getEvenGame();
    }

    public static void getEvenGame() {
        int counterCorrectAnswer = 0;
        int presentRandomNumb;
        String userAnswer;
        String correctAnswer;
        String result;
        for (int i = 0; i < StaticVariables.TRIES; i++) {
            presentRandomNumb = Engine.getRandomNumberToTen();
            userAnswer = Engine.getUserStringAnswer(StaticVariables.QUESTION + presentRandomNumb);
            System.out.println(StaticVariables.ANSWER + userAnswer);
            correctAnswer = getCorrectAnswer(presentRandomNumb);
            result = getResult(userAnswer, correctAnswer);
            if (!result.equals(StaticVariables.CORRECT_RESULT)){
                System.out.println(result);
                break;
            } else {
                System.out.println(result);
                counterCorrectAnswer++;
            }
        }

        if (counterCorrectAnswer >= StaticVariables.TRIES) {
            System.out.println("Congratulations, " + App.getUserName() + "!");
        }
    }

    private static String getResult(String userAnswer, String correctAnswer) {
        if (isCorrect(correctAnswer, userAnswer)) {
            return StaticVariables.CORRECT_RESULT;
        } else {
            return "'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was '"
                    + correctAnswer + "'.\nLet's try again, " + App.getUserName() + "!";
        }
    }

    private static String getCorrectAnswer(int presentRandomNumb) {
        String correctAnswer;
        if (isEven(presentRandomNumb)) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }
        return correctAnswer;
    }

    public static boolean isCorrect(String correctAnswer, String userAnswer) {
        return correctAnswer.equalsIgnoreCase(userAnswer);
    }

    public static boolean isEven(int randomNumb) {
        return randomNumb % 2 == 0;
    }
}
