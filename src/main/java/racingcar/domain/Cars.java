package racingcar.domain;

import java.util.*;

public class Cars {
    private final List<Car> values;
    private Cars(List<Car> cars) {this.values = cars;}

    public static Cars of (List<String> names){
        List<Car> cars = new ArrayList<>();
        for (String n : names) cars.add(new Car(n));
        return new Cars(cars);
    }

    public void moveAll(MovePolicy policy){
        values.forEach(c -> c.moveIf(policy));
    }

    public List<String> snapshot(){
        List<String> lines = new ArrayList<>();
        for (Car c : values) lines.add(c.name() + " : " + c.progressBar());
        return lines;
    }

    public List<String> winners() {
        int max = values.stream().map(Car::position).max(Comparator.naturalOrder()).orElse(0);
        List<String> result = new ArrayList<>();
        for (Car c : values) if (c.position() == max) result.add(c.name());
        return Collections.unmodifiableList(result);
    }
}
