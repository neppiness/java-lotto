package lotto;

import java.util.List;

public class OutputView {

    public static class printResult {

        public static void fifthPlace(int numberOfLottoAtPlaces) {
            print(String.format("3개 일치 (5,000원) - %d개", numberOfLottoAtPlaces));
        }
        public static void fourthPlace(int numberOfLottoAtPlaces) {
            print(String.format("4개 일치 (50,000원) - %d개", numberOfLottoAtPlaces));
        }
        public static void thirdPlace(int numberOfLottoAtPlaces) {
            print(String.format("5개 일치 (1,500,000원) - %d개", numberOfLottoAtPlaces));
        }
        public static void secondPlace(int numberOfLottoAtPlaces) {
            print(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", numberOfLottoAtPlaces));
        }
        public static void firstPlace(int numberOfLottoAtPlaces) {
            print(String.format("6개 일치 (2,000,000,000원) - %d개", numberOfLottoAtPlaces));
        }
    }

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

    public static void printEarningRates(int purchaseAmount, long totalPrize) {
        print(String.format("총 수익률은 %.1f%%입니다.", (double)totalPrize / purchaseAmount));
    }

    private static void print(String output) {
        System.out.println(output);
    }
}
