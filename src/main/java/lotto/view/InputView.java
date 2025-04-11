package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class InputView {

    public int moneyInput(){
        String input = readInput(ViewMessage.INPUT_MONEY.getMessage());
        validateCharacter(input);
        int money = Integer.parseInt(input);
        validateUnit(money);
        return money;
    }

    public Set<Integer> winningNumberInput(){
        System.out.println();
        String input = readInput(ViewMessage.INPUT_WINNINGNUMBER.getMessage());
        validateDelimiter(input);
        String[] split = input.split(",", -1);
        Set<Integer> winningNumber = new HashSet<>();
        for (String s : split) {
            winningNumber.add(Integer.parseInt(s));
        }
        return winningNumber;
    }

    public int bonusNumberInput(){
        System.out.println();
        String input = readInput(ViewMessage.INPUT_BONUSNUMBER.getMessage());
        validateCharacter(input);
        return Integer.parseInt(input);
    }

    private void validateDelimiter(String input) {
        // 쉼표(,)로 나누었을 때, 쉼표 이외의 문자가 포함되어 있으면 예외 처리
        if (!input.replaceAll(" ","").matches("[0-9,]+")) {
            throw new IllegalArgumentException("[ERROR] 구분자는 쉼표(,)만 가능합니다.");
        }
    }

    private void validateUnit(int money) {
        if (money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위어야 합니다.");
        }
    }

    private void validateCharacter(final String input) {
        if (!hasOnlyDigits(input)) {
            throw new IllegalArgumentException("[ERROR] 입력은 숫자만 입력해 주세요.");
        }
    }

    private boolean hasOnlyDigits(final String input) {
        return input.chars()
                .allMatch(Character::isDigit);
    }

    private String readInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }
}
