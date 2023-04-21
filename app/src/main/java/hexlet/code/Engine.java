package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int TRIES = 3;
    public static void startGame(String mainGameQuestion, String[][] questionsAndAnswers) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String userName = scan.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(mainGameQuestion);
        for (int i = 0; i < TRIES; i++) {
            System.out.println("Question: " + questionsAndAnswers[i][0]);
            System.out.print("Your answer: ");
            String userAnswer = scan.next();
            if (userAnswer.equals(questionsAndAnswers[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "'"
                        + " is wrong answer ;(. Correct answer was '"
                        + questionsAndAnswers[i][1]
                        + "'.\nLet's try again, " + userName + "!");
                scan.close();
                return;
            }
        }
        scan.close();
        System.out.println("Congratulations, " + userName + "!");
    }
}
