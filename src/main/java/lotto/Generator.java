package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Generator {

    public List<List<Integer>> generateLotto(long numberOfLotto) {
        List<List<Integer>> generatedLotto = new ArrayList<>();
        for (long numberOfGeneration = 1; numberOfGeneration <= numberOfLotto; numberOfGeneration++)
            generatedLotto.add(generateRandomSixNumber());
        return generatedLotto;
    }

    private List<Integer> generateRandomSixNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
