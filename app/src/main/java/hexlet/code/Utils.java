package hexlet.code;

import java.util.Random;
import static hexlet.code.Engine.getScan;

public class Utils {
    static int inputChoiceNumber() {
        int number;
        while (!getScan().hasNextInt()) {
            var line = getScan().nextLine();
            System.out.println(App.USER_CHOICE);
        }
        number = getScan().nextInt();
        return number;
    }

    public static String getUserStringInput(String message) {
        String userAnswer;
        do {
            System.out.println(message);
            userAnswer = getScan().nextLine();
        } while (userAnswer.trim().equals(""));
        return userAnswer;
    }
    public static String getUserInput(String message) {
        String userName;
        userName = getScan().nextLine();
        while (userName.trim().equals("")) {
            System.out.println(message);
            userName = getScan().nextLine();
        }
        return userName;
    }

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    public static String getCorrectAnswer(boolean result) {
        return result ? "yes" : "no";
    }
}
