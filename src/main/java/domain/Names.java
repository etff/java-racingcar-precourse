package domain;

import utils.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 이름 목록.
 */
public class Names {
    private List<Name> names = new ArrayList<>();

    public Names(String nameInput) {
        generateNames(nameInput);
    }

    private void generateNames(String nameInput) {
        String[] splitText = StringUtil.splitText(nameInput);

        for (String text : splitText) {
            names.add(new Name(text));
        }
    }

    public List<Name> getNames() {
        return new ArrayList<>(names);
    }
}
