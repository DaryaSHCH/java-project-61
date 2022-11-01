package hexlet.code;

import static hexlet.code.Engine.SCAN;

public class Cli {
    public static void greetUser() {
        System.out.println("Welcome to the Brain Games!");
        String userName;
        userName = getUserName("May I have your name?");
        System.out.println("Hello, " + userName + "!");
        App.USER_NAME = userName;
    }
    public static String getUserName(String message){
        String userName;
        userName = SCAN.nextLine();
        while (userName.trim().equals("")) {
                System.out.println(message);
            userName = SCAN.nextLine();
            }
        return userName;
    }
}
