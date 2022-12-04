package lotto;

import java.util.ArrayList;
import java.util.List;

public class GameRunner {
    private static final int PRICE_OF_LOTTO = 1000;

    private List<Lotto> lottos = new ArrayList<>();
    private Lotto winningNumbers;
    private int purchaseAmount;
    private int numberOfLottos;

    public void run() {
        setPurchaseAmount();
        generateLottos();
        printLottos();
        // TODO: Guide winningNumber input and get
        // TODO: Guide bonusNumber input and get
        // TODO: Print statistics
        // TODO: Print earningRates
    }

    private void setPurchaseAmount() {
        OutputView.guidePurchaseAmountInput();
        this.purchaseAmount = new PurchaseAmount().get();
        this.numberOfLottos = this.purchaseAmount / PRICE_OF_LOTTO;
        OutputView.printPurchasedNumberOfLotto(this.numberOfLottos);
    }

    private void generateLottos() {
        int temp = this.numberOfLottos;
        while (--temp > 0) {
            Lotto lotto = Lotto.generate();
            this.lottos.add(lotto);
        }
    }

    private void printLottos() {
        for (Lotto lotto : lottos) lotto.print();
    }
}
