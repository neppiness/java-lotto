package lotto;

import java.util.List;

public class Lotto {

    private static final int upperLimit = 45;
    private static final int lowerLimit = 1;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void compare(List<Integer> generatedNumbers) {
        // TODO: 당첨 번호와 생성된 번호 비교 후 순위를 enum의 형태로 반환
    }

    private void validate(List<Integer> numbers) {
        hasSixNumbers(numbers.size());
        ifDuplicated(numbers);
        ifOutOfRange(numbers);
    }

    private void hasSixNumbers(int sizeOfList) {
        if (sizeOfList == 6) return;
        throw new IllegalArgumentException();
    }

    private void ifDuplicated(List<Integer> numbers) {
        boolean[] isUsed = new boolean[upperLimit + 1];
        for (int number : numbers) {
            if (isUsed[number])
                throw new IllegalArgumentException();
            isUsed[number] = true;
        }
    }

    private void ifOutOfRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number >= lowerLimit && number <= upperLimit) continue;
            throw new IllegalArgumentException();
        }
    }
}
