package de.teleran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumTest {

    @Test
    void sumOfTwoNumber() {
        Sum sum = new Sum();
        int actualSumValue = sum.sumOfTwoNumbers(1,4);
        int expectedSumValue = 5;
        assertEquals(expectedSumValue, actualSumValue);
    }
}