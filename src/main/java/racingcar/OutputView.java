package racingcar;

import java.util.List;

public final class OutputView {
    private OutputView() {
    }

    public static void printExecutionTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}