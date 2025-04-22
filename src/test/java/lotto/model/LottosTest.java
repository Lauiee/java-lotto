package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottosTest {

    @DisplayName("Lottos를 생성합니다. 생성을 위해선 로또 구입 금액만을 넘겨주면 됩니다.")
    @ParameterizedTest
    @ValueSource(ints = {3000, 50000, 20000, 8000})
    void Lottos_생성_테스트(int amount){

        // when
        Lottos lottos = Lottos.from(amount);

        // then
        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(amount/1000);
    }

    @DisplayName("로또 당첨 결과를 추출합니다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 8000, 20000})
    void 로또_당첨_결과_추출(int amount){
        // given
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1,2,3,4,5,6)), 7);
        Lottos lottos = Lottos.from(amount);

        // when
        LottoResults lottoResults = lottos.winningResult(winningNumbers);

        // then
        Assertions.assertThat(lottoResults.getLottoResults().size()).isEqualTo(amount/1000);
    }
}