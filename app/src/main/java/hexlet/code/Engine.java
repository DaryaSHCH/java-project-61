package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    static Scanner SCAN = new Scanner(System.in);

    static int inputChoiceNumber() {
            int number;
            while (!SCAN.hasNextInt()){
                var line = SCAN.nextLine();
                System.out.println(App.USER_CHOICE);
            }
            number = SCAN.nextInt();
            return number;
        }
        public static String getUserStringAnswer(String message) {
            String userAnswer;
            do {
                System.out.println(message);
                userAnswer = SCAN.nextLine();
            } while (userAnswer.trim().equals(""));
            return userAnswer;
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
    public static int getUserIntegerAnswer(String message) {
        int userAnswer;
        while (!SCAN.hasNextInt()){
            var line = SCAN.nextLine();
            System.out.println(message);
        }
        userAnswer = SCAN.nextInt();
        return userAnswer;
    }
    public static void closeSCAN(){
        SCAN.close();
    }
}
