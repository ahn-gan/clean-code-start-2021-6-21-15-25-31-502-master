package com.tw.academy.basic.$2_magic_number;

public class FareCalculation {

    public static final int MIN_8_DISCOUNT_EXPENSE = 100;
    public static final int MAX_8_DISCOUNT_EXPENSE = 150;
    public static final int MIN_5_DISCOUNT_EXPENSE = 150;
    public static final int MAX_5_DISCOUNT_EXPENSE = 400;

    public double calculate(double originalPrice, double cumulativeExpensesThisMonth) {
        if (is8Discount(cumulativeExpensesThisMonth)) {
            return originalPrice * 0.8;
        }
        if (is5Discount(cumulativeExpensesThisMonth)) {
            return originalPrice * 0.5;
        }
        return originalPrice;
    }

    private boolean is5Discount(double cumulativeExpensesThisMonth) {
        return cumulativeExpensesThisMonth >= MIN_5_DISCOUNT_EXPENSE && cumulativeExpensesThisMonth < MAX_5_DISCOUNT_EXPENSE;
    }

    private boolean is8Discount(double cumulativeExpensesThisMonth) {
        return cumulativeExpensesThisMonth >= MIN_8_DISCOUNT_EXPENSE && cumulativeExpensesThisMonth < MAX_8_DISCOUNT_EXPENSE;
    }
}
