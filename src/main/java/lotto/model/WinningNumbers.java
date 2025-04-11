package lotto.model;

import java.util.List;
import java.util.Set;

public class WinningNumbers {

    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(Set<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public LottoResult countMatch(List<Integer> lottoNumbers){
        int count = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)){
                count++;
            }
        }
        return new LottoResult(count, lottoNumbers.contains(bonusNumber));
    }

    private void validateWinningNumbers(Set<Integer> winningNumbers){
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복을 허용하지 않습니다.");
        }

        if (winningNumbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자만 가능합니다.");
        }
    }

    private void validateBonusNumber(int bonusNumber){
        if (winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자만 가능합니다.");
        }
    }

}
