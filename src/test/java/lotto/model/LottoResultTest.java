package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("로또 번호와 당첨 번호의 일치 개수와 보너스 번호의 일치 여부를 적용한 일치 개수를 반환합니다")
    @Test
    void 로또_번호_일치_개수_보너스_번호_포함(){
        // given
        LottoResult lottoResult1 = new LottoResult(3, true);
        LottoResult lottoResult2 = new LottoResult(3, false);

        // when
        int result1 = lottoResult1.countResultWithBonusMatch();
        int result2 = lottoResult2.countResultWithBonusMatch();

        // then
        Assertions.assertThat(result1).isEqualTo(4);
        Assertions.assertThat(result2).isEqualTo(3);
    }

    @DisplayName("만약 일치 개수가 5개이고, 보너스 번호가 일치하면 7을 반환합니다.")
    @Test
    void 로또_번호_일치_개수_5개_보너스_번호_일치(){
        // given
        LottoResult lottoResult = new LottoResult(5, true);

        // when
        int result = lottoResult.countResultWithBonusMatch();

        // then
        Assertions.assertThat(result).isEqualTo(7);
    }



}