package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MoveStrategyTest {
    private MoveStrategy moveStrategy;

    @BeforeEach
    void setUp() {
        moveStrategy = new MoveStrategy();
    }

    @DisplayName("생성된 숫자가 4이상이면 움직일 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 8})
    void moveWithValidNumber(int randomNumber) {
        assertThat(moveStrategy.canMove(randomNumber)).isTrue();
    }

    @DisplayName("생성된 숫자가 4이하이면 움직일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void moveWithInValidNumber(int randomNumber) {
        assertThat(moveStrategy.canMove(randomNumber)).isFalse();
    }

    @DisplayName("생성된 숫자가 9이상이면 움직일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {10, 20})
    void moveWithMaxNumber(int randomNumber) {
        assertThat(moveStrategy.canMove(randomNumber)).isFalse();
    }
}
