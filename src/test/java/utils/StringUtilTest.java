package utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilTest {

    @ParameterizedTest
    @NullAndEmptySource
    void isBlank(String input) {
        assertThat(StringUtil.isBlank(input)).isTrue();
    }

    @Test
    void splitText() {
        String input = "car1,car2,car3";
        assertThat(StringUtil.splitText(input)).containsExactly("car1", "car2", "car3");
    }
}
