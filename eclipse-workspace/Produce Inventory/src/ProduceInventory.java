import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The purpose of this class is a driver class and is the program execution
 * start point This implements a show menu with switch statements.
 * 
 * @author Solomon Thangthong
 * @version 1.0
 * @since 11.0
 **/
public class ProduceInventory {

	/**
	 * Private Scanner connected to keyboard in main - to pass to methods.
	 */
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Main driver for entry of the program.
	 * 
	 * @param args - String[] args
	 */
	public static void main(String[] args) {
		/**
		 * Call Inventory Class, to be able to access the methods.
		 */
		Inventory inventory = new Inventory();
		/**
		 * Option 1, Add Item
		 */
		final int ADD_ITEM = 1;
		/**
		 * Option 2, Display Inventory
		 */
		final int DISPLAY_INVENTORY = 2;
		/**
		 * Option 3, Buy Item
		 */
		final int BUY_ITEM = 3;
		/**
		 * Option 4, Sell Item
		 */
		final int SELL_ITEM = 4;
		/**
		 * Option 5, Exit program
		 */
		final int EXIT = 5;
		/**
		 * Integer variable to be passed to determine which switch case user wants to
		 * enter.
		 */
		int option;

		// Do While loop until option 5 EXIT is inputed
		do {
			displayMenu();
			// Option is equal to what option class returns
			option = option();

			switch (option) {

			case ADD_ITEM:
				inventory.addItem(scanner);

				break;
			case DISPLAY_INVENTORY:
				System.out.print("Inventory:\n");
				System.out.print(inventory.toString() + "\n");
				break;
			case BUY_ITEM:
				inventory.updateQuantity(scanner, true);
				break;
			case SELL_ITEM:
				inventory.updateQuantity(scanner, false);
				break;
			case EXIT:
				return;
			}
		} while (option != EXIT);
		scanner.close();
	}

	/**
	 * This method prints the option menu for the users.
	 */
	private static void displayMenu() {
		System.out.print("Please select one of the following:\n");
		System.out.print("1. Add Item to Inventory\n");
		System.out.print("2. Display Current Inventory\n");
		System.out.print("3. Buy Item(s)\n");
		System.out.print("4. Sell Item(s)\n");
		System.out.print("5. To Exit\n");
	}

	/**
	 * This method is a do while try catch for the user. This method will loop until
	 * the user returns correct data type.
	 * 
	 * @return option - User input for menu selection
	 */
	private static int option() {
		/*
		 * Initialize option variable for user
		 */
		int option = 0;
		/*
		 * boolean for do while loop condition
		 */
		boolean validInput;

		// Do while loop until user enters correct data information.
		do {
			try {
				option = scanner.nextInt();
				do {
					if (option > 5 || option < 0) {
						System.out.print("...Invalid input, please try again...\n");
						option = scanner.nextInt();
						validInput = true;
					} else {
						validInput = false;
					}
				} while (validInput);

			} catch (InputMismatchException nfe) {
				System.out.print("...Invalid input, please try again...\n");
				scanner.nextLine();
				validInput = true;
			}

		} while (validInput);
		// Return option menu to main class for switch case.
		return option;
	}

}
