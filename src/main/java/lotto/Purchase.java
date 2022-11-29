package lotto;

public class Purchase {

    public long amount;

    public Purchase() {
        String lineInput = new InputView().getLineInput();
        try {
            validate(lineInput);
        } catch(IllegalArgumentException e) {
            new OutputView().printMessage(e.getMessage());
            throw new IllegalArgumentException();
        }
        this.amount = Integer.parseInt(lineInput);
    }

    private void validate(String lineInput) {
        isInputNumber(lineInput);
        isInputInUnitOf1000(lineInput);
    }

    private void isInputNumber(String input) {
        for(int index = 0; index < input.length(); index++) {
            char charAtIndex = input.charAt(index);
            if(charAtIndex <= '9' && charAtIndex >= '0') continue;
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    };

    private void isInputInUnitOf1000(String input) {
        int inputNumber = Integer.parseInt(input);
        if(inputNumber % 1000 == 0) return;
        throw new IllegalArgumentException("[ERROR] 1000 단위의 숫자를 금액으로 입력해주세요.");
    }
}
