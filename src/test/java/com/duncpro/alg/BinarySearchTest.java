package com.duncpro.alg;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    final static List<Character> ALPHABET = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');

    static char getRandomLetter() {
        final long i = Math.round(Math.random() * (ALPHABET.size() - 1));
        return ALPHABET.get((int) i);
    }

    @Test
    void findLetter() {
        final var lookFor = getRandomLetter();
        final var expectedIndex = ALPHABET.indexOf(lookFor);

        final var index = new BinarySearch<Character>().findIndex(lookFor, ALPHABET, Comparator.naturalOrder())
                .orElseThrow(AssertionError::new);

        assertEquals(expectedIndex, index);
    }
}
