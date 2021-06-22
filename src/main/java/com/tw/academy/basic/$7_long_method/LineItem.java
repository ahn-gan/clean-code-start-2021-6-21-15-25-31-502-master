package com.tw.academy.basic.$7_long_method;

public class LineItem {

	private final double TEN_PERCENTAGE_SALES_TAX = 0.10d;
	private final char WORD_SEPARATOR = '\t';
	private final char LINE_SEPARATOR = '\n';

	private String description;
	private double price;
	private int quantity;

	public LineItem(String description, double p, int quantity) {
		super();
		this.description = description;
		this.price = p;
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    double totalAmount() {
        return price * quantity;
    }

	double subSaleTax() {
		return totalAmount() * TEN_PERCENTAGE_SALES_TAX;
	}

	public String getGeneralInformation() {
		return getDescription() + WORD_SEPARATOR
		+ getPrice()+ WORD_SEPARATOR
		+ getQuantity() + WORD_SEPARATOR +
		+ totalAmount() + LINE_SEPARATOR;
	}
}