package lotto;

import java.util.EnumMap;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public EnumMap<Application.Places, Integer> compareResult(List<List<Integer>> generatedLotto, int bonusNumber) {
        EnumMap<Application.Places, Integer> result = new EnumMap<>(Application.Places.class);
        for (Application.Places place: Application.Places.values())
            result.put(place, 0);
        for (List<Integer> generated : generatedLotto) {
            int numberOfWinningNumber = 0;
            boolean hasBonusNumber = false;
            for (int number : generated) {
                if(this.numbers.contains(number)) numberOfWinningNumber++;
                if(number == bonusNumber) hasBonusNumber = true;
            }
            Application.Places place = getPlace(numberOfWinningNumber, hasBonusNumber);
            int numberOfThePlace = result.get(place);
            result.put(place, numberOfThePlace + 1);
        }
        return result;
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
        final int upperLimit = 45;
        boolean[] isUsed = new boolean[upperLimit + 1];
        for (int number : numbers) {
            if (isUsed[number])
                throw new IllegalArgumentException();
            isUsed[number] = true;
        }
    }

    private void ifOutOfRange(List<Integer> numbers) {
        final int upperLimit = 45, lowerLimit = 1;
        for (int number : numbers) {
            if (number >= lowerLimit && number <= upperLimit) continue;
            throw new IllegalArgumentException();
        }
    }

    private Application.Places getPlace(int numberOfWinningNumber, boolean hasBonusNumber) {
        if(numberOfWinningNumber < 3) return Application.Places.NONE;
        if(numberOfWinningNumber == 3) return Application.Places.FIFTH;
        if(numberOfWinningNumber == 4) return Application.Places.FOURTH;
        if(numberOfWinningNumber == 6) return Application.Places.FIRST;
        if(hasBonusNumber) return Application.Places.SECOND;
        return Application.Places.THIRD;
    }
}
