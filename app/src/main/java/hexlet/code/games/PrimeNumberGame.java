package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public class PrimeNumberGame {
    public static void start() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        getPrimeNumberGame();
    }

    public static void getPrimeNumberGame() {

        int counterRightAnswer = 0;

        for (int i = 0; i < StaticVariables.TRIES; i++) {
            String[] roundsData = generateRoundData();
            String userAnswer = Engine.getUserStringAnswer(StaticVariables.QUESTION + roundsData[0]);
            System.out.println(StaticVariables.ANSWER + userAnswer);
            String correctAnswer = roundsData[1];
            if (userAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                counterRightAnswer++;
            } else {
                if (userAnswer.equals("yes")) {
                    correctAnswer = "no";
                } else {
                    correctAnswer = "yes";
                }
                System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.\nLet's try again, " + App.getUserName() + "!");
                break;
            }
        }
        if (counterRightAnswer >= StaticVariables.TRIES) {
            System.out.println("Congratulations, " + App.getUserName() + "!");
        }
    }
    private static String[] generateRoundData() {
        int number = Engine.getRandomNumberToHundred();

        String questionNumber = String.valueOf(number);

        String[] roundsData = new String[2];
        roundsData[0] = questionNumber;
        roundsData[1] = getCorrectAnswer(number);


        return roundsData;
    }

    public static boolean isPrime(int number) {
        final int caseForOne = 1;
        final int caseForThree = 3;
        final int firstDeterminantCycle = 5;
        final int secondDeterminantCycle = 6;

        if (number <= caseForOne) {
            return false;
        }

        if (number <= caseForThree) {
            return true;
        }

        if (number % 2 == 0 || number % caseForThree == 0) {
            return false;
        }

        for (int i = firstDeterminantCycle; i * i <= number; i = i + secondDeterminantCycle) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    private static String getCorrectAnswer(int randomNumb) {
        String correctAnswer;
        if (isPrime(randomNumb)) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }
        return correctAnswer;
    }
}
