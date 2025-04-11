package lotto.controller;

import java.util.Set;
import java.util.function.Supplier;
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

        Lottos lottos = process(this::getLottos);

        // 당첨 번호 및 보너스 번호 입력
        Set<Integer> inputNumbers = process(this::getWinningNumbers);
        int bonusNumber = process(this::getBonusNumber);
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

    private Set<Integer> getWinningNumbers() {
        Set<Integer> inputNumbers = inputView.winningNumberInput();
        return inputNumbers;
    }

    private Lottos getLottos() {
        // 로또 구매
        Lottos lottos = Lottos.from(inputView.moneyInput());
        outputView.printLottoCount(lottos.getLottos().size());
        outputView.printLottos(lottos);
        return lottos;
    }

    private <T> T process(Supplier<T> supplier){
        try{
            return supplier.get();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());;
            return process(supplier);
        }
    }
}
