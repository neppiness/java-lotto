package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    public static List<Integer> get() {
        String input = InputView.readLine();
        String[] splitInput = input.split(",");
        List<Integer> inputNumbers = new ArrayList<>();
        for (String numberInString : splitInput) {
            int number = Integer.parseInt(numberInString);
            inputNumbers.add(number);
        }
        return inputNumbers;
    }
}
