package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.StaticVariables;

import static hexlet.code.Engine.SCAN;

public class EvenGame {

    public static void start() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        getEvenGame();
    }

    public static void getEvenGame() {
        int counterCorrectAnswer = 0;
        String correctAnswer;
        String userAnswer;
        int tries = 0;
        do {
            tries++;
            int presentRandomNumb = Engine.getRandomNumberToTen();
            System.out.println(StaticVariables.QUESTION + presentRandomNumb);
            System.out.print("Your answer: " + getFinalString(getUserAnswer(),getCorrectAnswer(presentRandomNumb)));
        } while (tries != 3);

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

    public static boolean isCorrect(String correctAnswer, String userAnswer) {
        return correctAnswer.equalsIgnoreCase(userAnswer);
    }
    public static String getFinalString(String answer, String corAns) {
        if (answer.equalsIgnoreCase(corAns)) {
            return  "Correct!\n";
        } else {
            return  "\033[1A" + " is wrong answer ;(. Correct answer was '" +
                    corAns + "'.\nLet's try again, " + App.USER_NAME + "!";
        }
    }

    public static boolean isEven(int randomNumb) {
        return randomNumb % 2 == 0;
    }
    public static String getUserAnswer(){
        String answer = SCAN.next();
        return answer;
    }
    public static String getResult(String userAnswer, String correctAnswer){
        String result;
        if (userAnswer.equalsIgnoreCase(correctAnswer)) {
            return result = "\033[1A" + "Correct!\n";
        } else {
            return result = "\033[1A" + " is wrong answer ;(. Correct answer was '" +
                    correctAnswer + "'.\nLet's try again, " + App.USER_NAME + "!";
        }
    }
}
