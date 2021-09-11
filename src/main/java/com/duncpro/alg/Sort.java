package com.duncpro.alg;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface Sort<T> {
    /**
     * Sorts the given list according the given comparator.
     * Depending on the implementation this might sort the given list in-place and return a reference to the
     * given list, or produce a new list entirely. Depending on the implementation the given list given
     * might be consumed leaving only a new sorted list.
     */
    List<T> sort(List<T> unsorted, Comparator<T> compare);
}
