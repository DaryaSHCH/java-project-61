package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public class EvenGame {
    public static void start() {
        System.out.println("Answer 'yes' if number even otherwise answer 'no'");
        getEvenGame();
    }

    public static void getEvenGame() {
        int counterCorrectAnswer = 0;
        for (int i = 0; i < StaticVariables.TRIES; i++) {
            int presentRandomNumb = Engine.getRandomNumberToTen();

            String userAnswer = Engine.getUserStringAnswer(StaticVariables.QUESTION + presentRandomNumb + "\nYour answer: ");

            if ((userAnswer.equalsIgnoreCase("yes") && isEven(presentRandomNumb))
                    || (userAnswer.equalsIgnoreCase("no") && !isEven(presentRandomNumb))) {
                System.out.println("Correct!");
                counterCorrectAnswer++;
            } else {
                System.out.println("you made mistake");
            }
        }

        if (counterCorrectAnswer >= StaticVariables.TRIES) {
            System.out.println("Congratulations, " + App.USER_NAME + "!");
        } else {
            System.out.println("Quantity correct answers: " + counterCorrectAnswer + "\nGAME OVER");
        }
    }

    private static void checkRightAnswer(int presentRandomNumb, String userAnswer) {
        if (userAnswer.equalsIgnoreCase("yes") && isEven(presentRandomNumb) ||
                userAnswer.equalsIgnoreCase("no") && !isEven(presentRandomNumb)) {
            System.out.println("Correct!");
        } else {
            System.out.println("you made Mistake");
        }
    }

    public static boolean isEven(int randomNumb) {
        return randomNumb % 2 == 0;
    }
}
