package domain;

import java.util.Objects;

/**
 * 자동차.
 */
public class Car {
    public static final int MIN_POSITION = 0;
    public static final int MOVE_FORWARD = 1;

    /**
     * 자동차 이름.
     */
    private final Name name;
    /**
     * 자동차 위치.
     */
    private final Position position;

    public Car(Name name) {
        this(name, new Position(MIN_POSITION));
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    /**
     * 자동차를 움직입니다.
     *
     * @return 이동이 적용된 자동차.
     */
    public Car move() {
        final MoveStrategy moveStrategy = new MoveStrategy();
        final int randomNumber = moveStrategy.getRandomNumber();
        if (moveStrategy.canMove(randomNumber)) {
            int newPosition = this.position.getPosition() + MOVE_FORWARD;
            return new Car(this.name, new Position(newPosition));
        }
        return new Car(this.name, this.position);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public int updateMaxPosition(int comparePosition) {
        return position.getMaxPosition(comparePosition);
    }

    public boolean isMaxPosition(int maxPosition) {
        return position.isMaxPosition(maxPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getPosition() == car.getPosition() && Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }
}
