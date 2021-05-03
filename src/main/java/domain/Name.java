package domain;

import utils.StringUtil;

import java.util.Objects;

/**
 * 이름.
 */
public class Name {
    public static final String EMPTY_NAME_NOT_ALLOWED = "빈값을 입력할 수 없습니다.";
    private String name;

    public Name(String name) {
        this.name = validate(name);
    }

    private String validate(String name) {
        if (StringUtil.isBlank(name)) {
            throw new IllegalArgumentException(EMPTY_NAME_NOT_ALLOWED);
        }
        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name1 = (Name) o;
        return Objects.equals(getName(), name1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
