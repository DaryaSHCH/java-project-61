package hexlet.code.games;

import hexlet.code.StaticVariables;

import static hexlet.code.StaticVariables.CORRECT_RESULT;

public abstract class Game {

    private final String userName;

    protected Game(final String userName) {
        this.userName = userName;
    }

    protected abstract String getStartMessage();

    protected abstract GameTryResult processUserTry();

    public void start() {
        System.out.println(getStartMessage());

        boolean hasWrongAnswer = false;

        for (int i = 0; i < StaticVariables.TRIES; i++) {
            GameTryResult tryResult = processUserTry();

            boolean isCorrectAnswer = tryResult.getUserAnswer()
                    .equals(tryResult.getCorrectAnswer());

            if (isCorrectAnswer) {
                System.out.println(CORRECT_RESULT);
            } else {
                System.out.println("'" + tryResult.getUserAnswer() + "'"
                        + " is wrong answer ;(. Correct answer was '"
                        + tryResult.getCorrectAnswer()
                        + "'.\nLet's try again, " + userName + "!");

                hasWrongAnswer = true;

                break;
            }
        }

        if (!hasWrongAnswer) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }

    protected static class GameTryResult {
        private final String correctAnswer;
        private final String userAnswer;

        protected GameTryResult(String correctAnswer, String userAnswer) {
            this.correctAnswer = correctAnswer;
            this.userAnswer = userAnswer;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }

        public String getUserAnswer() {
            return userAnswer;
        }
    }

}
