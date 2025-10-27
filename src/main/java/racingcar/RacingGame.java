package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class RacingGame {
    private final List<Car> cars;
    private final int rounds;

    RacingGame(List<Car> cars, int rounds) {
        this.cars = new ArrayList<>(cars); // defensive copy
        this.rounds = rounds;
    }

    interface RoundListener {
        void afterRound(List<Car> snapshot);
    }

    void playEachRound(RoundListener listener) {
        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                car.tryMove();
            }
            listener.afterRound(unmodifiableSnapshot());
        }
    }

    List<String> findWinners() {
        int max = 0;
        for (Car c : cars) {
            if (c.getPosition() > max) {
                max = c.getPosition();
            }
        }
        List<String> winners = new ArrayList<>();
        for (Car c : cars) {
            if (c.getPosition() == max) {
                winners.add(c.getName());
            }
        }
        return winners;
    }

    private List<Car> unmodifiableSnapshot() {
        return Collections.unmodifiableList(cars);
    }
}