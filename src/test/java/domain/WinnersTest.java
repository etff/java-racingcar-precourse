package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinnersTest {

    @DisplayName("우승자를 구할 수 있다.")
    @Test
    void findWinner() {
        Car car1 = new Car("car1", 4);
        Car car2 = new Car("car2", 2);
        Car car3 = new Car("car3", 3);

        Winners winners = new Winners();
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        Cars winnerCars = winners.findWinners(cars);

        assertThat(winnerCars.getCars().size()).isEqualTo(1);
        assertThat(winnerCars.getCars().contains(car1)).isTrue();
    }
}
