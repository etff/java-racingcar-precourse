package domain;

import java.util.Objects;

public class Car {
    public static final String EMPTY_NAME_NOT_ALLOWED = "빈값을 입력할 수 없습니다.";
    public static final String NEGATIVE_NUMBER_NOT_ALLOWED = "음수가 입력될 수 없습니다.";
    public static final int MIN_POSITION = 0;

    private final String name;
    private final int position;

    public Car(String name, int position) {
        validate(name , position);
        this.name = name;
        this.position = position;
    }

    public void validate(String name, int position) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME_NOT_ALLOWED);
        }
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_NOT_ALLOWED);
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
