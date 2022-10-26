import java.util.Scanner;

/**
 * The purpose of this class is be the sub class for the Object FoodItem. It
 * is inheriting information from the parent class FoodItem.
 * 
 * @author Solomon Thangthong
 * @version 1.0
 * @since 11.0
 **/
public class Fruit extends FoodItem {
	/**
	 * The name of the farms where the fruit come from.
	 */
	private String orchardName;

	/**
	 * Match the super class constructor.
	 */
	public Fruit() {
		super(0, null, 0, 0, 0);

	}

	/**
	 * This method concatenates Option 2, when user asks to display the inventory.
	 */
	public String toString() {

		String concatenate = "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $"
				+ String.format("%.2f", itemPrice) + " cost: $" + String.format("%.2f", itemCost) + " orchard supplier: " + orchardName
				+ "\n";

		return concatenate;
	}

	/**
	 * This method calls the super class of addItem, alongside adds the supplier
	 * name.
	 */
	public boolean addItem(Scanner scanner) {

		super.addItem(scanner);
		System.out.print("Enter the name of the orchard supplier: ");
		scanner.nextLine();
		orchardName = scanner.nextLine();

		return (orchardName != null);

	}
}
