package com.tw.academy.basic.$7_long_method;

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
    public static final double TEN_PERCENTAGE_SALES_TAX = 0.10d;
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
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append(WORD_SEPARATOR);
            output.append(lineItem.getPrice());
            output.append(WORD_SEPARATOR);
            output.append(lineItem.getQuantity());
            output.append(WORD_SEPARATOR);
            output.append(lineItem.totalAmount());
            output.append(LINE_SEPARATOR);

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.subSaleTax();
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.totalAmount() + salesTax;
        }

        // prints the state tax
        output.append(SALES_TAX).append(WORD_SEPARATOR).append(totSalesTx);

        // print total amount
        output.append(TOTAL_AMOUNT).append(WORD_SEPARATOR).append(tot);
        return output.toString();
    }

    private void buildCustomerInformation(StringBuilder output) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }

    private void buildReceiptHeader(StringBuilder output) {
        output.append(PRINTING_ORDER_RECEIPT_HEADER + LINE_SEPARATOR);
    }
}