package lotto;

import java.util.EnumMap;
import java.util.List;

public class Result {

    enum Place {
        FIRST(2_000_000_000),
        SECOND(30_000_000),
        THIRD(1_500_000),
        FOURTH(50_000),
        FIFTH(5_000),
        NONE(0);

        int prize;
        Place(int prize) { this.prize = prize; }
    }

    private final EnumMap<Place, Integer> numberOfLottosAtPlaces = new EnumMap<>(Place.class);
    private List<Lotto> lottos;
    private Lotto winningNumbers;
    private int bonusNumber;

    Result(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void compare() {
        initialize();
        for (Lotto lotto : this.lottos) {
            List<Integer> numberOfWinningNumbersAndBonusNumber = getNumberOfWinningNumbersAndBonusNumber(lotto);
            Place place = checkPlace(numberOfWinningNumbersAndBonusNumber);
            updateResult(place);
        }
    }

    public void print() {
        OutputView.printResult.fifthPlace(numberOfLottosAtPlaces.get(Place.FIFTH));
        OutputView.printResult.fourthPlace(numberOfLottosAtPlaces.get(Place.FOURTH));
        OutputView.printResult.thirdPlace(numberOfLottosAtPlaces.get(Place.THIRD));
        OutputView.printResult.secondPlace(numberOfLottosAtPlaces.get(Place.SECOND));
        OutputView.printResult.firstPlace(numberOfLottosAtPlaces.get(Place.FIRST));
    }

    public void printEarningRates(int numberOfLottos) {
        long totalPrize = 0;
        for (Place place : Place.values())
            totalPrize += (long)numberOfLottosAtPlaces.get(place) * place.prize;
        OutputView.printEarningRates(numberOfLottos * 1000, totalPrize);
    }

    private void updateResult(Place place) {
        int count = numberOfLottosAtPlaces.get(place);
        numberOfLottosAtPlaces.put(place, ++count);
    }

    private List<Integer> getNumberOfWinningNumbersAndBonusNumber(Lotto lotto) {
        return lotto.compare(this.winningNumbers, this.bonusNumber);
    }

    private Place checkPlace(List<Integer> numberOfWinningNumbersAndBonusNumber) {
        int numberOfWinningNumbers = numberOfWinningNumbersAndBonusNumber.get(0);
        boolean hasBonusNumber = (numberOfWinningNumbersAndBonusNumber.get(1) == 1);
        if (numberOfWinningNumbers == 6) return Place.FIRST;
        if (numberOfWinningNumbers == 4) return Place.FOURTH;
        if (numberOfWinningNumbers == 3) return Place.FIFTH;
        if (numberOfWinningNumbers < 3) return Place.NONE;
        if (hasBonusNumber) return Place.SECOND;
        return Place.THIRD;
    }

    private void initialize() {
        for (Place place : Place.values())
            numberOfLottosAtPlaces.put(place, 0);
    }
}
