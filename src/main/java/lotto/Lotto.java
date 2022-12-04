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

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
