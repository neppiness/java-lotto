package lotto;

import java.util.List;

public class OutputView {

    public static void guidePurchaseAmountInput() {
        print("구입금액을 입력해 주세요.");
    }

    public static void printPurchasedNumberOfLotto(int numberOfLottos) {
        print(String.format("%d개를 구매했습니다.", numberOfLottos));
    }

    public static void printLotto(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    private static void print(String output) {
        System.out.println(output);
    }
}
