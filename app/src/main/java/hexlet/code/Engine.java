package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static Scanner scan = new Scanner(System.in);

    static int inputChoiceNumber() {
        int number;
        while (!scan.hasNextInt()) {
            var line = scan.nextLine();
            System.out.println(StaticVariables.USER_CHOICE);
        }
        number = scan.nextInt();
        return number;
    }

    public static String getUserStringAnswer(String message) {
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
