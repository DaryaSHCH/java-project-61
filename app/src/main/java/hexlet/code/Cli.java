package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greetUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");

        String userName;
        do {
            System.out.println("May I have your name?");
            userName = scan.nextLine();
        } while (userName.trim().isBlank());

        System.out.println("Hello, " + userName + "!");

        App.USER_NAME = userName;
        scan.close();
    }
}
