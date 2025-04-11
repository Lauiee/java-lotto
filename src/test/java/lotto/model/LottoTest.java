package lotto.model;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("숫자 리스트를 넘겨주면 로또가 생성된다.")
    @Test
    void 로또_정상_생성() {
        Lotto newLotto = new Lotto(new ArrayList<>(List.of(6,5,4,3,2,1)));
        Assertions.assertThat(newLotto).isInstanceOf(Lotto.class);
    }

    @DisplayName("생성된 로또는 오름차순으로 정렬됩니다.")
    @Test
    void 로또_오름차순_정렬(){
        // 그냥 List.of()를 사용하고 Lotto를 생성하면 문제 발생
        // 왜? List.of()로 생성된 리스트는 '불변'리스트
        // 그러나 Lotto의 생성자 내에서 Collections.sort()를 이용해 오름차순으로 정렬을 진행함
        // 그렇기 때문에 UnsupportedOperation 예외가 발생한다
        //Lotto newLotto = new Lotto(List.of(6,5,4,3,2,1));

        // 정렬이나 수정 작업을 진행하려면, 가변리스트로 만들어주자
        // 가변 리스트로 변환하기 위해 ArrayList<>()로 감싸주자
        Lotto newLotto = new Lotto(new ArrayList<>(List.of(6,5,4,3,2,1)));


        Assertions.assertThat(newLotto.getNumbers().getFirst()).isEqualTo(1);
        Assertions.assertThat(newLotto.getNumbers().getLast()).isEqualTo(6);
    }

    // 아래의 예외 테스트들의 경우, 정렬을 진행하기 전에 검증 단계에서 예외가 발생
    // List.of를 써도 UnsupportedException 이 터지지 않는다

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1~45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void 로또_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
