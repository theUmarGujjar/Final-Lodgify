package RestaurantManagement;


import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<FoodItem> menuItems;
    private Scanner input;

    // Constructors
    public Menu() {
        this(new ArrayList<>());
    }

    public Menu(ArrayList<FoodItem> menuItems) {
        setMenuItems(menuItems);
    }
    public Menu(Menu menu) {
        this(new ArrayList<>(menu.getMenuItems()));
    }

//    getter setter

    public ArrayList<FoodItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<FoodItem> menuItems) {
        this.menuItems = menuItems;
    }

    // Menu control
    public void menuControl() {
        input = new Scanner(System.in);

        while (true) {
            System.out.println("##################################### Menu Portal #####################################");
            System.out.println("You are in Menu");
            System.out.println("Enter 0 to Exit menu item");
            System.out.println("Enter 1 to Add new menu item");
            System.out.println("Enter 2 to Update menu item");
            System.out.println("Enter 3 to Delete menu item");
            System.out.println("Enter 4 to View menu item");
            System.out.println("#####################################################################################");

            int choice =  Restaurant.getUserChoice();
            ItemStatus itemStatus=ItemStatus.chooseStatus(choice);
            switch (itemStatus) {
                case EXIT:
                    System.out.println("Exiting the Menu");
                    return;
                case ADD:
                    System.out.println("--------------------------Add New Menu Item--------------------------");
                    addMenuItems();
                    break;

                case UPDATE:

                    System.out.println("--------------------------Update Menu Item---------------------------");
                    updateItem();
                    break;
                case REMOVE:


                    System.out.println("--------------------------Delete Menu Item---------------------------");
                    deleteItem();
                    break;
                case VIEW:

                    System.out.println("--------------------------Display Menu Items--------------------------");
                    displayMenu();
                    break;
                default:
                    System.out.println("Invalid Choice!!");
                    input.nextLine();
                    System.out.println("Try Again...");
                    System.out.println();
                    break;
            }

        }
    }

    public boolean duplicateChecker(FoodItem item, int skipIndex) {
        for (int i = 0; i < menuItems.size(); i++) {
            if (i != skipIndex && menuItems.get(i).getName().equals(item.getName())) {
                return true;
            }
        }
        return false;
    }

    public void displayMenu() {
        System.out.println("*******************************************************************************");
        if (menuItems.isEmpty()) {
            System.out.println("No item available in menu");
        } else {
            for (FoodItem item : menuItems) {
                System.out.println(item);
                System.out.println("--------------");
            }
        }
        System.out.println("*******************************************************************************");
    }



    public void addMenuItems() {
        FoodItem item = new FoodItem();
        item.setEverythingManually();
        System.out.println("((((((((((((((Result: ))))))))))))))");

        if (duplicateChecker(item, -1)) {
            System.out.println("Duplicate item found");
            System.out.println("You should update this item");
            return;
        }


        menuItems.add(item);
        System.out.println("Item added successfully.");
    }

    public void updateItem() {
        if (menuItems.isEmpty()) {
            System.out.println("((((((((((((((Result: ))))))))))))))");
            System.out.println("No item available in menu to update");
            return;
        }

        System.out.println("Enter the name of the menu item: ");
        String name = input.nextLine().trim().toLowerCase();
        int index = findItemIndexByName(name);

        if (index == -1) {
            System.out.println("((((((((((((((Result: ))))))))))))))");
            System.out.println("Item not found");
            return;
        }

        FoodItem previousItem = menuItems.get(index);

        System.out.println("Going to update item name: " + previousItem.getName());
        menuItems.get(index).setEverythingManually();

        if (duplicateChecker(menuItems.get(index), index)) {
            System.out.println("((((((((((((((Result: ))))))))))))))");
            System.out.println("Item cannot be updated because an item with a similar name is found.");
            menuItems.set(index, previousItem); // Revert to previous item
            return;
        }
        System.out.println("((((((((((((((Result: ))))))))))))))");
        System.out.println("Item updated successfully.");
    }

    public void deleteItem() {
        if (menuItems.isEmpty()) {
            System.out.println("((((((((((((((Result: ))))))))))))))");
            System.out.println("No item available in menu to delete");
            return;
        }
        int choice ;
        while(true) {
            System.out.println("Enter 0 to go back");
            System.out.println("Enter 1 to delete item by name ");
            System.out.println("Enter 2 to delete all items ");
            choice =  Restaurant.getUserChoice();
            switch (choice) {
                case 0:
                    System.out.println("((((((((((((((Result: ))))))))))))))");
                    System.out.println("No item deleted");
                    return;
                case 1:
                    System.out.println("Enter the name of the menu item: ");
                    String name = input.nextLine().trim().toLowerCase();
                    deleteItemByName(name);

                    return;

                case 2:
                    menuItems.clear();
                    System.out.println("((((((((((((((Result: ))))))))))))))");
                    System.out.println("All Items deleted successfully.");
                    return;
            }
        }
    }




    private int findItemIndexByName(String name) {
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private void deleteItemByName(String name) {
        System.out.println("((((((((((((((Result: ))))))))))))))");
        System.out.println();
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getName().equalsIgnoreCase(name)) {
                menuItems.remove(i);
                System.out.println("Item " + name + " deleted successfully.");
                return;
            }
        }
        System.out.println("Item with the name " + name + " not found");
        System.out.println("You have to delete it again.");
    }
}
