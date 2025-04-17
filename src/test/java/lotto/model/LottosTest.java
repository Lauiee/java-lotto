package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("Lottos를 생성합니다. 생성을 위해선 로또 구입 금액만을 넘겨주면 됩니다.")
    @Test
    void Lottos_생성_테스트(){
        // given
        int price = 5000;

        // when
        Lottos lottos = Lottos.from(price);

        // then
        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(5);
    }

    @DisplayName("로또 당첨 결과를 추출합니다.")
    @Test
    void 로또_당첨_결과_추출(){
        // given
        int price = 8000;
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1,2,3,4,5,6)), 7);
        Lottos lottos = Lottos.from(8000);

        // when
        LottoResults lottoResults = lottos.winningResult(winningNumbers);

        // then
        Assertions.assertThat(lottoResults.getLottoResults().size()).isEqualTo(8);
    }
}