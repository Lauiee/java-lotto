package lotto.model;

public enum MatchPrize {
    THREE_MATCH (3,5000),
    FOUR_MATCH (4,50000),
    FIVE_MATCH (5,1500000),
    FIVE_MATCH_WITH_BONUS (5,30000000),
    SIX_MATCH (6,2000000000);

    private final int matchCount;
    private final int prize;

    MatchPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    // matchCount에 해당하는 prize를 반환하는 메서드
    public static int getPrizeByMatch(int matchCount) {
        if (matchCount == 7) return FIVE_MATCH_WITH_BONUS.getPrize();
        if (matchCount == 6) return SIX_MATCH.getPrize();
        if (matchCount == 5) return FIVE_MATCH.getPrize();
        if (matchCount == 4) return FOUR_MATCH.getPrize();
        if (matchCount == 3) return THREE_MATCH.getPrize();
        return 0; // 당첨 안 됨
    }

}
