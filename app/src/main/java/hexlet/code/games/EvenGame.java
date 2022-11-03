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
        String correctAnswer;
        for (int i = 0; i < StaticVariables.TRIES; i++) {
            int presentRandomNumb = Engine.getRandomNumberToTen();
            String userAnswer = Engine.getUserStringAnswer(StaticVariables.QUESTION + presentRandomNumb + "\nYour answer: ");
            correctAnswer = getCorrectAnswer(presentRandomNumb);
            if ((userAnswer.equalsIgnoreCase("yes") && isEven(presentRandomNumb))
                    || (userAnswer.equalsIgnoreCase("no") && !isEven(presentRandomNumb))) {
                System.out.println("Correct!");
                counterCorrectAnswer++;
            } else {
                System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was '" +
                        correctAnswer + "'.\nLet's try again, " + App.USER_NAME + "!");
                App.main(null);
            }
        }

        if (counterCorrectAnswer >= StaticVariables.TRIES) {
            System.out.println("Congratulations, " + App.USER_NAME + "!");
            App.main(null);
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

    private static void checkRightAnswer(int presentRandomNumb, String userAnswer) {
        if (userAnswer.equalsIgnoreCase("yes") && isEven(presentRandomNumb) ||
                userAnswer.equalsIgnoreCase("no") && !isEven(presentRandomNumb)) {
            System.out.println("Correct!");
        } else {
            System.out.println("you made Mistake");
        }
    }

    public static boolean isCorrect(String correctAnswer, String userAnswer) {
        return correctAnswer.equals(userAnswer);
    }

    public static boolean isEven(int randomNumb) {
        return randomNumb % 2 == 0;
    }
}
