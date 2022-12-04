package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class Result {

    enum Place {
        FIRST(6, false, 2_000_000_000),
        SECOND(5, true, 30_000_000),
        THIRD(5, false, 1_500_000),
        FOURTH(4, false, 50_000),
        FIFTH(3, false, 5_000),
        NONE(0, false, 0);

        int numberOfMatchedNumbers;
        boolean hasBonusNumber;
        int prize;

        Place(int numberOfMatchedNumbers, boolean hasBonusNumber, int prize) {
            this.numberOfMatchedNumbers = numberOfMatchedNumbers;
            this.hasBonusNumber = hasBonusNumber;
            this.prize = prize;
        }
    }
}
