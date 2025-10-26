package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarsTest {
    static class AlwaysMove implements MovePolicy { public boolean canMove() { return true; } }
    static class NeverMove implements MovePolicy { public boolean canMove() { return false; } }

    @Test
    void 모두_항상_전진하면_같이_우승() {
        Cars cars = Cars.of(List.of("a", "bb", "ccc"));
        cars.moveAll(new AlwaysMove());
        assertThat(cars.winners()).containsExactlyInAnyOrder("a", "bb", "ccc");
    }

    @Test
    void 아무도_전진하지_않으면_모두_우승() {
        Cars cars = Cars.of(List.of("pobi", "woni"));
        cars.moveAll(new NeverMove());
        assertThat(cars.winners()).containsExactlyInAnyOrder("pobi", "woni");
    }
}
