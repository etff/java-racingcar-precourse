package domain;

import utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차 목록.
 */
public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String input) {
        generateCars(input);
    }

    private void generateCars(String input) {
        String[] splitText = StringUtil.splitText(input);
        for (String text: splitText) {
            cars.add(new Car(text));
        }
    }

    public Cars move() {
        List<Car> carsRecords = new ArrayList<>();
        for (Car car : cars) {
            Car movedCar = car.move();
            carsRecords.add(movedCar);
        }
        return new Cars(carsRecords);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
