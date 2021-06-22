package com.tw.academy.basic.$7_long_method;

import java.util.List;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    private static final String PRINTING_ORDER_RECEIPT_HEADER = "======Printing Orders======";
    private static final String SALES_TAX = "Sales Tax";
    private static final String TOTAL_AMOUNT = "Total Amount";
    public static final char WORD_SEPARATOR = '\t';
    public static final char LINE_SEPARATOR = '\n';
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    //Deprecated
    public String printCustomerName() {
        return order.getCustomerName();
    }

    //todo: rename -- Tom
    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        buildReceiptHeader(output);
        buildCustomerInformation(output);

        // prints lineItems
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getGeneralInformation());
            double salesTax = lineItem.subSaleTax();

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.totalAmount() + salesTax;
        }

        double totalSalesTax = getTotalSalesTax(order.getLineItems());
        // prints the state tax
        output.append(SALES_TAX).append(WORD_SEPARATOR).append(totalSalesTax);

        // print total amount
        output.append(TOTAL_AMOUNT).append(WORD_SEPARATOR).append(tot);
        return output.toString();
    }

    private double getTotalSalesTax(List<LineItem> lineItems) {
        return lineItems.stream().mapToDouble(LineItem::subSaleTax).sum();
    }

    private void buildCustomerInformation(StringBuilder output) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }

    private void buildReceiptHeader(StringBuilder output) {
        output.append(PRINTING_ORDER_RECEIPT_HEADER + LINE_SEPARATOR);
    }
}