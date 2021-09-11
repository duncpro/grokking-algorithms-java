package com.duncpro.alg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SelectionSort<T> implements Sort<T> {
    @Override
    public List<T> sort(List<T> unsorted, Comparator<T> compare) {
        List<T> sorted = new ArrayList<>();

        // We will remove an element from unsorted for every iteration until unsorted is empty.
        // This of course has a time-complexity of O(n).
        while (!unsorted.isEmpty()) {
            T lowest = null;

            // Find the lowest element in the unsorted list by iterating over every single element
            // Time complexity: O(n)
            // This O(n) algorithm is nested inside of another O(n) algorithm making the entire algorithm
            // O(n^2). In other words, for every element in the list, we must iterate over every element in the list.
            // In reality the unsorted list will decrease in length by one on every iteration.
            // Which means the average time-complexity is O(0.5n * n).
            // On the first while iteration unsorted will be full and on the last iteration unsorted will contain
            // only a single element.
            for (int i = 0; i < unsorted.size(); i++) {
                T maybe = unsorted.get(i);
                if (lowest == null) {
                    lowest = maybe;
                    continue;
                }

                int comparison = compare.compare(maybe, lowest);
                if (comparison <= 0) lowest = maybe;
            }

            sorted.add(lowest);
            unsorted.remove(lowest);
        }
        return sorted;
    }
}
