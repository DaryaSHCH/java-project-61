package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.StaticVariables;

public final class EvenGame extends Game {
    public EvenGame(final String userName) {
        super(userName);
    }

    @Override
    protected String getStartMessage() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    @Override
    protected GameTryResult processUserTry() {
        String[] roundsData = generateRoundData();
        String userAnswer = Engine.getUserStringAnswer(StaticVariables.QUESTION + roundsData[0]);
        System.out.println(StaticVariables.ANSWER + userAnswer);
        String correctAnswer = roundsData[1];

        return new GameTryResult(
                correctAnswer,
                userAnswer
        );
    }

    private static String[] generateRoundData() {
        int number = Engine.getRandomNumber(
                StaticVariables.MIN_VALUE_FOR_RANDOM,
                StaticVariables.MAX_VALUE_FOR_RANDOM_TO_TEN);
        String questionNumber = String.valueOf(number);
        String[] roundsData = new String[2];
        roundsData[0] = questionNumber;
        roundsData[1] = isEven(number) ? "yes" : "no";
        return roundsData;
    }

    public static boolean isEven(int randomNumb) {
        return randomNumb % 2 == 0;
    }
}
