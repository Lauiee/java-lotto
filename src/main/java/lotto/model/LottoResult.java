package lotto.model;

public class LottoResult {
    private static final int BONUS = 1;

    private final int winningCount;
    private final boolean bonusMatch;

    public LottoResult(int winningCount, boolean bonusMatch) {
        this.winningCount = winningCount;
        this.bonusMatch = bonusMatch;
    }

    public int getLottoPrize(){
        if (bonusMatch){
            if (winningCount == 5) return MatchPrize.getPrizeByMatch(winningCount, true);
        }
        return MatchPrize.getPrizeByMatch(winningCount, null);
    }

    public MatchPrize matchMatchPrize(){
        if (bonusMatch) {
            if (winningCount != 5) {
                return MatchPrize.findMatchPrize(winningCount+1, null);
            }
            return MatchPrize.FIVE_MATCH_WITH_BONUS;
        }
        return MatchPrize.findMatchPrize(winningCount,null);
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getWinningCount() {
        return winningCount;
    }

}
