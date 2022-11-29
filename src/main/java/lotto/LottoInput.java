package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoInput {

    String lineInput;

    public LottoInput() {
        new OutputView().printMessage("당첨 번호를 입력해 주세요.");
        this.lineInput = new InputView().getLineInput();
        validate();
    }

    public List<Integer> getLottoInput() {
        List<Integer> lottoInput = new ArrayList<>();
        String[] separatedInput = lineInput.split(",");
        for (String numberInString : separatedInput) {
            int number = Integer.parseInt(numberInString);
            lottoInput.add(number);
        }
        Collections.sort(lottoInput);
        return lottoInput;
    }

    private void validate() {
        hasOnlyCommasAndNumbers();
    }

    private boolean isComma(char charAtIndex) { return charAtIndex == ','; }
    private boolean isNumber(char charAtIndex) { return (charAtIndex >= '0' && charAtIndex <= '9'); }

    private void hasOnlyCommasAndNumbers() {
        for (int index = 0; index < lineInput.length(); index++) {
            char charAtIndex = this.lineInput.charAt(index);
            if (!isComma(charAtIndex) && !isNumber(charAtIndex))
                throw new IllegalArgumentException();
        }
    }


}
