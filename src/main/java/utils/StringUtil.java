package utils;

public class StringUtil {
    public static final String INPUT_ERROR = "잘못된 입력입니다.";
    public static final String DELIMITER = ",";

    public static boolean isBlank(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return value.trim().isEmpty();
    }

    public static String[] splitText(String value) {
        if (isBlank(value) || !value.contains(DELIMITER)) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }
        return value.split(DELIMITER);
    }
}
