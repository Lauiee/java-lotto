package lotto.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResults {

    public static final long LOTTO_PRICE = 1000L;
    private final List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public List<LottoResult> getLottoResults() {
        // 깊은 복사를 통해 참조 넘기지 않도록 구현
        return lottoResults.stream()
                .map(lottoResult -> new LottoResult(lottoResult.getWinningCount(), lottoResult.isBonusMatch()))
                .toList();
    }

    public BigDecimal lottoReturnRate(){
        BigDecimal ratio = BigDecimal.valueOf(lottoResultMoney())
                .divide(BigDecimal.valueOf(lottoResults.size()*LOTTO_PRICE))
                .multiply(BigDecimal.valueOf(100))
                .stripTrailingZeros(); // 뒤에 불필요한 0 제거
        return new BigDecimal(ratio.toPlainString()); // 일반 숫자 형식으로 변환
    }

    public Map<Integer, Integer> eachMatchedResult() {
        Map<Integer, Integer> matchedMap = new HashMap<>();

        for (LottoResult lottoResult : lottoResults) {
            int matchResult = lottoResult.countResultWithBonusMatch();
            if (matchResult >= 3){
                matchedMap.merge(lottoResult.countResultWithBonusMatch(),1,Integer::sum);
            }
        }

        return matchedMap;
    }

    private int lottoResultMoney(){
        int moneyResult = 0;
        for (LottoResult lottoResult : lottoResults) {
            moneyResult += lottoResult.getLottoPrize();
        }
        return moneyResult;
    }

}
