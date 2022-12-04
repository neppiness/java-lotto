package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseAmountTest extends NsTest {
    @DisplayName("구매 금액 정상 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2147483000", "1000", "381000"})
    void getMethodTest(String acceptableInput) {
        run(acceptableInput);
    }

    @DisplayName("입력 문자열이 정수가 아닌 경우 예외 처리함")
    @ParameterizedTest
    @ValueSource(strings = {"*", "NEPPINESS", "KJH0414", "&#*#(@$", "1000.1"})
    void NonIntegerInputTest(String nonIntegerInput) {
        assertThatThrownBy(() -> {
            run(nonIntegerInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("int형 변수의 최댓값을 넘으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"2147484000", "-2147484000"})
    void exceedIntegerLimitTest(String inputOutOfIntRange) {
        assertThatThrownBy(() -> {
            run(inputOutOfIntRange);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0 이하의 값을 입력 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000", "-2135000"})
    void zeroInputTest(String inputLessThanOne) {
        assertThatThrownBy(() -> {
            run(inputLessThanOne);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000의 배수가 아닌 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1111", "1110", "1100", "2673"})
    void unitOf1000Test(String inputNotUnitOf1000) {
        assertThatThrownBy(() -> {
            run(inputNotUnitOf1000);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        new PurchaseAmount().get();
    }
}
