import java.util.Scanner;

/**
 * The purpose of this class is be the sub class for the Object FoodItem. It
 * is inheriting information from the parent class FoodItem.
 * 
 * @author Solomon Thangthong
 * @version 1.0
 * @since 11.0
 **/
public class Vegetable extends FoodItem {
	/**
	 * The name of the farms where the vegetable come from.
	 */
	String farmName;

	/**
	 * Constructor that calls the superclass constructor
	 */
	public Vegetable() {
		super(0, null, 0, 0, 0);

	}

	/**
	 * This method concatenates Option 2, when user asks to display the inventory.
	 */
	
	public String toString() {

		String concatenate = "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $"
				+ String.format("%.2f", itemPrice) + " cost: $" + String.format("%.2f", itemCost) + " farm supplier: "
				+ farmName + "\n";
		return concatenate;
	}

	/**
	 * This method calls the super class of addItem, alongside adds the name of the
	 * farm that the vegetables are being purchased from.
	 */
	public boolean addItem(Scanner scanner) {

		super.addItem(scanner);
		System.out.print("Enter the name of the farm supplier: ");
		scanner.nextLine();
		farmName = scanner.nextLine();

		return (farmName != null);

	}
}