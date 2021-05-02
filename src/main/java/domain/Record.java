package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Record {
    private Map<Integer, List<Integer>> record;

    public Record() {
        this(new HashMap<>());
    }

    public Record(Map<Integer, List<Integer>> record) {
        this.record = new HashMap<>(record);
    }

    public void add(int count, List<Integer> positions) {
        this.record.put(count, positions);
    }

    public List<Integer> getRecord(int key) {
        return record.get(key);
    }

    public Integer size() {
        return record.size();
    }
}
