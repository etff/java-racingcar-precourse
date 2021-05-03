package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarsTest {
    public static final String CAR1_NAME = "car1";
    public static final String CAR2_NAME = "car2";

    private Name name1;
    private Name name2;

    @BeforeEach
    void setUp() {
        name1 = new Name(CAR1_NAME);
        name2 = new Name(CAR2_NAME);
    }

    @Test
    void create() {
        Car car1 = new Car(name1, 0);
        Car car2 = new Car(name2, 0);
        List<Car> cars = Arrays.asList(car1, car2);

        assertThat(new Cars(cars)).isNotNull();
    }

    @DisplayName("사용자 입력으로 자동차 목록을 생성합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"car1,car2, cars3", "car4,car5,car6"})
    void createWithValidInput(String input) {
        Cars cars = new Cars(input);

        assertThat(cars.getCars().size()).isEqualTo(3);
    }
}
