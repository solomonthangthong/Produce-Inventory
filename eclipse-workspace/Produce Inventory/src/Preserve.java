import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The purpose of this class is be the sub class for the Object FoodItem. It
 * is inheriting information from the parent class FoodItem.
 * 
 * @author Solomon Thangthong
 * @version 1.0
 * @since 11.0
 **/
public class Preserve extends FoodItem {
	/**
	 * The size of the jar measured in milliliters.
	 */
	int jarSize;

	/**
	 * Calls the super class constructor
	 */
	public Preserve() {
		super(0, null, 0, 0, 0);
	}

	/**
	 * This method concatenates Option 2, when user asks to display the inventory.
	 */
	
	public String toString() {

		String concatenate = "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $"
				+ String.format("%.2f", itemPrice) + " cost: $" + String.format("%.2f", itemCost) + " size: " + jarSize
				+ "mL\n";
		;

		return concatenate;
	}

	/**
	 * This method calls the super class of addItem, alongside adds the size of the
	 * jar in milliliters.
	 */
	public boolean addItem(Scanner scanner) {
		/**
		 * Boolean for do while condition
		 */
		boolean validInput;
		super.addItem(scanner);
		/**
		 * Ensures user inputs correct data type for the size of the jars.
		 */
		do {
			System.out.print("Enter the size of the jar in millilitres: ");
			try {
				jarSize = scanner.nextInt();
				// Ensures jarSize is greater than 0
				do {
					// If size is less than 0, print error message, and prompt user again.
					if (jarSize < 0) {

						System.out.print("Please enter a positive number: ");
						jarSize = scanner.nextInt();
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

		return (jarSize > 0);

	}
}
