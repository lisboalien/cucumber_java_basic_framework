package archetypes.classes;

import java.util.Random;

/**
 * Created by lisboalien on 14/08/2017.
 * Class that contains all the random data generator needed in your test based on the system you are testing
 */
public class RandomDataGenerator {
    private static Random rand;

    /**
     * Method that generates a random int based on min and max parameters
     *
     * @param min (The min value of the random int)
     * @param max (The max value of the random int)
     * @return (The random int generated)
     */
    public static int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
}
