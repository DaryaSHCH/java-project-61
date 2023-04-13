package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int TRIES = 3;
    private static Scanner scan = new Scanner(System.in);
    public static void startGame(String mainGameQuestion, String[][] questionsAndAnswers) {
        System.out.println("Welcome to the Brain Games!");
        String userName;
        userName = Utils.getUserInput("May I have your name?");
        System.out.println("Hello, " + userName + "!");
        System.out.println(mainGameQuestion);

        boolean hasWrongAnswer = false;
        for (int i = 0; i < TRIES; i++) {
            String userAnswer = Utils.getUserStringInput("Question: " + questionsAndAnswers[i][0] + "\nYour answer: ");
            if (userAnswer.equals(questionsAndAnswers[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "'"
                        + " is wrong answer ;(. Correct answer was '"
                        + questionsAndAnswers[i][1]
                        + "'.\nLet's try again, " + userName + "!");
                hasWrongAnswer = true;

                break;
            }
        }
        if (!hasWrongAnswer) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
    private static void setScan(Scanner scanner) {
        Engine.scan = scanner;
    }
    static Scanner getScan() {
        return scan;
    }

    public static void closeSCAN() {
        scan.close();
    }
}
