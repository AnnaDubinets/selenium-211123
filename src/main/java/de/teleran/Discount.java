package de.teleran;

public class Discount {
    public int discountCalc(int i, int after18) {
        int discount = 0;
        if ((i % 2 != 0) && (after18 == 0)) {
            discount = 0;
        }
        if ((i % 2 == 0) && (after18 == 0)) {
            discount += 4;
        }
        if ((i % 2 == 0) && (after18 == 0) || ((i % 2 != 0) && (after18 == 1)))
            discount += 2;
        return discount;
    }
}
