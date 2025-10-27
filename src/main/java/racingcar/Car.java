package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

final class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position = 0;

    Car(String name) {
        validateName(name);
        this.name = name;
    }

    String getName() {
        return name;
    }

    int getPosition() {
        return position;
    }

    void tryMove() {
        int r = Randoms.pickNumberInRange(0, 9);
        if (r >= MOVE_THRESHOLD) {
            position++;
        }
    }

    private static void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름이 null 입니다.");
        }
        String trimmed = name.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("이름이 비어 있습니다.");
        }
        if (trimmed.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
        if (trimmed.contains(",")) {
            throw new IllegalArgumentException("이름에 쉼표를 포함할 수 없습니다.");
        }
    }
}