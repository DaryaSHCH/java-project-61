package hexlet.code.games;

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
            userAnswer = Engine.getUserStringAnswer(StaticVariables.QUESTION + randomNumber + "\nYour answer: ");
            if ((userAnswer.equalsIgnoreCase("yes") && isPrime(randomNumber))
                    || (userAnswer.equalsIgnoreCase("no") && !isPrime(randomNumber))) {
                System.out.println("Correct!");
                counterRightAnswer++;
            } else {
                if (userAnswer.equalsIgnoreCase("yes") && !isPrime(randomNumber)) {
                    correctAnswer = "no";
                    System.out.println("'" + userAnswer + "'" + "is wrong answer ;(. Correct answer was '" +
                            correctAnswer + "'.\nLet's try again, " + App.USER_NAME +"!");
                } else {
                    correctAnswer = "yes";
                    System.out.println("'" + userAnswer + "'" + "is wrong answer ;(. Correct answer was '" +
                            correctAnswer + "'.\nLet's try again, " + App.USER_NAME +"!");
                }
            }
        }
        if (counterRightAnswer >= StaticVariables.TRIES) {
            System.out.println("Congratulations, " + App.USER_NAME + "!");
        } else {
            System.out.println("Quantity correct answers: " + counterRightAnswer + "\nGAME OVER");
        }
    }
    public static boolean isPrime(int number) {
        {
            if (number <= 1)
                return false;
            if (number <= 3)
                return true;
            if (number % 2 == 0 || number % 3 == 0)
                return false;
            for (int i = 5; i * i <= number; i = i + 6)
                if (number % i == 0 || number % (i + 2) == 0)
                    return false;
            return true;
        }
    }
}
