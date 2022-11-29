package lotto;

import java.util.List;

public class OutputView {

    public void printMessage(String message) { System.out.println(message); }

    public void printLotto(List<List<Integer>> generatedLotto) {
        printMessage(String.format("%d개를 구매했습니다.", generatedLotto.size()));
        for (List<Integer> lotto : generatedLotto) {
            System.out.println(lotto);
        }
    }
}
