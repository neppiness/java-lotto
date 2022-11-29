package lotto;

import java.util.EnumMap;
import java.util.List;

public class Application {

    enum Places {
        NONE(0, 2),
        FIFTH(5_000, 3),
        FOURTH(50_000, 4),
        THIRD(1_500_000, 5),
        SECOND(30_000_000, 5),
        FIRST(2_000_000_000, 6);

        public long prize;
        public int matchingNumbers;
        Places(long prize, int matchingNumbers) {
            this.prize = prize;
            this.matchingNumbers = matchingNumbers;
        }
    }

    private static final int LottoPrice = 1000;

    private static EnumMap<Places, Integer> numberOfWinningLottoInPlaces = new EnumMap<>(Places.class);

    public static void main(String[] args) {
        try {
            long purchaseAmount = new Purchase().amount;
            long numberOfLotto = purchaseAmount / LottoPrice;
            List<List<Integer>> generatedLotto = new Generator().generateLotto(numberOfLotto);
            new OutputView().printLotto(generatedLotto);
            List<Integer> lottoInput = new LottoInput().getLottoInput();
            int bonusNumber = new BonusNumber().getBonusNumber();
            Lotto lotto = new Lotto(lottoInput);
            numberOfWinningLottoInPlaces = lotto.compareResult(generatedLotto, bonusNumber);
            new OutputView().printResult(numberOfWinningLottoInPlaces);
            new OutputView().printEarningRates(numberOfWinningLottoInPlaces, purchaseAmount);
        } catch (IllegalArgumentException e) {
            new OutputView().printMessage(e.getMessage());
        }
    }
}
