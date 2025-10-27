package racingcar;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {
    private InputView() {
    }

    public static String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String line = Console.readLine();
        if (line == null || line.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 비어 있습니다.");
        }
        return line.trim();
    }

    public static int readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String line = Console.readLine();
        if (line == null || line.isBlank()) {
            throw new IllegalArgumentException("시도 횟수가 비어 있습니다.");
        }
        int n;
        try {
            n = Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
        if (n <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
        return n;
    }
}