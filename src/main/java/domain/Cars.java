package domain;

import utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    private List<Integer> positions = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public Cars(List<Car> cars, List<Integer> positions) {
        this.cars = new ArrayList<>(cars);
        this.positions = new ArrayList<>(positions);
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
        List<Car> tempCars = new ArrayList<>();
        List<Integer> tempPosition = new ArrayList<>();

        for (Car car : cars) {
            Car movedCar = car.move();
            tempPosition.add(movedCar.getPosition());
            tempCars.add(movedCar);
        }
        return new Cars(tempCars, tempPosition);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
