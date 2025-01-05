package Domains.storages;

import Domains.entities.Verbs;
import Infrastructure.VerbsIrregularReader;
import Infrastructure.VocabReader;

import java.util.List;
import java.util.Map;

public class Storage {

    private final Map<Integer, Verbs> verbsMap;
    private final Map<String, List<String>> vocabularyMap;

    public Storage(VerbsIrregularReader verbsReader, VocabReader vocabReader) {
        this.verbsMap = verbsReader.read();
        this.vocabularyMap = vocabReader.readVocabulary();
    }

    public Map<Integer, Verbs> getVerbsMap() {
        return verbsMap;
    }

    public Map<String, List<String>> getVocabularyMap() {
        return vocabularyMap;
    }
}
