package lotto.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoResults;
import lotto.model.Lottos;
import lotto.model.MatchPrize;

public class OutputView {

    public void printLottoCount(int count){
        System.out.println();
        System.out.println(count+ViewMessage.OUTPUT_COUNT.getMessage());
    }

    public void printLottos(Lottos lottos){
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> lottoNumbers = lotto.getLottoNumbers();
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
        }
    }

    public void printLottoResults(LottoResults lottoResults){
        System.out.println();
        System.out.println(ViewMessage.OUTPUT_WINNING_COUNT.getMessage());

        Map<MatchPrize, Integer> matchedMap = lottoResults.eachMatchedResult();

        DecimalFormat formatter = new DecimalFormat("###,###");

        int i = 3;

        while(true){
            if (i == 7){
                System.out.printf(ViewMessage.OUTPUT_FIVE_WITH_BONUS.getMessage(), formatter.format(MatchPrize.getPrizeByMatch(5,Boolean.TRUE)), matchedMap.getOrDefault(i, 0));
                i = 6;
                continue;
            }
            System.out.printf(ViewMessage.OUTPUT_RESULT.getMessage(), i, formatter.format(MatchPrize.getPrizeByMatch(i,null)), matchedMap.getOrDefault(MatchPrize.findMatchPrize(i,null), 0));

            if (i==6) break;
            if (i == 5){
                i = 7;
            } else i++;
        }

    }

    public void printRatio(BigDecimal ratio){
        String printRatio = ratio.toString();
        System.out.printf(ViewMessage.OUTPUT_RATIO.getMessage(), printRatio);
    }

}
