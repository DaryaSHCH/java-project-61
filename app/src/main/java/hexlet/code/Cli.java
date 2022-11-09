package hexlet.code;

import static hexlet.code.Engine.scan;

public class Cli {
    public static void greetUser() {
        System.out.println("Welcome to the Brain Games!");
        String userName;
        userName = getUserName("May I have your name?");
        System.out.println("Hello, " + userName + "!");
        App.setUserName(userName);
    }

    public static String getUserName(String message) {
        String userName;
        userName = scan.nextLine();
        while (userName.trim().equals("")) {
            System.out.println(message);
            userName = scan.nextLine();
        }
        return userName;
    }
}
