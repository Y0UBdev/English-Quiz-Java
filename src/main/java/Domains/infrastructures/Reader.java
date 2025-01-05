package Domains.infrastructures;

import Domains.entities.Verbs;

import java.util.Map;

public interface Reader {
    Map<Integer, Verbs> read();
}
