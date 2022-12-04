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

    public static void guideWinningNumbersInput() {
        print("당첨 번호를 입력해 주세요.");
        print("중복없는 1 이상 45 이하의 자연수 6개를 쉼표로 구분해 입력해야 합니다.");
    }

    public static void guideBonusNumberInput() {
        print("보너스 번호를 입력해 주세요.");
        print("당첨 번호와 중복되지 않는 1 이상 45 이하의 자연수 1개를 입력해야 합니다.");
    }

    private static void print(String output) {
        System.out.println(output);
    }
}
