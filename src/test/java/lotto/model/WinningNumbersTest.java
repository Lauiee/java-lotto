package lotto.model;

import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName("로또 번호와 당첨 번호의 일치하는 번호의 개수를 체크해 LottoResult를 반환합니다")
    @Test
    void 로또_번호_일치_개수_확인(){
        // given
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1,2,3,4,5,6)), 7);

        // when
        LottoResult lottoResult = winningNumbers.countMatch(List.of(1, 2, 3, 8, 9, 10));

        // then
        Assertions.assertThat(lottoResult.getWinningCount()).isEqualTo(3);
        Assertions.assertThat(lottoResult.isBonusMatch()).isEqualTo(false);
    }

    @DisplayName("당첨 번호 중 중복 값이 있다면 예외가 발생합니다.")
    @Test
    void 당첨_번호_중복(){
        Assertions.assertThatThrownBy(() -> new WinningNumbers(new Lotto(List.of(1,2,3,4,4,5)), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 중복을 허용하지 않습니다.");
    }

    @DisplayName("당첨 번호 중 1-45의 범위를 벗어나는 값이 있다면 예외가 발생합니다.")
    @Test
    void 당첨_번호_범위_벗어남(){
        Assertions.assertThatThrownBy(() -> new WinningNumbers(new Lotto(List.of(1,2,3,4,5,46)), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1~45 사이의 숫자만 가능합니다.");
    }

    @DisplayName("보너스 번호는 당첨 번호와 중복되어선 안됩니다.")
    @Test
    void 보너스_번호_중복(){
        Assertions.assertThatThrownBy(() -> new WinningNumbers(new Lotto(List.of(1,2,3,4,5,6)), 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("보너스 번호도 1-45의 범위를 벗어나면 예외가 발생합니다")
    @Test
    void 보너스_번호_범위_벗어남(){
        Assertions.assertThatThrownBy(() -> new WinningNumbers(new Lotto(List.of(1,2,3,4,5,6)), 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1~45 사이의 숫자만 가능합니다.");
    }
}