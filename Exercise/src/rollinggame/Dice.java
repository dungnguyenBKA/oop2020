package rollinggame;

import java.util.Random;

public class Dice {
    public int getDiceResult() {
        int ran = new Random().nextInt(100);
        if (ran < 16) {
            return 1;
        } else if (ran < 32) {
            return 2;
        } else if (ran < 48) {
            return 3;
        } else if (ran < 64) {
            return 4;
        } else if (ran < 80) {
            return 5;
        }
        return 6;
    }
}
