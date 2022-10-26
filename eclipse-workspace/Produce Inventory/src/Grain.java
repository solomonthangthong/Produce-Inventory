import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3 Declaration: I declare that this is my own original
 * work and is free from Plagiarism This class contains the dynamically
 * allocated array and it's processing 
 * Student Name: Solomon Thangthong 
 * Student Number: 041023691 
 * Section #: 301 
 * Course: CST8130 - Data Structures 
 * Professor:James Mwangi PhD.
 * 
 * The purpose of this class is be the sub class for the Object FoodItem. It
 * is inheriting information from the parent class FoodItem.
 * 
 * @author Solomon Thangthong
 * @version 1.0
 * @since 11.0
 **/
public class Grain extends FoodItem {
	/**
	 * The weight of each bag of grain measured in grams.
	 */
	int grainSize;
	/**
	 * Calls the super class constructor
	 */
	public Grain() {
		super(0, null, 0, 0, 0);

	}
	/**
	 * This method concatenates Option 2, when user asks to display the inventory.
	 */
	
	public String toString() {

		String concatenate = "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $"
				+ String.format("%.2f", itemPrice) + " cost: $" + String.format("%.2f", itemCost) + " size: "
				+ grainSize + "g\n";

		return concatenate;

	}

	/**
	 * This method calls the super class of addItem, alongside adds the weight of
	 * the bag in grams.
	 */
	public boolean addItem(Scanner scanner) {
		/**
		 * Boolean condition for do while loop
		 */
		boolean validInput;
		super.addItem(scanner);
		// Do while until user enters correct data type
		do {
			System.out.print("Enter the weight of the bag in grams: ");
			try {
				grainSize = scanner.nextInt();
				// Ensure the grams is not less than 0.
				do {
					
					if (grainSize < 0) {

						System.out.print("Please enter a positive number: ");
						grainSize = scanner.nextInt();
						validInput = true;

					} else {

						validInput = false;
					}

				} while (validInput);

				validInput = false;

			} catch (InputMismatchException ime) {
				System.out.print("Invalid entry\n");
				scanner.nextLine();
				validInput = true;
			}

		} while (validInput);

		return (grainSize > 0);

	}

}
