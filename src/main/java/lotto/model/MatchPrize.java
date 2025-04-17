package lotto.model;

import java.util.Arrays;

public enum MatchPrize {
    NO_MATCH(0,null,0),
    THREE_MATCH (3,null,5000),
    FOUR_MATCH (4,null,50000),
    FIVE_MATCH (5,null,1500000),
    FIVE_MATCH_WITH_BONUS (5,Boolean.TRUE,30000000),
    SIX_MATCH (6,null,2000000000);

    private final int matchCount;
    private final Boolean bonusMatch;
    private final int prize;

    MatchPrize(int matchCount, Boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Boolean getBonusMatch() {
        return bonusMatch;
    }

    public int getPrize() {
        return prize;
    }

    // matchCount에 해당하는 prize를 반환하는 메서드
    public static int getPrizeByMatch(int matchCount, Boolean bonusMatch) {
        return Arrays.stream(MatchPrize.values())
                .filter(matchPrize -> matchPrize.getMatchCount() == matchCount)
                .filter(matchPrize -> matchPrize.getBonusMatch() == bonusMatch)
                .findFirst()
                .orElse(MatchPrize.NO_MATCH)
                .getPrize();
    }

}
