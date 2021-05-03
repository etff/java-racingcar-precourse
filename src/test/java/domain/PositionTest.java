package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PositionTest {

    @DisplayName("0보다 작은 위치를 입력할 경우 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -10})
    void positionWithInValidInput(int position) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Position(position));
    }

    @DisplayName("유효한 범위의 위치를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 5, 9})
    void positionWithValidInput(int position) {
        new Position(position);
    }

    @DisplayName("위치를 비교해 최대값을 리턴한다.")
    @ParameterizedTest
    @CsvSource({"3, 5, 5", "5, 3, 5"})
    void getMaxPosition(int originNumber, int compareNumber, int result) {
        Position position = new Position(originNumber);

        int maxPosition = position.getMaxPosition(compareNumber);

        assertThat(maxPosition).isEqualTo(result);
    }
}
