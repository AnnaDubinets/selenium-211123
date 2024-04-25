package de.teleran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void garlandLength() {

        Tree tree = new Tree();
        int actualLength = tree.garlandLength(new int[]{1,2,3,4,5});
        int expectedLength = 4;
        assertEquals(expectedLength, actualLength);
    }
}