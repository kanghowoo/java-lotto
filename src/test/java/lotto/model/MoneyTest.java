package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("금액 테스트(0이상 입력)")
    @ParameterizedTest
    @ValueSource(ints = {0, 1000, 3000})
    void 금액_0원이상(int input) {
        assertTrue(new Money(input).amount() >= 0);
    }

    @DisplayName("금액 테스트(음수값 입력)")
    @ParameterizedTest
    @ValueSource(ints = {-1, -1000, -3000})
    void 금액_음수(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Money(input))
                .withMessageMatching("금액은 음수일 수 없습니다.");
    }

}
