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

    public String buildReceipt() {
        StringBuilder receipt = new StringBuilder();
        buildReceiptHeader(receipt);
        buildCustomerInformation(receipt);
        buildReceiptBody(receipt);
        buildTotalSalesTax(receipt);
        buildTotalAmount(receipt);
        return receipt.toString();
    }

    private void buildTotalAmount(StringBuilder receipt) {
        receipt.append(TOTAL_AMOUNT).append(WORD_SEPARATOR).append(order.getTotalAmount());
    }

    private void buildTotalSalesTax(StringBuilder receipt) {
        receipt.append(SALES_TAX).append(WORD_SEPARATOR).append(order.getTotalSalesTax());
    }

    private void buildReceiptBody(StringBuilder receipt) {
        for (LineItem lineItem : order.getLineItems()) {
            receipt.append(lineItem.getGeneralInformation());
        }
    }

    private void buildCustomerInformation(StringBuilder receipt) {
        receipt.append(order.getCustomerName());
        receipt.append(order.getCustomerAddress());
    }

    private void buildReceiptHeader(StringBuilder receipt) {
        receipt.append(PRINTING_ORDER_RECEIPT_HEADER + LINE_SEPARATOR);
    }
}