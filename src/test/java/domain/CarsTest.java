package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {
    public static final String CAR1_NAME = "car1";
    public static final String CAR2_NAME = "car2";

    private Name name1;
    private Name name2;
    private Position position;

    @BeforeEach
    void setUp() {
        name1 = new Name(CAR1_NAME);
        name2 = new Name(CAR2_NAME);
        position = new Position(0);
    }

    @Test
    void create() {
        Car car1 = new Car(name1, position);
        Car car2 = new Car(name2, position);
        List<Car> cars = Arrays.asList(car1, car2);

        assertThat(new Cars(cars)).isNotNull();
    }
}
