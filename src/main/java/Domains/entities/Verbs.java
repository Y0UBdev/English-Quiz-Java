package Domains.entities;

public record Verbs(String infinitive, String past, String participle) {
    @Override
    public String toString() {
        return String.format(" - %s, %s, %s", infinitive, past, participle);
    }
}
