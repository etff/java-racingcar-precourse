package domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 경기를 기록합니다.
 */
public class Record {
    private Map<Integer, Cars> record;

    public Record() {
        record = new HashMap<>();
    }

    public void add(int count, Cars cars) {
        this.record.put(count, cars);
    }

    public Cars getRecord(int key) {
        return record.get(key);
    }

    public Integer size() {
        return record.size();
    }
}
