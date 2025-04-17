package lotto.model;

import java.util.List;

public class WinningNumbers {

    private final Lotto lottoNumber;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> lottoNumber, int bonusNumber) {
        this.lottoNumber = new Lotto(lottoNumber);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public LottoResult countMatch(List<Integer> lottoNumbers){
        int count = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (this.lottoNumber.isContainLottoNumber(lottoNumber)){
                count++;
            }
        }
        return new LottoResult(count, lottoNumbers.contains(bonusNumber));
    }

    private void validateBonusNumber(int bonusNumber){
        if (lottoNumber.isContainLottoNumber(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 당첨 번호와 중복될 수 없습니다.");
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자만 가능합니다.");
        }
    }

}
