package de.teleran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {

    @Test
    void discountCalc() {
        Discount discount = new Discount();
        assertEquals(0, discount.discountCalc(1,0));
        assertEquals(2, discount.discountCalc(2,0));
        assertEquals(0, discount.discountCalc(13,0));
        assertEquals(2, discount.discountCalc(25,1));
        assertEquals(4, discount.discountCalc(2,1));
    }
}