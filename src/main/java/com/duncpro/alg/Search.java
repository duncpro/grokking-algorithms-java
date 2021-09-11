package com.duncpro.alg;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface Search<T> {
    Optional<Integer> findIndex(T of, List<T> in, Comparator<T> compare);
}
