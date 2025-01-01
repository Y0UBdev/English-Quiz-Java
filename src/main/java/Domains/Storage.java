package Domains;

import java.util.HashMap;
import java.util.Map;

public class Storage {

    private final Map<Integer, Verbs> verbs;

    public Storage(Reader reader) {
        verbs = reader.read();
    }

    public Map<Integer, Verbs> getVerbsMap() {
        return new HashMap<>(verbs);
    }
}
