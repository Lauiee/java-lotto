package lotto.controller;

import static lotto.util.InputRetry.retry;

import java.util.List;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.LottoResults;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){

        Lottos lottos = retry(this::getLottos);

        // 당첨 번호 및 보너스 번호 입력
        Lotto inputNumbers = retry(this::getWinningNumbers);
        int bonusNumber = retry(this::getBonusNumber);
        WinningNumbers winningNumbers = new WinningNumbers(inputNumbers, bonusNumber);

        // 당첨 결과 확인
        LottoResults lottoResults = lottos.winningResult(winningNumbers);
        outputView.printLottoResults(lottoResults);
        outputView.printRatio(lottoResults.lottoReturnRate());
    }

    private int getBonusNumber() {
        int bonusNumber = inputView.bonusNumberInput();
        return bonusNumber;
    }

    private Lotto getWinningNumbers() {
        List<Integer> inputNumbers = inputView.winningNumberInput();
        return new Lotto(inputNumbers);
    }

    private Lottos getLottos() {
        // 로또 구매
        Lottos lottos = Lottos.from(inputView.moneyInput());
        outputView.printLottoCount(lottos.getLottos().size());
        outputView.printLottos(lottos);
        return lottos;
    }

}
