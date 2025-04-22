package lotto.view;

public enum ViewMessage {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNINGNUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUSNUMBER("보너스 번호를 입력해 주세요."),



    // OUTPUT
    OUTPUT_COUNT("개를 구매했습니다."),
    OUTPUT_WINNING_COUNT("당첨 통계\n---"),
    OUTPUT_RATIO("총 수익률은 %s%%입니다."),
    OUTPUT_FIVE_WITH_BONUS("5개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    OUTPUT_RESULT("%d개 일치 (%s원) - %d개\n");

    ;

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
