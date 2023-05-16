/*
*Author: Wahab Raza Akram
*Version: 1.0 15/05/2023
*/

package com.wahab.checkout;
import java.util.Scanner;


//Initializes the necessary arrays to store information about the items.
public class Checkout {
	private int items[];
	private int unitPrices[];
	private SpecialPrice specialPrices[];

//Constructor initializes objects of the class.    
	public Checkout() {
		items = new int[100];
		unitPrices = new int[100];
		specialPrices = new SpecialPrice[100];
	}

//Set unit prices and special prices to items.
	public static void main(String[] args) {
		Checkout checkout = new Checkout();
		checkout.setUnitPrice("A", 50);
		checkout.setSpecialPrice("A", 3, 130);
		checkout.setUnitPrice("B", 30);
		checkout.setSpecialPrice("B", 2, 45);
		checkout.setUnitPrice("C", 20);
		checkout.setUnitPrice("D", 15);

		Scanner scanner = new Scanner(System.in);
		Calculator finalCalculation = new Calculator(checkout);

//Menu to select what the user wants to do.
		while (true) {
			System.out.println("Menu:");
			System.out.println("1. To scan an item, press 1");
			System.out.println("2. To remove an item, press 2");
			System.out.println("3. To finish and calculate total price press 3");

			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			// If user inputs 1, system prints out scanned item, after selection.
			if (choice == 1) {
				System.out.print("Scan item A,B,C or D: ");
				String item = scanner.next();
				checkout.scan(item);
				double total = finalCalculation.calculateTotal();
				System.out.println("Running total: £" + total);

				// If user inputs 2, system prints out remove item and executes the remoteItem()
				// method.
			} else if (choice == 2) {
				System.out.print("Enter the item to remove: ");
				String item = scanner.next();
				checkout.removeItem(item);
				double total = finalCalculation.calculateTotal();
				System.out.println("Running total: £" + total);

				// If user inputs 3, system prints out the final total.
			} else if (choice == 3) {
				break;
			}
		}

//Calculate final total price for the items added.
		double finalTotal = finalCalculation.calculateTotal();
		System.out.println("Thanks for your purchase, your final total is: £" + finalTotal);
		scanner.close();
	}

//Gets the array of items.
	public int[] getItems() {
		return items;
	}

//Gets the array of unit prices.
	public int[] getUnitPrices() {
		return unitPrices;
	}

//Sets the unit price for a specific item.
	public void setUnitPrice(String item, int price) {
		int index = item.charAt(0);
		unitPrices[index] = price;
	}

//Sets the special price for a item and quantity
	public void setSpecialPrice(String item, int quantity, int price) {
		int index = item.charAt(0);
		specialPrices[index] = new SpecialPrice(quantity, price);
	}

//Scans the item that has been input in the terminal and returns the price associated with it.
	public void scan(String item) {
		int index = item.charAt(0);
		items[index]++;
	}

//Removes the price of the chosen item and it substracts it from the running total.
	public void removeItem(String item) {
		int index = item.charAt(0);
		if (items[index] > 0) {
			items[index]--;
		}
	}

//constructor for specialPrice used in SpecialPrice class.
	public SpecialPrice[] getSpecialPrices() {
		return specialPrices;
	}
}