import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The purpose of this class is be the parent class for the Object FoodItem. It
 * is laying the foundation for each sub class to inherit from.
 * 
 * @author Solomon Thangthong
 * @version 1.0
 * @since 11.0
 **/
public abstract class FoodItem {
	/**
	 * itemCode for the Object item
	 */
	protected int itemCode;
	/**
	 * The name that will be used for the Object item
	 */
	protected String itemName;
	/**
	 * The price that the user will sell the Object item
	 */
	protected float itemPrice;
	/**
	 * The number of quantities the Object item
	 */
	protected int itemQuantityInStock;
	/**
	 * The cost to own the Object item
	 */
	protected float itemCost;

	/**
	 * Super class constructor containing the Object code, name, price, quantity,
	 * and cost
	 * 
	 * @param code              - itemCode
	 * @param name              - itemName
	 * @param price             - itemPrice
	 * @param quantityAvailable - itemQuantityInStock
	 * @param cost              - itemCost
	 */
	public FoodItem(int code, String name, float price, int quantityAvailable, float cost) {

		this.itemCode = code;
		this.itemName = name;
		this.itemPrice = price;
		this.itemQuantityInStock = quantityAvailable;
		this.itemCost = cost;

	}

	/**
	 * Abstract method where sub classes will determine their own concatenation of
	 * string.
	 */
	public abstract String toString();

	/**
	 * This method will check if the amount + current quantity is greater than 0. If
	 * it is greater than it will update the quantity amount of the Object.
	 * 
	 * @param amount - Integer that is being bought or sold
	 * @return - If return true the quantity was successfully updated.
	 */
	public boolean updateItem(int amount) {

		// If itemQuantity + amount is greater than zero, add the two together to create
		// a new value, and return true.
		if ((itemQuantityInStock + amount) > 0) {
			itemQuantityInStock = itemQuantityInStock + amount;
			return true;
		}
		return false;

	}

	/**
	 * This method will check the Object that is being passed, and comparing the
	 * Object itemCode to the itemCode that is being acted on.
	 * 
	 * @param item - New instance of FoodItem class
	 * @return - If true the passed item itemCode is equal to the acted Object
	 *         itemCode.
	 */
	public boolean isEqual(FoodItem item) {

		if (item.itemCode == itemCode) {
			return true;
		}
		return false;
	}

	/**
	 * This method is the superclass version of taking in data for each variable for
	 * the new instances of each object.
	 * 
	 * @param scanner - Scanner from Main class
	 * @return - If true the Object successfully read each data type and updated the
	 *         variables.
	 */
	public boolean addItem(Scanner scanner) {

		boolean validInput;

		System.out.print("Enter the name for the item: ");
		scanner.nextLine();
		itemName = scanner.nextLine();
		// Do while loop until user inputs correct data type.
		do {
			System.out.print("Enter the quantity for the item: ");

			try {
				itemQuantityInStock = scanner.nextInt();
				// Do while to ensure the amount is greater than 0.
				do {
					if (itemQuantityInStock < 0) {
						System.out.print("Invalid entry\n");
						System.out.print("Enter the quantity for the item: ");
						itemQuantityInStock = scanner.nextInt();
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
		// Do while loop until user inputs correct data type.
		do {
			System.out.print("Enter the cost of the item: ");
			try {
				itemCost = scanner.nextFloat();
				// Ensure itemCost is above 0.
				do {
					if (itemCost < 0) {
						System.out.print("Invalid entry\n");
						System.out.print("Enter the cost of the item: ");
						itemCost = scanner.nextFloat();
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
		// Do while loop until user inputs correct data type.
		do {
			System.out.print("Enter the sales price of the item: ");
			try {
				itemPrice = scanner.nextFloat();
				// Ensure itemPrice is above 0
				do {
					if (itemPrice < 0) {
						System.out.print("Invalid entry\n");
						System.out.print("Enter the sales price of the item: ");
						itemPrice = scanner.nextFloat();
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
		// Return true if matches condition.
		return (itemCode > 0 && itemName != null && itemPrice > 0 && itemQuantityInStock > 0 && itemCost > 0);
	}

	/**
	 * This method will validate the itemCode the user is entering.
	 * 
	 * @param scanner - Scanner from Main class
	 * @return - If true inputCode matches itemCode.
	 */
	public boolean inputCode(Scanner scanner) {

		int inputCode = 0;
		boolean validInput;

		// Do while loop until user enters correct data type.
		do {
			System.out.print("Enter the code for the item: ");
			try {
				inputCode = scanner.nextInt();
				itemCode = inputCode;
				validInput = false;
			} catch (InputMismatchException ime) {
				System.out.print("Invalid code\n");
				scanner.nextLine();
				validInput = true;
			}
		} while (validInput);
		// Return true if inputCode matches itemCode.
		return (inputCode == itemCode);
	}

}