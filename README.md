# Produce-Inventory
This application is a grocery produce inventory application built in Java. The application takes in the item codes, names, quantities, costs, spelling points, and suppliers, and places them into the inventory. Another feature of this application is to display current items in stock. 
## How to run this application
Windows   
- Download source files
- Open command prompt in directory where the project files
- Compile in command prompt 
```
javac ProduceInventory.java
```
- Run program 
```
java ProduceInventory
```
### Example
This is an example of adding an item into the inventory & displaying the item afterwards.
``` 
Please select one of the following:
1. Add Item to Inventory
2. Display Current Inventory
3. Buy Item(s)
4. Sell Item(s)
5. To Exit

1
Do you wish to add a fruit(f), vegetable(v), preserve(p) or a grain(g)? f
Enter the code for the item: 123
Enter the name for the item: Apple
Enter the quantity for the item: 50
Enter the cost of the item: .10
Enter the sales price of the item: .25
Enter the name of the orchard supplier: Apple Orchard
Please select one of the following:
1. Add Item to Inventory
2. Display Current Inventory
3. Buy Item(s)
4. Sell Item(s)
5. To Exit
2
Inventory:
Item: 123 Apple 50 price: $0.25 cost: $0.10 orchard supplier: Apple Orchard
Please select one of the following:
1. Add Item to Inventory
2. Display Current Inventory
3. Buy Item(s)
4. Sell Item(s)
5. To Exit
```
