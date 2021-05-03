package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarTest {
    public static final String CAR_NAME = "car1";

    private Name name;

    @BeforeEach
    void setUp() {
        name = new Name(CAR_NAME);
    }

    @DisplayName("0보다 작은 위치를 입력할 경우 예외를 이 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, -10})
    void carPosition(int position) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(name, position));
    }

    @Test
    void move() {
        // given
        Car car = new Car(name, 0);

        // when
        Car move = car.move();

        // then
        assertThat(move).isNotNull();
    }
}
