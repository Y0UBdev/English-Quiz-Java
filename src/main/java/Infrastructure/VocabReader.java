package Infrastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VocabReader {
    private final Path path;

    public VocabReader(Path path) {
        this.path = path;
    }

    public Map<String, List<String>> readVocabulary() {
        Map<String, List<String>> vocabMap = new LinkedHashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            String currentCategory = "";

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                if (!line.startsWith("=")) {
                    currentCategory = line;
                    vocabMap.put(currentCategory, new ArrayList<>());
                } else {
                    vocabMap.get(currentCategory).add(line.substring(1).trim());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return vocabMap;
    }
}
