package com.duncpro.alg;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;

public class QuickSort<T> implements Sort<T> {
    @Override
    public List<T> sort(List<T> unsorted, Comparator<T> comparator) {
        if (unsorted.isEmpty() || unsorted.size() == 1) return unsorted;

        if (unsorted.size() == 2) return sort(unsorted.get(0), unsorted.get(1), comparator);

        // For arrays containing three or more elements,
        // divide the array into two halves, of potentially unequal sizes.
        // The first half A, will contain all elements which are less than or equal
        // to p. The second half, B will contain all elements which are greater than
        // p.

        T p = unsorted.remove(1);
        List<T> A = unsorted.stream()
                .filter(a -> comparator.compare(a, p) <= 0)
                .collect(toList());
        List<T> B = unsorted.stream()
                .filter(a -> comparator.compare(a, p) > 0)
                .collect(toList());

        // Now A, and B, must each be sorted, and then finally the
        // list can be recomposed.
        A = sort(A, comparator);
        B = sort(B, comparator);

        return Stream.of(A.stream(), Stream.of(p), B.stream())
                .flatMap(identity())
                .collect(toList());
    }

    List<T> sort(T a, T b, Comparator<T> comparator) {
        if (comparator.compare(a, b) <= 0) {
            return List.of(a, b);
        } else {
            return List.of(b, a);
        }
    }

}
