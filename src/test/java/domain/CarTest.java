package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    public static final String CAR_NAME = "car1";
    public static final int START_POSITION = 0;
    private Name name;
    private Position position;

    @BeforeEach
    void setUp() {
        name = new Name(CAR_NAME);
        position = new Position(START_POSITION);
    }

    @Test
    void move() {
        // given
        Car car = new Car(name, position);

        // when
        Car move = car.move();

        // then
        assertThat(move).isNotNull();
    }
}
