package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.lottoNumbers = numbers.stream().map(LottoNumber::new).toList();
    }


    public List<Integer> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers.stream().map(LottoNumber::getLottoNumber).toList());
    }

    public boolean isContainLottoNumber(Integer lottoNumber){
        return this.lottoNumbers.contains(lottoNumber);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복을 허용하지 않습니다.");
        }
    }
}
