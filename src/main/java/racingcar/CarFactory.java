package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class CarFactory {
    private CarFactory() {
    }

    static List<Car> from(String csv) {
        String[] tokens = csv.split(",");
        if (tokens.length == 0) {
            throw new IllegalArgumentException("자동차가 하나도 없습니다.");
        }
        List<Car> cars = new ArrayList<>();
        Set<String> names = new HashSet<>();
        for (String raw : tokens) {
            String name = raw.trim();
            Car car = new Car(name);
            if (names.contains(name)) {
                throw new IllegalArgumentException("중복된 이름이 있습니다.");
            }
            names.add(name);
            cars.add(car);
        }
        return cars;
    }
}