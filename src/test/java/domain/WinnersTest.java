package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinnersTest {
    public static final String CAR1_NAME = "car1";
    public static final String CAR2_NAME = "car2";
    public static final String CAR3_NAME = "car3";

    public static final int CAR1_POSITION = 4;
    public static final int CAR2_POSITION = 2;
    public static final int CAR3_POSITION = 3;

    private Name name1;
    private Name name2;
    private Name name3;

    private Position position1;
    private Position position2;
    private Position position3;

    @BeforeEach
    void setUp() {
        name1 = new Name(CAR1_NAME);
        name2 = new Name(CAR2_NAME);
        name3 = new Name(CAR3_NAME);

        position1 = new Position(CAR1_POSITION);
        position2 = new Position(CAR2_POSITION);
        position3 = new Position(CAR3_POSITION);
    }

    @DisplayName("우승자를 구할 수 있다.")
    @Test
    void findWinner() {
        Car car1 = new Car(name1, position1);
        Car car2 = new Car(name2, position2);
        Car car3 = new Car(name3, position3);

        Winners winners = new Winners();
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        Cars winnerCars = winners.findWinners(cars);

        assertThat(winnerCars.getCars().size()).isEqualTo(1);
        assertThat(winnerCars.getCars().contains(car1)).isTrue();
    }
}
