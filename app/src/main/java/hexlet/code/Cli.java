package hexlet.code;

import static hexlet.code.Engine.getScan;

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
        userName = getScan().nextLine();
        while (userName.trim().equals("")) {
            System.out.println(message);
            userName = getScan().nextLine();
        }
        return userName;
    }
}
