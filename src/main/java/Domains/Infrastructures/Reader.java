package Domains.Infrastructures;

import Domains.Entities.Verbs;

import java.util.Map;

public interface Reader {
    Map<Integer, Verbs> read();
}
