package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int TRIES = 3;
    public static void startGame(String mainGameQuestion, String[][] questionsAndAnswers) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        String userName;
        userName = getUserName("May I have your name?");
        System.out.println("Hello, " + userName + "!");
        System.out.println(mainGameQuestion);
        for (int i = 0; i < TRIES; i++) {
            String userAnswer = getUserStringInput("Question: " + questionsAndAnswers[i][0] + "\nYour answer: ");
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

    static int inputChoiceNumber() {
        Scanner scan = new Scanner(System.in);
        int number;
        while (!scan.hasNextInt()) {
            var line = scan.nextLine();
            System.out.println(App.USER_CHOICE);
        }
        number = scan.nextInt();
        scan.close();
        return number;
    }

    public static String getUserStringInput(String message) {
        Scanner scan = new Scanner(System.in);
        String userAnswer;
        do {
            System.out.println(message);
            userAnswer = scan.nextLine();
        } while (userAnswer.trim().equals(""));
        scan.close();
        return userAnswer;
    }
    public static String getUserName(String message) {
        Scanner scan = new Scanner(System.in);
        String userName;
        userName = scan.nextLine();
        while (userName.trim().equals("")) {
            System.out.println(message);
            userName = scan.nextLine();
        }
        scan.close();
        return userName;
    }
    public static String getCorrectAnswer(boolean result) {
        return result ? "yes" : "no";
    }
}
