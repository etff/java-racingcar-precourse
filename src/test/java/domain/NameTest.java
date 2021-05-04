package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NameTest {

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 예외를 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void nameEmpty(final String textInput) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Name(textInput));
    }

    @DisplayName(value = "이름을 5글자 이내로 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"aa", "bbb", "ccccc"})
    void nameWithValidInput(final String textInput) {
        assertThat(new Name(textInput)).isNotNull();
    }

    @DisplayName(value = "이름은 5자를 넘으면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"aaabbb", "bbbcccc", "ddddeeee"})
    void nameWithInValidInput(final String textInput) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Name(textInput));
    }
}
