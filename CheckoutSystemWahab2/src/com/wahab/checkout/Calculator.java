/*
*Author: Wahab Raza Akram
*Version: 1.0 15/05/2023
*/
package com.wahab.checkout;


public class Calculator {

//Global variables for the Calculator class.
	private Checkout checkout;
	private int specialPrices[];

//Constructor for the Calculator class.
	public Calculator(Checkout checkout) {
		this.checkout = checkout;
		specialPrices = new int[256];
	}

//The calculateTotal method below calculates the total price and also the specialPrice.
	public double calculateTotal() {
		int total = 0; // Stores the total in variable 0.
		for (char item = 'A'; item <= 'D'; item++) {
			int index = item;
			int count = checkout.getItems()[index];

			if (count > 0) {
				int unitPrice = checkout.getUnitPrices()[index]; // Index of items and price.
				int specialCount = count / getSpecialQuantity(item);
				int remainingCount = count % getSpecialQuantity(item);
				int specialPrice = getSpecialPrice(item);
				total += specialCount * specialPrice + remainingCount * unitPrice;
			}
		}

		// otuput of the final price.
		double totalInDecimal = total / 100.0;
		return totalInDecimal;
	}

	/*
	 * Methods with a condition in the return statement, executes the getQuantity()
	 * and getPrice() methods for the values stored in getSpecialPrices(). If there
	 * is no special price in the item, then getUnitPrices() is called.
	 */
	public int getSpecialQuantity(int index) {
		return (checkout.getSpecialPrices()[index] != null) ? checkout.getSpecialPrices()[index].getQuantity() : 1;
	}

	public int getSpecialPrice(int index) {
		return (checkout.getSpecialPrices()[index] != null) ? checkout.getSpecialPrices()[index].getPrice()
				: checkout.getUnitPrices()[index];
	}
}