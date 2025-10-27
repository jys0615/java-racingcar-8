package racingcar;

import java.util.List;

public class GameController {

    public void run() {
        // 입력
        String rawNames = InputView.readCarNames();
        List<Car> cars = CarFactory.from(rawNames); // 검증 포함(예외 던짐)
        int tryCount = InputView.readTryCount(); // 정수/음수 검증(예외 던짐)

        // 실행
        OutputView.printExecutionTitle();
        RacingGame game = new RacingGame(cars, tryCount);
        game.playEachRound((snapshot) -> { // 라운드마다 출력
            OutputView.printRound(snapshot);
            OutputView.printEmptyLine();
        });

        // 우승자 출력
        List<String> winners = game.findWinners();
        OutputView.printWinners(winners);
    }
}