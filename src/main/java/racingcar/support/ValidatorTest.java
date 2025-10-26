package racingcar.support;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;
import java.util.List;


public class ValidatorTest {
    @Test
    void 이름_파싱_공백_허용_앞뒤_트림(){
        List<String> names = Validator.parseAndValidateNames("pobi, woni,jun");
        assertThat(names).containsExactly("pobi", "woni", "jun");
    }
    @Test
    void 시도횟수_0_이면_예외() {
        assertThatThrownBy(() -> Validator.parseAndValidateAttempts("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 시도횟수_음수_또는_숫자아님_예외() {
        assertThatThrownBy(() -> Validator.parseAndValidateAttempts("-3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Validator.parseAndValidateAttempts("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
