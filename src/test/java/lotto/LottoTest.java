package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 이상 45 이하의 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void createLottoByNumberOutOfValidRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 정상 생성 테스트")
    @Test
    void createCorrectLottoNumber() {
        for (int number = 1; number <= 40; number++) {
            List<Integer> lottoNumbers
                    = List.of(number, number + 1, number + 2,
                            number + 3, number + 4, number + 5);
            new Lotto(lottoNumbers);
        }
    }

    @DisplayName("1 이상 45 이하 자연수가 아닌 보너스 번호는 예외 처리")
    @ParameterizedTest(name = "{index}번 테스트: {0}는 보너스 번호 범위를 벗어남")
    @ValueSource(ints = {-10, -8, -7, -1, 0, 46, 47, 48, 49})
    void checkBonusNumberOutOfRange(int bonusNumber) {
        assertThatThrownBy(() -> {
            Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            winningNumbers.validateBonusNumber(bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 중복되는 경우 예외 처리")
    @ParameterizedTest(name = "{index}번 테스트: {0}는 당첨 번호와 중복됨")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void checkBonusNumberDuplicatedWithWinningNumbers(int bonusNumber) {
        assertThatThrownBy(() -> {
            Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            winningNumbers.validateBonusNumber(bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 정상 입력 테스트")
    @Test
    void createCorrectBonusNumber() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        for (int bonusNumber = 7; bonusNumber <= 45; bonusNumber++)
            winningNumbers.validateBonusNumber(bonusNumber);
    }
}
