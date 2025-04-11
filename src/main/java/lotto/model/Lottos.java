package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(final int price) {
        int lottoCount = price / 1000;

        List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(createIntegerList()))
                .toList();

        return new Lottos(lottos);
    }

    public LottoResults winningResult(WinningNumbers winningNumbers){
        List<LottoResult> lottoResults = new ArrayList<>();

        for (Lotto lotto:lottos){
            lottoResults.add(winningNumbers.countMatch(lotto.getNumbers()));
        }

        return new LottoResults(lottoResults);
    }

    public List<Lotto> getLottos() {
        // 깊은 복사를 통해 참조 넘기지 않도록 구현
        return lottos.stream()
                .map(lotto -> new Lotto(lotto.getNumbers()))
                .toList();
    }

    private static List<Integer> createIntegerList() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
