package com.duncpro.alg;

import java.util.*;

public class BinarySearch<T> implements Search<T> {
    @Override
    public Optional<Integer> findIndex(T of, List<T> in, Comparator<T> compare) {
        int upperBound = in.size() - 1;
        int lowerBound = 0;

        // When lowerBound exceeds upperBound we have exhausted all possible indexes in the sorted list.
        // Therefore the element we are looking for does not exist.
        while (upperBound >= lowerBound) {
            // By always guessing in the middle we can cut the number of possibilities in half
            // for every single guess. Effectively giving this search algorithm a time-complexity of O(logBASE(2, n)).
            final int guessIndex = Math.round((upperBound + lowerBound) / (float) 2);

            final T guessedElement = in.get(guessIndex);
            final int comparison = compare.compare(of, guessedElement);

            // If our guess is greater than that of the element we are searching for
            // then we can narrow the scope of the search by setting a new upper bound.
            if (comparison < 0) upperBound = guessIndex - 1;

            // If our guess is lower then the element we are searching for, then we can narrow
            // the scope of the search by setting a new lower bound.
            if (comparison > 0) lowerBound = guessIndex + 1;

            if (comparison == 0) return Optional.of(guessIndex);
        }

        return Optional.empty();
    }
}
