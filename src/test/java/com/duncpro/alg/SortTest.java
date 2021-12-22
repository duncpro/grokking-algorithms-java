package com.duncpro.alg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {
    List<Integer> unsortedNumbers = new ArrayList<>();

    @BeforeEach
    void populateRandomNumList() {
        int numUpperBound = Integer.MAX_VALUE;
        int listLength = 100;

        for (int i = 0; i < listLength; i++) {
            int randomNumber = (int) Math.round(Math.random() * numUpperBound);
            unsortedNumbers.add(randomNumber);
        }
    }

    @Test
    void selectionSort() {
        final var expected = unsortedNumbers.stream()
                .sorted()
                .collect(Collectors.toList());

        final var sorted =
            new SelectionSort<Integer>().sort(unsortedNumbers, Comparator.naturalOrder());

        assertEquals(expected, sorted);
    }

    @Test
    void quickSort() {
        final var expected = unsortedNumbers.stream()
                .sorted()
                .collect(Collectors.toList());

        final var sorted =
                new QuickSort<Integer>().sort(unsortedNumbers, Comparator.naturalOrder());

        assertEquals(expected, sorted);
    }
}
