package domain;

import java.util.concurrent.ThreadLocalRandom;

public class MoveStrategy {
    public static final int CAN_MOVE_RANGE = 4;
    public static final int MAX_MOVE_RANGE = 9;
    public static final int MAX_GENERATE_NUMBER = 10;

    public boolean canMove(int randomNumber) {
        return CAN_MOVE_RANGE <= randomNumber && randomNumber <= MAX_MOVE_RANGE;
    }

    public int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(MAX_GENERATE_NUMBER);
    }
}
