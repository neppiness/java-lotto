package lotto;

import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto generate() {
        List<Integer> generatedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(generatedNumbers);
        return new Lotto(generatedNumbers);
    }

    public void print() { OutputView.printLotto(this.numbers); }

    public void validateBonusNumber(int bonusNumber) {
        checkNumberRange(bonusNumber);
        checkIfDuplicatedWithWinningNumbers(bonusNumber);
    }

    private void validate(List<Integer> numbers) {
        hasSixNumber(numbers);
        isNumbersInValidRange(numbers);
        hasNoDuplicatedNumber(numbers);
    }

    private void hasSixNumber(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException("당첨 번호는 숫자 6개로 구성해야 합니다.");
    }

    private void isNumbersInValidRange(List<Integer> numbers) {
        for (int number : numbers)
            checkNumberRange(number);
    }

    private void hasNoDuplicatedNumber(List<Integer> numbers) {
        boolean[] isUsed = new boolean[46];
        for (int number : numbers) {
            if (isUsed[number])
                throw new IllegalArgumentException("중복된 숫자는 당첨 번호로 사용할 수 없습니다.");
            isUsed[number] = true;
        }
    }

    private void checkNumberRange(int number) {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException("1 이상 45 이하의 숫자를 입력해 주세요.");
    }

    private void checkIfDuplicatedWithWinningNumbers(int bonusNumber) {
        if (this.numbers.contains(bonusNumber))
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}
