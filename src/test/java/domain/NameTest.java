package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NameTest {

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 예외를 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void nameEmpty(final String textInput) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Name(textInput));
    }
}
