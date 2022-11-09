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
            int randomNumber = Engine.getRandomNumberToHundred();
            String userAnswer;
            String correctAnswer;
            userAnswer = Engine.getUserStringAnswer(StaticVariables.QUESTION + randomNumber);
            System.out.println(StaticVariables.ANSWER + userAnswer);
            correctAnswer = getCorrectAnswer(randomNumber);
            if ((userAnswer.equalsIgnoreCase("yes") && isPrime(randomNumber))
                    || (userAnswer.equalsIgnoreCase("no") && !isPrime(randomNumber))) {
                System.out.println("Correct!");
                counterRightAnswer++;
            } else {
                if (userAnswer.equalsIgnoreCase("yes") && !isPrime(randomNumber)) {
                    correctAnswer = "no";
                } else {
                    correctAnswer = "yes";
                }
                System.out.println("'" + userAnswer + "'" + " is wrong answer ;(. Correct answer was '"
                        + correctAnswer + "'.\nLet's try again, " + App.userName + "!");
                break;
            }
        }
        if (counterRightAnswer >= StaticVariables.TRIES) {
            System.out.println("Congratulations, " + App.userName + "!");
        }
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
