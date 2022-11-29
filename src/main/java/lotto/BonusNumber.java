package lotto;

public class BonusNumber {

    String lineInput;

    public BonusNumber() {
        new OutputView().printMessage("보너스 번호를 입력해 주세요.");
        this.lineInput = new InputView().getLineInput();
        validate();
    }

    public int getBonusNumber() { return Integer.parseInt(this.lineInput); }

    private void validate() {
        hasOnlyNumbers();
        ifOutOfRange();
    }

    private void ifOutOfRange() {
        int bonusNumber = Integer.parseInt(this.lineInput);
        final int upperLimit = 45, lowerLimit = 1;
        if (bonusNumber >= lowerLimit && bonusNumber <= upperLimit) return;
        throw new IllegalArgumentException();
    }

    private boolean isNumber(char charAtIndex) { return (charAtIndex >= '0' && charAtIndex <= '9'); }

    private void hasOnlyNumbers() {
        for (int index = 0; index < this.lineInput.length(); index++) {
            char charAtIndex = this.lineInput.charAt(index);
            if (!isNumber(charAtIndex))
                throw new IllegalArgumentException();
        }
    }
}
