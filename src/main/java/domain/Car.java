package domain;

import utils.StringUtil;

import java.util.Objects;

/**
 * 자동차.
 */
public class Car {
    public static final String EMPTY_NAME_NOT_ALLOWED = "빈값을 입력할 수 없습니다.";
    public static final String NEGATIVE_NUMBER_NOT_ALLOWED = "음수가 입력될 수 없습니다.";
    public static final int MIN_POSITION = 0;
    public static final int MOVE_FORWARD = 1;

    /**
     * 자동차 이름.
     */
    private final String name;
    /**
     * 자동차 위치.
     */
    private final int position;

    public Car(String name) {
        this(name, MIN_POSITION);
    }

    public Car(String name, int position) {
        validate(name, position);
        this.name = name;
        this.position = position;
    }

    public void validate(String name, int position) {
        if (StringUtil.isBlank(name)) {
            throw new IllegalArgumentException(EMPTY_NAME_NOT_ALLOWED);
        }
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_NOT_ALLOWED);
        }
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
            return new Car(this.name, this.position + MOVE_FORWARD);
        }
        return new Car(this.name, this.position);
    }


    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getMaxPosition(int maxPosition) {
        return Math.max(maxPosition, this.position);
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
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
