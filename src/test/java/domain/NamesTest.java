package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NamesTest {

    @DisplayName("사용자 입력을 받아 이름 목록을 생성합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,cars3", "car4,car5,car6"})
    void createWithValidInput(String input) {
        Names names = new Names(input);

        assertThat(names.getNames().size()).isEqualTo(3);
    }
}
