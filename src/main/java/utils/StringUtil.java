package utils;

public class StringUtil {
    public static final String EMPTY_NAME_NOT_ALLOWED = "빈값을 입력할 수 없습니다.";
    public static final String DELIMITER = ",";

    public static boolean isBlank(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return value.trim().isEmpty();
    }

    public static String[] splitText(String value) {
        if (isBlank(value) || !value.contains(DELIMITER)) {
            throw new IllegalArgumentException(EMPTY_NAME_NOT_ALLOWED);
        }
        return value.split(DELIMITER);
    }
}
