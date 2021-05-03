package domain;

public class Number {
    public static final String NOT_VALID_NUMBER = "올바른 숫자가 아닙니다.";
    private final int positiveNumber;

    public Number(String input) {
        this.positiveNumber = parse(input);
    }

    private int parse(String textNumber) {
        try {
            return (Integer.parseUnsignedInt(textNumber));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_VALID_NUMBER + e.getMessage());
        }
    }

    public int getNumber() {
        return positiveNumber;
    }
}
