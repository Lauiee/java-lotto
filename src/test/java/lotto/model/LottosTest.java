package lotto.model;

import java.util.Arrays;
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
        System.out.println("------getLottos로 가져온 lottos의 주소------");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }

        // then
        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(5);
    }


}