package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static Scanner scan = new Scanner(System.in);
    public static void startGame(String mainGameQuestion, String[] questions, String[] correctAnswers) {
        String userName = Cli.greetUserAndGetName();
        System.out.println(mainGameQuestion);
        boolean hasWrongAnswer = false;
        for (int i = 0; i < StaticVariables.TRIES; i++) {
            String userAnswer = Engine.getUserStringInput(StaticVariables.QUESTION + questions[i] + "\nYour answer: ");
            if (userAnswer.equals(correctAnswers[i])) {
                System.out.println(StaticVariables.CORRECT_RESULT);
            } else {
                System.out.println("'" + userAnswer + "'"
                        + " is wrong answer ;(. Correct answer was '"
                        + correctAnswers[i]
                        + "'.\nLet's try again, " + userName + "!");
                hasWrongAnswer = true;

                break;
            }
        }
        if (!hasWrongAnswer) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    static int inputChoiceNumber() {
        int number;
        while (!scan.hasNextInt()) {
            var line = scan.nextLine();
            System.out.println(StaticVariables.USER_CHOICE);
        }
        number = scan.nextInt();
        return number;
    }

    public static String getUserStringInput(String message) {
        String userAnswer;
        do {
            System.out.println(message);
            userAnswer = scan.nextLine();
        } while (userAnswer.trim().equals(""));
        return userAnswer;
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static int getUserIntegerAnswer(String message) {
        int userAnswer;
        while (!scan.hasNextInt()) {
            var line = scan.nextLine();
            System.out.println(message);
        }
        userAnswer = scan.nextInt();
        return userAnswer;
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
