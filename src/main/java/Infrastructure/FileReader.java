package Infrastructure;

import Domains.Infrastructures.Reader;
import Domains.Entities.Verbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class FileReader implements Reader {

    private Path path;

    public FileReader(Path path) {
        this.path = path;
    }

    public Map<Integer, Verbs> read() {
        Map<Integer, Verbs> map = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line = reader.readLine();
            int index = 1;
            while (line != null && !line.isEmpty()) {
                String[] tab = line.split("-");
                String infinitive = tab.length > 0 ? tab[0].trim() : "";
                String past = tab.length > 1 ? tab[1].trim() : "";
                String participle = tab.length > 2 ? tab[2].trim() : "";

                map.put(index++, new Verbs(infinitive, past, participle));
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }

}
