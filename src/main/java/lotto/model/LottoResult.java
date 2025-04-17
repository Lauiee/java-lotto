package lotto.model;

public class LottoResult {
    public static final int FIVE_WITH_BONUS = 7;
    private static final int BONUS = 1;

    private final int winningCount;
    private final boolean bonusMatch;

    public LottoResult(int winningCount, boolean bonusMatch) {
        this.winningCount = winningCount;
        this.bonusMatch = bonusMatch;
    }

    public int countResultWithBonusMatch(){
        if (bonusMatch){
            if (winningCount == 5) return FIVE_WITH_BONUS;
            return winningCount + BONUS;
        }
        return winningCount;
    }

    public int getLottoPrize(){
        return MatchPrize.getPrizeByMatch(winningCount, bonusMatch);
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getWinningCount() {
        return winningCount;
    }

}
