package hexlet.code;

import java.util.Random;

public class Utils {
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
