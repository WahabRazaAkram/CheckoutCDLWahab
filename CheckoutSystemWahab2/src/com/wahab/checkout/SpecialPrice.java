/*
*Author: Wahab Raza Akram
*Version: 1.0 15/05/2023
*/
package com.wahab.checkout;


//Represents a special price for an item with a specific quantity.
public class SpecialPrice {
	private int quantity;
	private int price;

//COnstructor for SpecialPrice.
	public SpecialPrice(int quantity, int price) {
		this.quantity = quantity;
		this.price = price;
	}

//Gets the special price stored.
	public int getPrice() {
		return price;
	}

//Gets the quantity required for the special price.
	public int getQuantity() {
		return quantity;
	}
}