package lotto.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

    @DisplayName("당첨 결과를 위해 Map에 일치 번호 개수를 Key로 하여 통계를 구합니다.(단, 3개 이상부터 Map에 담깁니다)")
    @Test
    void 당첨_결과_통계(){
        // given
        LottoResults lottoResults = new LottoResults(
                List.of(
                        new LottoResult(5,true),
                        new LottoResult(3,true),
                        new LottoResult(3,true),
                        new LottoResult(2,false),
                        new LottoResult(6,false)
                )
        );

        // when
        Map<MatchPrize, Integer> resultMap = lottoResults.eachMatchedResult();

        // then
        Assertions.assertThat(resultMap.size()).isEqualTo(4);
    }

    @DisplayName("로또 구매 금액과, 당첨 금액을 토대로 수익률을 계산합니다")
    @Test
    void 수익률_계산(){
        // 8000원으로 로또 구매 -> 1개만 3개 일치 당첨 -> 수익률 62.5%
        // given
        LottoResults lottoResults = new LottoResults(
                List.of(
                        new LottoResult(1,true),
                        new LottoResult(1,false),
                        new LottoResult(1,false),
                        new LottoResult(1,true),
                        new LottoResult(3,false),
                        new LottoResult(0,true),
                        new LottoResult(2,false),
                        new LottoResult(0,false)
                )
        );

        // when
        BigDecimal returnRate = lottoResults.lottoReturnRate();

        // then
        Assertions.assertThat(returnRate).isEqualTo(new BigDecimal("62.5"));
    }
}