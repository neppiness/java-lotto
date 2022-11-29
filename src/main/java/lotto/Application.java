package lotto;

import java.util.List;

public class Application {

    private static final int LottoPrice = 1000;

    public static void main(String[] args) {
        long purchaseAmount = new Purchase().amount;
        long numberOfLotto = purchaseAmount / LottoPrice;
        List<List<Integer>> generatedLotto = new Generator().generateLotto(numberOfLotto);
        new OutputView().printLotto(generatedLotto);
        // Lotto에서 generate해서 OutputView로 전달
        // 구매한 로또 수만큼 로또 목록 생성
        // 당첨번호 입력 (InputView) 클래스를 통함
        // InputView에서 로또 숫자 전달받음
        // InputView에서 보너스 숫자 기록
        // 보너스 숫자 및 로또 숫자 기록(Enum 사용, first, second, third, ...)
        // OutputView를 통한 당첨 통계 출력
        // 총 수익률 출력(둘째자리에서 반올림)
    }
}
