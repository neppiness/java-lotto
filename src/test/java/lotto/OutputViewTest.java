package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {

    @DisplayName("printLotto 메서드 출력 테스트")
    @Test
    void printLottoTest() {
        assertSimpleTest(() -> {
            OutputView.printLotto(List.of(1, 2, 3, 4, 5, 6));
            assertThat(output()).contains("[1, 2, 3, 4, 5, 6]");
        });
    }

    @DisplayName("printPurchasedNumberOfLotto 메서드 출력 테스트")
    @Test
    void printPurchasedNumberOfLottoTest() {
        assertSimpleTest(() -> {
            OutputView.printPurchasedNumberOfLotto(2_147_483_647);
            assertThat(output()).contains("2147483647개를 구매했습니다.");
        });
    }

    @Override
    public void runMain() {
    }
}
