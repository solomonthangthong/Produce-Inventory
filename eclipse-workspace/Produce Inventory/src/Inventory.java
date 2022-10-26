import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The purpose of this class is be store every object of FoodItem.
 * It manages and maintains what is going inside and out of the Inventory.
 * 
 * @author Solomon Thangthong
 * @version 1.0
 * @since 11.0
 **/
public class Inventory {
	/**
	 * Initialize FoodItem array
	 */
	private FoodItem[] inventory;
	/**
	 * Number of items in the inventory
	 */
	int numItems;

	/**
	 * Declare the size of the array
	 */
	public Inventory() {
		inventory = new FoodItem[20];
	}

	/**
	 * This method combines each objects toString method into one single string.
	 */
	public String toString() {

		String combine = "";
		// Loop through Inventory array, and display what is currently in stock
		for (int index = 0; index < inventory.length; index++) {
			// If the index is not equal to null and there is an object
			if (inventory[index] != null) {
				combine = combine + inventory[index].toString();
			}
		}
		return combine;
	}

	/**
	 * This method checks to see if a Object already exists in the inventory. It
	 * also calls isEqual method to checks to see if the user input itemCode matches
	 * other instances.
	 * 
	 * @param item - New instance of the subclasses of FoodItem
	 * @return - if returns -1 then the Object already exists.
	 */
	public int alreadyExists(FoodItem item) {
		// For loop up to array size
		for (int index = 0; index < inventory.length; index++) {
			// if index is not equal to null, check each one
			if (inventory[index] != null) {
				// If itemCode matches isEqual method then item code already exists.
				if (inventory[index].isEqual(item) == true) {
					System.out.print("Item code already exists\n");
					return index;
				}
			}
		}
		return -1;
	}

	/**
	 * This method determines whether user wants to add fruit, vegetable
	 * preservatives or grains. It will create new instances of each sub class, and
	 * then take in correct data type input, and add a object into the inventory
	 * array.
	 * 
	 * @param scanner - Scanner from Main class
	 * @return - true when every data type is enter correctly.
	 */
	public boolean addItem(Scanner scanner) {
		/**
		 * Initialize user option string
		 */
		String userOption = null;
		/**
		 * Boolean condition for do while loops.
		 */
		boolean validInput;

		// Do while loop if User enters invalid option, it will ask for the input again
		// to exit loop.
		do {
			System.out.print("Do you wish to add a fruit(f), vegetable(v), preserve(p) or a grain(g)? ");
			userOption = scanner.next();
			// If user selects f
			if (userOption.equalsIgnoreCase("f")) {
				// For loop up to Inventory array size
				for (int index = 0; index < inventory.length; index++) {
					// If the index is null create new instance of Fruit,
					// Take in the inputCode, check to see if it exists, and then add it to the
					// index.
					if (inventory[index] == null) {
						Fruit myFruit = new Fruit();
						myFruit.inputCode(scanner);
						if (alreadyExists(myFruit) >= 0) {
							break;
						}
						myFruit.addItem(scanner);
						inventory[index] = myFruit;
						break;
					}
				}
			}
			// If user selects v
			if (userOption.equalsIgnoreCase("v")) {
				// For loop up to Inventory array size
				for (int index = 0; index < inventory.length; index++) {
					// If the index is null create new instance of Vegetable,
					// Take in the inputCode, check to see if it exists, and then add it to the
					// index.
					if (inventory[index] == null) {
						Vegetable myVegetable = new Vegetable();
						myVegetable.inputCode(scanner);
						if (alreadyExists(myVegetable) >= 0) {
							break;
						}
						myVegetable.addItem(scanner);
						inventory[index] = myVegetable;
						break;
					}
				}
			}
			// If user selects p
			if (userOption.equalsIgnoreCase("p")) {
				// For loop up to Inventory array size
				for (int index = 0; index < inventory.length; index++) {
					// If the index is null create new instance of Preserve,
					// Take in the inputCode, check to see if it exists, and then add it to the
					// index.
					if (inventory[index] == null) {
						Preserve myPreserve = new Preserve();
						myPreserve.inputCode(scanner);
						if (alreadyExists(myPreserve) >= 0) {
							break;
						}
						myPreserve.addItem(scanner);
						inventory[index] = myPreserve;
						break;
					}
				}

			}
			// If user selects g
			if (userOption.equalsIgnoreCase("g")) {
				// For loop up to Inventory array size
				for (int index = 0; index < inventory.length; index++) {
					// If the index is null create new instance of Grain,
					// Take in the inputCode, check to see if it exists, and then add it to the
					// index.
					if (inventory[index] == null) {
						Grain myGrain = new Grain();
						myGrain.inputCode(scanner);
						if (alreadyExists(myGrain) >= 0) {
							break;
						}
						myGrain.addItem(scanner);
						inventory[index] = myGrain;
						break;
					}
				}

			}

			validInput = false;
			// If user selects anything other than f,v,p print invalid entry.
			if (!userOption.equalsIgnoreCase("f") && !userOption.equalsIgnoreCase("v")
					&& !userOption.equalsIgnoreCase("p") && !userOption.equalsIgnoreCase("g")) {
				System.out.print("Invalid entry\n");
				validInput = true;
			}

		} while (validInput);
		// If adding new Object is successful add 1 to numItems.
		numItems = numItems + 1;

		return true;
	}

	/**
	 * This method determines whether the user would like to buy or sell an Object.
	 * Whether they decide to buy or sell, this method will update the number of
	 * quantity available in the object.
	 * 
	 * @param scanner   - Scanner from Main class
	 * @param buyOrSell - If true the user is buying, if false the user is selling.
	 * @return - If returns true, the quantity has be updated in the inventory.
	 */
	public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
		/**
		 * Boolean that will check if item code exists, if not it will print out
		 * Error...could not buy item
		 */
		boolean codeCheck = false;
		/**
		 * Do while boolean condition
		 */
		boolean validInput;
		/**
		 * Initialize itemCode requested
		 */
		int userItemCode = 0;
		/**
		 * Initialize the amount the user is going to be entering.
		 */
		int userQuantity = 0;

		// If boolean is true, execute the buying condition
		if (buyOrSell == true) {
			// To check if first Index is null, if its null that means they're no objects in
			// the array yet.
			if (inventory[0] != null) {

				// Do while to ensure correct data type is entered.
				do {
					System.out.print("Enter valid item code: ");
					try {
						userItemCode = scanner.nextInt();
						validInput = false;
					} catch (InputMismatchException ime) {
						System.out.print("Invalid code\n");
						scanner.nextLine();
						validInput = true;
					}

				} while (validInput);

				// Check do while for test condition
				// Enhanced for loop
				for (FoodItem inventory : inventory) {

					// If index item code is equal to the requested user input
					if (inventory != null) {
						// If inventory itemCode matches requested Code
						if (inventory.itemCode == userItemCode) {
							// Do while until user enters a integer

							System.out.print("Enter valid quantity to buy: ");
							try {
								userQuantity = scanner.nextInt();
								// If the amount user enter is below 0, ask to enter again.
								if (userQuantity < 0) {
									System.out.print("Invalid quantity...\nError...could not buy item.\n");
								}

								else {
									// inventory[index].updateItem(userQuantity);
									inventory.updateItem(userQuantity);
									return true;
								}

							} catch (InputMismatchException ime) {
								System.out.print("Invalid quantity...\nError...could not buy item.");
								scanner.nextLine();

							}
							codeCheck = true;
						}
					}
				}
				// If codeCheck is false, print error message
				if (!codeCheck) {
					System.out.print("Code not found in inventory...\nError...could not buy item\n");
				}
				// If index[0] is null then array has no objects.
			} else {
				System.out.print("Error...could not buy item\n");
			}
		}
		// no neg input working yet
		// If false, then user is selling
		if (buyOrSell == false) {
			// If null then array hasn't been used yet
			if (inventory[0] != null) {
				// Do while to ensure Integer is enter for itemCode
				do {
					System.out.print("Enter valid item code: ");
					try {
						userItemCode = scanner.nextInt();
						validInput = false;
					} catch (InputMismatchException ime) {
						System.out.print("Invalid quantity...\nError...could not buy item.\n");
						scanner.nextLine();
						validInput = true;
					}
				} while (validInput);

				// For loop goes through entire array
				for (FoodItem inventory : inventory) {
					// if Inventory is not null
					if (inventory != null) {
						// If inventory itemCode matches requested itemCode
						if (inventory.itemCode == userItemCode) {
							// Do while to ensure user enters Integer for selling amount

							System.out.print("Enter valid quantity to sell: ");
							try {
								userQuantity = scanner.nextInt();
								// amount is greater than Object quantity, print error message
								if (userQuantity > inventory.itemQuantityInStock) {
									System.out.print(
											"Insufficient stock in inventory...\nError...could not sell item.\n");
								}
								// if Amount is less than 0, print error message
								if (userQuantity < 0) {
									System.out.print("Invalid quantity...\nError...could not sell item.\n");
								}

								else {
									// Multiple amount by -1 because updateItem adds both variables together
									userQuantity = userQuantity * (-1);
									// inventory[index].updateItem(userQuantity);
									inventory.updateItem(userQuantity);
									return true;
								}

							} catch (InputMismatchException ime) {
								System.out.print("Invalid quantity...\nError...could not sell item\n");
								scanner.nextLine();
							}
							codeCheck = true;
						}
					} // End of if Inventory != null
				} // End of Enhanced For Loop
				if (!codeCheck) {
					System.out.print("Code not found in inventory...\nError...could not sell item\n");
				}
			} // End of If inventory[0] != null
			else {
				System.out.print("Error...could not sell item\n");
			}
		} // End of Boolean if statement

		return false;
	}

}
