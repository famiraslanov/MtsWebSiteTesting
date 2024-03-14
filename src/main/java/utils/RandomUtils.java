package utils;

import java.util.Random;

public class RandomUtils {
    public static int getRandomNumber(int from, int to){
        Random random = new Random();

        return random.nextInt(from, to);
    }
}
