package lotto;

import java.util.EnumMap;
import java.util.List;

public class OutputView {

    public void printMessage(String message) { System.out.println(message); }

    public void printLotto(List<List<Integer>> generatedLotto) {
        printMessage(String.format("%d개를 구매했습니다.", generatedLotto.size()));
        for (List<Integer> lotto : generatedLotto) {
            System.out.println(lotto);
        }
    }

    public void printResult(EnumMap<Application.Places, Integer> numberOfWinningLottoInPlaces) {
        for (Application.Places place : Application.Places.values()) {
            if(place == Application.Places.NONE) continue;
            printResultForPlaces(place, numberOfWinningLottoInPlaces.get(place));
        }
    }

    public void printEarningRates(
            EnumMap<Application.Places, Integer> numberOfWinningLottoInPlaces, long purchaseAmount
    ) {
        long winningPrize = 0;
        for (Application.Places place : Application.Places.values())
            winningPrize += place.prize * numberOfWinningLottoInPlaces.get(place);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", winningPrize / (double)(purchaseAmount)*100);
    }

    private void printResultForPlaces(Application.Places place, int numberOfWinningLottoInPlace) {
        if (place == Application.Places.SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n",
                    place.matchingNumbers, place.prize, numberOfWinningLottoInPlace);
            return;
        }
        System.out.printf("%d개 일치 (%,d원) - %d개\n",
                place.matchingNumbers, place.prize, numberOfWinningLottoInPlace);
    }


}
