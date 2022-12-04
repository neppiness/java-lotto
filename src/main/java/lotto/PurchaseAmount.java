package lotto;

public class PurchaseAmount {

    private int purchaseAmount;
    private static final int UNIT = 1000;

    public int get() {
        String input = InputView.readLine();
        this.purchaseAmount = Integer.parseInt(input);
        validate();
        return this.purchaseAmount;
    }

    private void validate() {
        checkIsLargerThanZero();
        checkIsIn1000Unit();
    }

    private void checkIsLargerThanZero() {
        if (this.purchaseAmount <= 0)
            throw new IllegalArgumentException("구매 금액은 0 이하일 수 없습니다.");
    }

    private void checkIsIn1000Unit() {
        if (this.purchaseAmount % UNIT != 0)
            throw new IllegalArgumentException("구매 금액을 1000원 단위로 입력해 주세요.");
    }
}
