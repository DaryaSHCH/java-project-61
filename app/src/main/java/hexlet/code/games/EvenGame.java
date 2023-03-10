package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public class EvenGame {
    public static void start() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        getEvenGame();
    }

    public static void getEvenGame() {
        int counterCorrectAnswer = 0;
        String userAnswer;
        String result;
        for (int i = 0; i < StaticVariables.TRIES; i++) {
            String[] roundsData = generateRoundData();
            userAnswer = Engine.getUserStringAnswer(StaticVariables.QUESTION + roundsData[0]);
            System.out.println(StaticVariables.ANSWER + userAnswer);
            String correctAnswer = roundsData[1];
            Engine.printResult(userAnswer, correctAnswer);
        }
            System.out.println("Congratulations, " + App.getUserName() + "!");
    }
    private static String getCorrectAnswer(int presentRandomNumb) {
        String correctAnswer;
        if (isEven(presentRandomNumb)) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }
        return correctAnswer;
    }

    public static boolean isCorrect(String correctAnswer, String userAnswer) {
        return correctAnswer.equalsIgnoreCase(userAnswer);
    }

    public static boolean isEven(int randomNumb) {
        return randomNumb % 2 == 0;
    }

    private static String[] generateRoundData() {
        int number = Engine.getRandomNumberToTen();
        String questionNumber = String.valueOf(number);
        String[] roundsData = new String[2];
        roundsData[0] = questionNumber;
        roundsData[1] = getCorrectAnswer(number);
        return roundsData;
    }
}
