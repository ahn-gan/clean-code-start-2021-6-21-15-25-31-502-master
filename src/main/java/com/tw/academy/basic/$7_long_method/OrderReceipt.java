package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    private static final String PRINTING_ORDER_RECEIPT_HEADER = "======Printing Orders======\n";
    private static final String SALES_TAX = "Sales Tax";
    private static final String TOTAL_AMOUNT = "Total Amount";
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

        // print headers
        buildReceiptHeader(output);

        // print date, bill no, customer name
//        output.append("Date - " + order.getDate();
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
//        output.append(order.getCustomerLoyaltyNumber());

        // prints lineItems
        double totSalesTx = 0d;
        double tot = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.totalAmount() + salesTax;
        }

        // prints the state tax
        output.append(SALES_TAX).append('\t').append(totSalesTx);

        // print total amount
        output.append(TOTAL_AMOUNT).append('\t').append(tot);
        return output.toString();
    }

    private void buildReceiptHeader(StringBuilder output) {
        output.append(PRINTING_ORDER_RECEIPT_HEADER);
    }
}