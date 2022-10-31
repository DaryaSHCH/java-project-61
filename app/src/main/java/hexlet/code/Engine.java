package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    static int inputChoiceNumber() {
        Scanner scan = new Scanner(System.in);
        int number;
        while (!scan.hasNextInt()){
            var line = scan.nextLine();
            System.out.println(App.USER_CHOICE);
        }
        number = scan.nextInt();
        return number;
    }
    static String getUserStringAnswer(String message) {
        Scanner scan = new Scanner(System.in);
        String userAnswer;
        do {
            System.out.println(message);

            userAnswer = scan.nextLine();
        } while (userAnswer.trim().equals(""));

        return userAnswer;
    }
    static int getUserIntegerAnswer(String message) {
        Scanner scan = new Scanner(System.in);
        int userAnswer;
        while (!scan.hasNextInt()){
            var line = scan.nextLine();
            System.out.println(message);
        }
        userAnswer = scan.nextInt();
        return userAnswer ;
    }
    public static int getRandomNumberToTen() {
        int min = 1;
        int max = 10;
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    public static int getRandomNumberToHundred(){
        int min = 1;
        int max = 100;
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
