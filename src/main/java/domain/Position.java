package domain;

/**
 * 자동차 위치.
 */
public class Position {
    public static final String NEGATIVE_NUMBER_NOT_ALLOWED = "음수가 입력될 수 없습니다.";
    public static final int MIN_POSITION = 0;
    private final int position;

    public Position(int position) {
        this.position = validate(position);
    }

    private int validate(int position) {
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_NOT_ALLOWED);
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    /**
     * 최대 위치값인지 비교하여 위치를 리턴합니다.
     *
     * @param comparePosition 비교하고자하는 위치
     * @return 최대 위치값
     */
    public int getMaxPosition(int comparePosition) {
        return Math.max(comparePosition, this.position);
    }

    /**
     * 최대값이라면 true, 아니라면 false를 반환합니다.
     *
     * @param maxPosition 비교하고자하는 최대 위치값
     * @return 최대값 여부
     */
    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }
}
