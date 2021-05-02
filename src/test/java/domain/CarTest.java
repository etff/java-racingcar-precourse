package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarTest {
    public static final String CAR_NAME = "car1";

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 예외를 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void carNameEmpty(final String textInput) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(textInput, 0));
    }

    @DisplayName("0보다 작은 위치를 입력할 경우 예외를 이 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, -10})
    void carPosition(int position) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(CAR_NAME, position));
    }

    @Test
    void move() {
        // given
        Car car = new Car(CAR_NAME, 0);

        // when
        Car move = car.move();

        // then
        assertThat(move).isNotNull();
    }
}
